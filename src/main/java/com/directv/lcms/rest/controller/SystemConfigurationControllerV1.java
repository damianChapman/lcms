package com.directv.lcms.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "System configuration API V1")
@RequestMapping("/api/v1")
public class SystemConfigurationControllerV1 {
    private static final Logger log = LoggerFactory.getLogger(SystemConfigurationControllerV1.class);

    @RequestMapping(value = "/configuration/thread/video", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Configures the default audio used during for thread multiviewer tuning.",
            notes = "")
    private ResponseEntity defaultThreadVideoConfiguration(@ApiParam(value = "Default video bitrate that will be routed " +
            "to the “Variant Bitrate 1” window of the thread " +
            "multiviewer when a channel is selected.")
                                                           @RequestParam String vidBitrate1,
                                                           @ApiParam(value = "Default video bitrate that will be routed " +
                                                                   "to the “Variant Bitrate 2” window of the thread " +
                                                                   "multiviewer when a channel is selected.")
                                                           @RequestParam String vidBitrate2,
                                                           @ApiParam(value = "Default video streaming bitrate that will " +
                                                                   "be routed to any multiviewer window that monitors " +
                                                                   "streaming video.")
                                                           @RequestParam String vidStreamingBitrate) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/configuration/thread/audio", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Configures the default audio used during for thread multiviewer tuning.",
            notes = "")
    private ResponseEntity defaultThreadAudioConfiguration(@ApiParam(value = "Default audio bitrate that will be routed " +
            "to the TS output of the thread multiviewer when " +
            "“Variant Bitrate 1” audio monitoring has been requested.")
                                                           @RequestParam String audBitrate1,
                                                           @ApiParam(value = "Default audio bitrate that will be routed " +
                                                                   "to the TS output of the thread multiviewer when " +
                                                                   "“Variant Bitrate 2” audio monitoring has " +
                                                                   "been requested.")
                                                           @RequestParam String audBitrate2,
                                                           @ApiParam(value = "Default audio streaming bitrate that will " +
                                                                   "be routed to the TS output of the thread multiviwer " +
                                                                   "when streaming audio monitoring been requested.")
                                                           @RequestParam String audStreamingBitrate) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
