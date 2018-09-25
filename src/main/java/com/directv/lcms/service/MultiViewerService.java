package com.directv.lcms.service;

import com.directv.lcms.dto.AudioPidStatistics;
import com.directv.lcms.dto.ChannelProfile;
import com.directv.lcms.dto.ChannelSource;
import com.directv.lcms.dto.Encoder;
import com.directv.lcms.dto.EncoderStatus;
import com.directv.lcms.dto.Layout;
import com.directv.lcms.dto.LayoutBox;
import com.directv.lcms.dto.OutputStream;
import com.directv.lcms.dto.ScanTask;
import com.directv.lcms.dto.TransportStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
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

    public Optional<ScanTask> createScannerTask(ScanTask scanTask) {
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(scannerTaskUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONObject jsonObject = new JSONObject(responseEntity.getBody());
                ScanTask readValue = objectMapper.readValue(jsonObject.get("ScanTask").toString(), ScanTask.class);
                return Optional.of(readValue);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error creating multiviewer scan task", e);
        }
        return Optional.empty();
    }

    public Optional<List<ChannelSource>> getChannelConfigurations() {
        try {
            List<ChannelSource> channelSourceList = new ArrayList<>();
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(channelConfigUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONArray jsonArray = new JSONArray(responseEntity.getBody());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    JSONObject channelSourceJson = (JSONObject) jsonObject.get("ChannelSource");
                    ChannelSource channelSource = objectMapper.readValue(channelSourceJson.toString(), ChannelSource.class);
                    List<ChannelProfile> channelProfileList = new ArrayList<>();
                    JSONArray channelProfiles = channelSourceJson.getJSONArray("ChannelProfile");
                    for ( int j = 0; j < channelProfiles.length(); j++) {
                        ChannelProfile channelProfile = objectMapper.readValue(channelProfiles.get(j).toString(), ChannelProfile.class);
                        channelProfileList.add(channelProfile);
                    }
                    channelSource.setChannelProfile(channelProfileList);
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
        Layout layout = null;
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(outputLayoutUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONObject jsonObject = new JSONObject(responseEntity.getBody());
                List<Encoder> encoderList = new ArrayList<>();
                List<LayoutBox> layoutBoxesList = new ArrayList<>();
                JSONObject layoutJson = (JSONObject) jsonObject.get("Layout");
                layout = objectMapper.readValue(layoutJson.toString(), Layout.class);
                JSONArray encoders = layoutJson.getJSONArray("Encoders");
                for (int i = 0; i < encoders.length(); i++) {
                    encoderList.add(objectMapper.readValue(encoders.get(i).toString(), Encoder.class));
                }
                JSONArray layoutBoxes = layoutJson.getJSONArray("LayoutBoxes");
                for (int i = 0; i < layoutBoxes.length(); i++) {
                    layoutBoxesList.add(objectMapper.readValue(layoutBoxes.get(i).toString(), LayoutBox.class));
                }
                layout.setEncoders(encoderList);
                layout.setLayoutBoxes(layoutBoxesList);

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
                    List<Encoder> encoderList = new ArrayList<>();
                    List<LayoutBox> layoutBoxesList = new ArrayList<>();
                    JSONObject layoutJsonObject = (JSONObject) layouts.get(i);
                    JSONObject layoutJson = (JSONObject) layoutJsonObject.get("Layout");
                    Layout layout = objectMapper.readValue(layoutJson.toString(), Layout.class);
                    JSONArray encoders = layoutJson.getJSONArray("Encoders");
                    for (int j = 0; j < encoders.length(); j++) {
                        encoderList.add(objectMapper.readValue(encoders.get(j).toString(), Encoder.class));
                    }
                    JSONArray layoutBoxes = layoutJson.getJSONArray("LayoutBoxes");
                    for (int k = 0; k < layoutBoxes.length(); k++) {
                        layoutBoxesList.add(objectMapper.readValue(layoutBoxes.get(k).toString(), LayoutBox.class));
                    }
                    layout.setEncoders(encoderList);
                    layout.setLayoutBoxes(layoutBoxesList);
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
        Encoder encoder = null;
        try {
            encoderUrl = encoderUrl.replace("{id}", id);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(encoderUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONObject jsonObject = new JSONObject(responseEntity.getBody());
                List<TransportStream> transportStreamList = new ArrayList<>();
                List<OutputStream> outputStreamList = new ArrayList<>();
                List<Layout> layoutList = new ArrayList<>();
                JSONObject encoderJson = (JSONObject) jsonObject.get("Encoder");
                encoder = objectMapper.readValue(encoderJson.toString(), Encoder.class);
                JSONArray transportStreams = encoderJson.getJSONArray("TransportStream");
                for (int i = 0; i < transportStreams.length(); i++) {
                    transportStreamList.add(objectMapper.readValue(transportStreams.get(i).toString(), TransportStream.class));
                }
                JSONArray outputStreams = encoderJson.getJSONArray("OutputStream");
                for (int j = 0; j < outputStreams.length(); j++) {
                    outputStreamList.add(objectMapper.readValue(outputStreams.get(j).toString(), OutputStream.class));
                }
                JSONArray layouts = encoderJson.getJSONArray("Layouts");
                for (int k = 0; k < layouts.length(); k++) {
                    layoutList.add(objectMapper.readValue(layouts.get(k).toString(), Layout.class));
                }
                encoder.setTransportStream(transportStreamList);
                encoder.setOutputStream(outputStreamList);
                encoder.setLayouts(layoutList);
                return Optional.of(encoder);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error getting multiviewer output encoder", e);
        }
        return Optional.empty();
    }

    public Optional<Encoder> putEncoder(Encoder encoder) {
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(encoderUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONObject jsonObject = new JSONObject(responseEntity.getBody());
                List<TransportStream> transportStreamList = new ArrayList<>();
                List<OutputStream> outputStreamList = new ArrayList<>();
                List<Layout> layoutList = new ArrayList<>();
                JSONObject encoderJson = (JSONObject) jsonObject.get("Encoder");
                Encoder encoderResponse = objectMapper.readValue(encoderJson.toString(), Encoder.class);
                JSONArray transportStreams = encoderJson.getJSONArray("TransportStream");
                for (int i = 0; i < transportStreams.length(); i++) {
                    transportStreamList.add(objectMapper.readValue(transportStreams.get(i).toString(), TransportStream.class));
                }
                JSONArray outputStreams = encoderJson.getJSONArray("OutputStream");
                for (int j = 0; j < outputStreams.length(); j++) {
                    outputStreamList.add(objectMapper.readValue(outputStreams.get(j).toString(), OutputStream.class));
                }
                JSONArray layouts = encoderJson.getJSONArray("Layouts");
                for (int k = 0; k < layouts.length(); k++) {
                    layoutList.add(objectMapper.readValue(layouts.get(k).toString(), Layout.class));
                }
                encoderResponse.setTransportStream(transportStreamList);
                encoderResponse.setOutputStream(outputStreamList);
                encoderResponse.setLayouts(layoutList);
                return Optional.of(encoderResponse);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            log.error("Error getting multiviewer output encoder", e);
        }
        return Optional.empty();
    }

    public Optional<List<Encoder>> getEncoders() {
        List<Encoder> encoderList = new ArrayList<>();
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(encodersUrl, String.class);
            if (StringUtils.isNotBlank(responseEntity.getBody())) {
                JSONArray encoders = new JSONArray(responseEntity.getBody());
                for (int i = 0; i < encoders.length(); i++) {
                    List<TransportStream> transportStreamList = new ArrayList<>();
                    List<OutputStream> outputStreamList = new ArrayList<>();
                    List<Layout> layoutList = new ArrayList<>();
                    JSONObject encoderJsonObject = (JSONObject) encoders.get(i);
                    JSONObject encoderJson = (JSONObject) encoderJsonObject.get("Encoder");
                    Encoder encoder = objectMapper.readValue(encoderJson.toString(), Encoder.class);
                    JSONArray transportStreams = encoderJson.getJSONArray("TransportStream");
                    for (int j = 0; j < transportStreams.length(); j++) {
                        transportStreamList.add(objectMapper.readValue(transportStreams.get(j).toString(), TransportStream.class));
                    }
                    JSONArray outputStreams = encoderJson.getJSONArray("OutputStream");
                    for (int k = 0; k < outputStreams.length(); k++) {
                        outputStreamList.add(objectMapper.readValue(outputStreams.get(k).toString(), OutputStream.class));
                    }
                    JSONArray layouts = encoderJson.getJSONArray("Layouts");
                    for (int l = 0; l < layouts.length(); l++) {
                        layoutList.add(objectMapper.readValue(layouts.get(l).toString(), Layout.class));
                    }
                    encoder.setTransportStream(transportStreamList);
                    encoder.setOutputStream(outputStreamList);
                    encoder.setLayouts(layoutList);
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
}



