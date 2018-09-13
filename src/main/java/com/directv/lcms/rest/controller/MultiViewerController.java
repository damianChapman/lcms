package com.directv.lcms.rest.controller;

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
@Api(value = "Multiviewer API")
@RequestMapping("/api")
public class MultiViewerController {
    private static final Logger log = LoggerFactory.getLogger(MultiViewerController.class);

    @Resource
    public MultiViewerService multiViewerService;

    @RequestMapping(value = "/{version}/multiviewer", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Creates a new multiviewer and places it in the Control System multiviewer inventory.",
            notes = "")
    private MultiViewer createMultiViewer(@PathVariable String version,
                                          @ApiParam(value = "Name of multiviewer.")
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

    @RequestMapping(value = "/{version}/multiviewer/{name}", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Updates a multiviewer in the Control System multiviewer inventory.",
            notes = "At least one parameter is required for successful update.")
    private MultiViewer updateMultiViewer(@PathVariable String version,
                                          @ApiParam(value = "Name of multiviewer.")
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

    @RequestMapping(value = "/{version}/multiviewers", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Deletes all multiviewers in the Control System multiviewer inventory.",
            notes = "")
    private ResponseEntity deleteAllMultiViewers() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{version}/multiviewer/{name}", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Deletes one multiviewer from the Control System multiviewer inventory.",
            notes = "")
    private ResponseEntity deleteMultiViewer(@PathVariable String name) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{version}/multiviewer/mosaic/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
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

    @RequestMapping(value = "/{version}/multiviewer/scantask", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Posts the TAG MCM-9000 scan task.",
            notes = "")
    private ResponseEntity postScanTask(@ApiParam(value = "scan task.")
                                        @RequestBody ScanTask scanTask) {
        Optional<ScanTask> task = multiViewerService.createScannerTask(scanTask);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/{version}/multiviewer/channel/configurations", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Gets the TAG MCM-9000 channel configurations.",
            notes = "")
    private ResponseEntity getChannelConfigurations() {
        Optional<List<ChannelSource>> configurations = multiViewerService.getChannelConfigurations();
        if (configurations.isPresent()) {
            return ResponseEntity.ok(configurations.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @RequestMapping(value = "/{version}/multiviewer/output/layout/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
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

    @RequestMapping(value = "/{version}/multiviewer/encoder/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
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

    private void validate(@RequestParam(value = "function", required = false) String function, @RequestParam(value = "manifestUrl", required = false) String manifestUrl) {
        if (StringUtils.isBlank(function) && StringUtils.isBlank(manifestUrl)) {
            throw new IllegalArgumentException("At least one parameter is required for successful update.");
        }
    }
}
