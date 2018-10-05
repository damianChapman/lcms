package com.directv.lcms.service;

import com.directv.lcms.dto.AudioPidStatistics;
import com.directv.lcms.dto.ChannelSource;
import com.directv.lcms.dto.Encoder;
import com.directv.lcms.dto.EncoderStatus;
import com.directv.lcms.dto.Layout;
import com.directv.lcms.dto.ScanTask;
import com.directv.lcms.rest.controller.EncoderRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MultiViewerService {
    private static final Logger log = LoggerFactory.getLogger(MultiViewerService.class);

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Value("${tag.mosaic.url}")
    private String mosaicUrl;

    @Value("${mosaic.ip.address}")
    private String mosaicAddress;

    @Value("${tag.scanner.task.url}")
    private String scannerTaskUrl;

    @Value("${tag.channel.config.url}")
    private String channelConfigUrl;

    @Value("${tag.output.layout.url}")
    private String outputLayoutUrl;

    @Value("${tag.output.layouts.url}")
    private String outputLayoutsUrl;

    @Value("${tag.encoder.url}")
    private String encoderUrl;

    @Value("${tag.encoders.url}")
    private String encodersUrl;

    @Value("${tag.username}")
    private String username;

    @Value("${tag.password}")
    private String password;

    @Value("${tag.audio.pids.statistics.url}")
    private String audioPidsStatisticsUrl;

    @PostConstruct
    private void init() {
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
    }

    public Optional<EncoderStatus> getMosaic(String id) {
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(mosaicUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONObject jsonObject = new JSONObject(responseEntity.getBody());
                EncoderStatus encoderStatus = objectMapper.readValue(jsonObject.get("EncoderStatus").toString(), EncoderStatus.class);
                encoderStatus.setIp_address(mosaicAddress);
                return Optional.of(encoderStatus);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error getting multiviewer mosaic", e);
        }
        return Optional.empty();
    }

    public ResponseEntity<String> createScannerTask(ScanTask scanTask) {
        return restTemplate.postForEntity(scannerTaskUrl, scanTask, String.class);
    }

    public Optional<List<ChannelSource>> getChannelConfigurations() {
        List<ChannelSource> channelSourceList = new ArrayList<>();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(channelConfigUrl, String.class);
        try {
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONArray jsonArray = new JSONArray(responseEntity.getBody());
                for (int i = 0; i < jsonArray.length(); i++) {
                    String channelSourceJson = jsonArray.getJSONObject(i).get("ChannelSource").toString();
                    ChannelSource channelSource = objectMapper.readValue(channelSourceJson, ChannelSource.class);
                    channelSourceList.add(channelSource);
                }

                return Optional.of(channelSourceList);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error getting multiviewer channel configurations", e);
        }
        return Optional.empty();
    }

    public Optional<Layout> getOutputLayout(String id) {
        try {
            String layoutUrl = outputLayoutUrl.replace("{id}", id);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(layoutUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONObject jsonObject = new JSONObject(responseEntity.getBody());
                String layoutJson = jsonObject.get("Layout").toString();
                Layout layout = objectMapper.readValue(layoutJson, Layout.class);
                return Optional.of(layout);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error getting multiviewer output layout", e);
        }
        return Optional.empty();
    }

    public Optional<List<Layout>> getOutputLayouts() {
        List<Layout> layoutList = new ArrayList<>();
        try {
            log.info(String.format("Output layouts URL is %s", outputLayoutsUrl));
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(outputLayoutsUrl, String.class);
            log.info(String.format("Response is %s", responseEntity.getBody()));
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONArray layouts = new JSONArray(responseEntity.getBody());
                for (int i = 0; i < layouts.length(); i++) {
                    JSONObject layoutJsonObject = (JSONObject) layouts.get(i);
                    String layoutJson = layoutJsonObject.get("Layout").toString();
                    Layout layout = objectMapper.readValue(layoutJson, Layout.class);

                    layoutList.add(layout);
                }
                return Optional.of(layoutList);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error getting multiviewer output layouts", e);
        }
        return Optional.empty();
    }

    public Optional<Encoder> getEncoder(String id) {
        try {
            encoderUrl = encoderUrl.replace("{id}", id);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(encoderUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONObject jsonObject = new JSONObject(responseEntity.getBody());
                String encoderJson = jsonObject.get("Encoder").toString();
                Encoder encoder = objectMapper.readValue(encoderJson, Encoder.class);
                return Optional.of(encoder);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error getting multiviewer output encoder", e);
        }
        return Optional.empty();
    }

    public ResponseEntity<String> putEncoder(String id, Encoder encoder) {
        encoderUrl = encoderUrl.replace("{id}", id);
        HttpEntity<Encoder> httpEntity = new HttpEntity<>(encoder);
        return restTemplate.exchange(encoderUrl, HttpMethod.PUT, httpEntity, String.class);
    }

    public Optional<List<Encoder>> getEncoders() {
        List<Encoder> encoderList = new ArrayList<>();
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(encodersUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONArray encoders = new JSONArray(responseEntity.getBody());
                for (int i = 0; i < encoders.length(); i++) {
                    JSONObject encoderJsonObject = (JSONObject) encoders.get(i);
                    String encoderJson = encoderJsonObject.get("Encoder").toString();
                    Encoder encoder = objectMapper.readValue(encoderJson, Encoder.class);

                    encoderList.add(encoder);
                }
                return Optional.of(encoderList);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error getting multiviewer output encoders", e);
        }
        return Optional.empty();
    }

    public Optional<List<AudioPidStatistics>> getChannelAudioPidsStatistics() {
        List<AudioPidStatistics> audioPidStatisticsList = new ArrayList<>();
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(audioPidsStatisticsUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONArray audioPidStatistics = new JSONArray(responseEntity.getBody());
                for (int i = 0; i < audioPidStatistics.length(); i++) {
                    JSONObject audioPidStatisticsJsonObject = (JSONObject) audioPidStatistics.get(i);
                    JSONObject audioPidStatisticJson = (JSONObject) audioPidStatisticsJsonObject.get("AudioPidStatistics");
                    audioPidStatisticsList.add(objectMapper.readValue(audioPidStatisticJson.toString(), AudioPidStatistics.class));
                }
                return Optional.of(audioPidStatisticsList);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error getting channel audio pids statistics", e);
        }
        return Optional.empty();
    }

    public ResponseEntity<String> updateLayoutofEncoder(String encoderId, String layoutId) {

        Encoder encoder = getEncoder(encoderId).get();
        Layout layout = getOutputLayout(layoutId).get();
        List<Layout> layouts = new ArrayList<>(Arrays.asList(layout));
        encoder.setLayouts(layouts);
        encoderUrl = encoderUrl.replace("{id}", encoderId);
        EncoderRequest encoderRequest = new EncoderRequest(encoder);
        String encoderRequestJson = null;
        try {
            encoderRequestJson = objectMapper.writeValueAsString(encoderRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        HttpEntity<String> httpEntity = new HttpEntity<>(encoderRequestJson);

        return restTemplate.exchange(encoderUrl, HttpMethod.PUT, httpEntity, String.class);
    }

}



