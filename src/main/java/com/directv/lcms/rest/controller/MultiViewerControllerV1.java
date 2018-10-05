package com.directv.lcms.rest.controller;

import com.directv.lcms.dto.AudioPidStatistics;
import com.directv.lcms.dto.ChannelSource;
import com.directv.lcms.dto.Encoder;
import com.directv.lcms.dto.EncoderStatus;
import com.directv.lcms.dto.Layout;
import com.directv.lcms.dto.MultiViewer;
import com.directv.lcms.dto.ScanTask;
import com.directv.lcms.service.MultiViewerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Multiviewer API V1")
@RequestMapping("/api/v1")
public class MultiViewerControllerV1 {
    private static final Logger log = LoggerFactory.getLogger(MultiViewerControllerV1.class);

    @Resource
    public MultiViewerService multiViewerService;

    @RequestMapping(value = "/multiviewer", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Creates a new multiviewer and places it in the Control System multiviewer inventory.",
            notes = "")
    private MultiViewer createMultiViewer(@ApiParam(value = "Name of multiviewer.")
                                          @RequestParam String name,
                                          @ApiParam(value = "Primary function of multiviewer.")
                                          @RequestParam String function,
                                          @ApiParam(value = "Manifest URL associated with multiviewer.")
                                          @RequestParam String manifestUrl) {

        MultiViewer multiViewer = new MultiViewer();
        multiViewer.setName(name);
        multiViewer.setFunction(function);
        multiViewer.setManifestUrl(manifestUrl);
        return multiViewer;
    }

    @RequestMapping(value = "/multiviewer/{name}", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Updates a multiviewer in the Control System multiviewer inventory.",
            notes = "At least one parameter is required for successful update.")
    private MultiViewer updateMultiViewer(@ApiParam(value = "Name of multiviewer.")
                                          @PathVariable String name,
                                          @ApiParam(value = "Primary function of multiviewer.")
                                          @RequestParam(value = "function", required = false) String function,
                                          @ApiParam(value = "Manifest URL associated with multiviewer.")
                                          @RequestParam(value = "manifestUrl", required = false) String manifestUrl) {
        validate(function, manifestUrl);
        MultiViewer multiViewer = new MultiViewer();
        multiViewer.setName(name);
        multiViewer.setFunction(function);
        multiViewer.setManifestUrl(manifestUrl);
        return multiViewer;
    }

    @RequestMapping(value = "/multiviewers", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Deletes all multiviewers in the Control System multiviewer inventory.",
            notes = "")
    private ResponseEntity deleteAllMultiViewers() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/multiviewer/{name}", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Deletes one multiviewer from the Control System multiviewer inventory.",
            notes = "")
    private ResponseEntity deleteMultiViewer(@PathVariable String name) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/multiviewer/tag/mosaic/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Gets a TAG MCM-9000 mosaic.",
            notes = "")
    private ResponseEntity<EncoderStatus> getMosaic(@ApiParam(value = "id of multiviewer mosaic.")
                                                    @PathVariable String id) {
        Optional<EncoderStatus> encoderStatus = multiViewerService.getMosaic(id);
        if (encoderStatus.isPresent()) {
            return ResponseEntity.ok(encoderStatus.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/multiviewer/tag/scantask", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Posts the TAG MCM-9000 scan task.",
            notes = "")
    private ResponseEntity<String> postScanTask(@ApiParam(value = "scan task.")
                                                @RequestBody ScanTask scanTask) {
        return multiViewerService.createScannerTask(scanTask);
    }

    @RequestMapping(value = "/multiviewer/tag/channel/configurations", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Gets the TAG MCM-9000 channel configurations.",
            notes = "")
    private ResponseEntity<List<ChannelSource>> getChannelConfigurations() {
        Optional<List<ChannelSource>> configurations = multiViewerService.getChannelConfigurations();
        if (configurations.isPresent()) {
            return ResponseEntity.ok(configurations.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/multiviewer/tag/output/layout/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Gets a TAG MCM-9000 output layout.",
            notes = "")
    private ResponseEntity<Layout> getOutputLayout(@ApiParam(value = "id of multiviewer output layout.")
                                                   @PathVariable String id) {
        Optional<Layout> layout = multiViewerService.getOutputLayout(id);
        if (layout.isPresent()) {
            return ResponseEntity.ok(layout.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/multiviewer/tag/encoder/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Gets a TAG MCM-9000 encoder.",
            notes = "")
    private ResponseEntity<Encoder> getEncoder(@ApiParam(value = "id of multiviewer encoder.")
                                               @PathVariable String id) {
        Optional<Encoder> encoder = multiViewerService.getEncoder(id);
        if (encoder.isPresent()) {
            return ResponseEntity.ok(encoder.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/multiviewer/tag/encoder/{id}", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Sets a TAG MCM-9000 encoder.",
            notes = "")
    private ResponseEntity<String> putEncoder(@ApiParam(value = "the ID of the desired encoder")
                                              @PathVariable String id,
                                              @ApiParam(value = "Multiviewer encoder.")
                                              @RequestBody Encoder encoder) {
        return multiViewerService.putEncoder(id, encoder);
    }

    @RequestMapping(value = "/multiviewer/tag/encoders", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Gets a TAG MCM-9000 encoder.",
            notes = "")
    private ResponseEntity<List<Encoder>> getEncoders() {
        Optional<List<Encoder>> encoders = multiViewerService.getEncoders();
        if (encoders.isPresent()) {
            return ResponseEntity.ok(encoders.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/multiviewer/tag/channel/statistics/audio_pids_statistics", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Gets a TAG MCM-9000 channel audio pids statistics.",
            notes = "")
    private ResponseEntity<List<AudioPidStatistics>> getAudioPidsStatistics() {
        Optional<List<AudioPidStatistics>> audioPidStatisticsList = multiViewerService.getChannelAudioPidsStatistics();
        if (audioPidStatisticsList.isPresent()) {
            return ResponseEntity.ok(audioPidStatisticsList.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/multiviewer/tag/output/layouts", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Gets TAG MCM-9000 output layouts.",
            notes = "")
    private ResponseEntity<List<Layout>> getOutputLayouts() {
        Optional<List<Layout>> layoutList = multiViewerService.getOutputLayouts();
        if (layoutList.isPresent()) {
            return ResponseEntity.ok(layoutList.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/multiviewer/tag/encoder/layout/{encoderId}/{layoutId}", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Updates the encoder to associate it with a layout")
    private ResponseEntity updateEncoderLayout(@ApiParam(value = "Encoder id")
                                               @PathVariable String encoderId,
                                               @ApiParam(value = "Layout id")
                                               @PathVariable String layoutId) {
        return multiViewerService.updateLayoutofEncoder(encoderId, layoutId);
    }


    private void validate(String function, String manifestUrl) {
        if (StringUtils.isBlank(function) && StringUtils.isBlank(manifestUrl)) {
            throw new IllegalArgumentException("At least one parameter is required for successful update.");
        }
    }
}
