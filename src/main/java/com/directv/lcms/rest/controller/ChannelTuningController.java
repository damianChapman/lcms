package com.directv.lcms.rest.controller;

import com.directv.lcms.dto.Channel;
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
@Api(value = "Channel API")
@RequestMapping("/api")
public class ChannelTuningController {
    private static final Logger log = LoggerFactory.getLogger(ChannelTuningController.class);

    @RequestMapping(value = "/{version}/tune/thread", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Populates a thread multiviewer with video associated with the channel.  " +
            "Routes audio and video from the thread multiviewer to its TS output.",
            notes = "")
    private ResponseEntity tuneThread(@PathVariable String version,
                                      @ApiParam(value = "Name of channel.")
                                      @RequestParam String channel,
                                      @ApiParam(value = "Name of multiviewer.")
                                      @RequestParam String multiviewer,
                                      @ApiParam(value = "Audio associated with window identifier to be routed to multiviewer TS output.")
                                      @RequestParam String audioWindowId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{version}/tune/monwall", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Places a single video feed in any of monitor wall multiviewer window and identifies it using custom text.",
            notes = "")
    private ResponseEntity tuneMonitorWall(@PathVariable String version,
                                           @ApiParam(value = "Name of feed.")
                                           @RequestParam String feed,
                                           @ApiParam(value = "Name of multiviewer.")
                                           @RequestParam String multiviewer,
                                           @ApiParam(value = "Window identifier in multiviewer layout.")
                                           @RequestParam String windowId,
                                           @ApiParam(value = "UMD identifier in multiviewer layout.")
                                           @RequestParam String umdId) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{version}/tune/audiomon", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Routes audio and video from the thread multiviewer to its TS output.",
            notes = "")
    private ResponseEntity tuneAudioMonitor(@PathVariable String version,
                                            @ApiParam(value = "Name of feed.")
                                            @RequestParam String channel,
                                            @ApiParam(value = "Name of multiviewer.")
                                            @RequestParam String multiviewer,
                                            @ApiParam(value = "Audio associated with window identifier to be routed to multiviewer TS output.")
                                            @RequestParam String audioWindowId) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
