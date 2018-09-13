package com.directv.lcms.service;

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
import org.springframework.data.web.JsonPath;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Value("${tag.encoder.url}")
    private String encoderUrl;

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
                for(Object jsonObject : jsonArray) {
                    ChannelSource channelSource = objectMapper.readValue(((JSONObject) jsonObject).get("ChannelSource").toString(), ChannelSource.class);
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

    public Optional<Encoder> getEncoder(String id) {
        Encoder encoder = null;
        try {
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
                for (int i = 0; i < outputStreams.length(); i++) {
                    outputStreamList.add(objectMapper.readValue(outputStreams.get(i).toString(), OutputStream.class));
                }
                JSONArray layouts = encoderJson.getJSONArray("Layouts");
                for (int i = 0; i < layouts.length(); i++) {
                    layoutList.add(objectMapper.readValue(layouts.get(i).toString(), Layout.class));
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
}



