package com.directv.lcms.rest.controller;

import com.directv.lcms.couchbase.ChannelRepositoryService;
import com.directv.lcms.dto.Channel;
import com.directv.lcms.dto.MultiViewer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ChannelController {
    private static final Logger log = LoggerFactory.getLogger(ChannelController.class);

    @Autowired
    private ChannelRepositoryService channelRepositoryService;

    @RequestMapping(value = "/{version}/channel", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Creates a new channel and places it in the Control System channel inventory.",
            notes = "Parameter list is incomplete.")
    private Channel createChannel(@PathVariable String version,
                                  @ApiParam(value = "Channel name.")
                                  @RequestParam String name,
                                  @ApiParam(value = "Channel call letters.")
                                  @RequestParam String callLetters,
                                  @ApiParam(value = "Common content identifier, or CCID.")
                                  @RequestParam String ccid,
                                  @ApiParam(value = "Environment name.")
                                  @RequestParam String environment) {

        Channel channel = new Channel();
        channel.setName(name);
        channel.setCallLetters(callLetters);
        channel.setCcid(ccid);
        channel.setEnvironment(environment);
        channelRepositoryService.create(channel);
        return channel;
    }

    @RequestMapping(value = "/{version}/channel/{name}", method = RequestMethod.PUT, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Updates a channel in the Control System channel inventory.",
            notes = "At least one parameter is required for successful update. Parameter list is incomplete.")
    private Channel updateChannel(@PathVariable String version,
                                  @ApiParam(value = "Channel name.")
                                  @PathVariable String name,
                                  @ApiParam(value = "Channel call letters.")
                                  @RequestParam String callLetters,
                                  @ApiParam(value = "Common content identifier, or CCID.")
                                  @RequestParam String ccid,
                                  @ApiParam(value = "Environment name.")
                                  @RequestParam String environment) {
        validate(callLetters, ccid, environment);
        Channel channel = new Channel();
        channel.setName(name);
        channel.setCallLetters(callLetters);
        channel.setCcid(ccid);
        channel.setEnvironment(environment);
        return channel;
    }

    @RequestMapping(value = "/{version}/channels", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Deletes all channels in the Control System channel inventory.",
            notes = "")
    private ResponseEntity deleteAllChannels() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{version}/channel/{name}", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
    @ApiOperation(value = "Deletes one channel from the Control System channel inventory.",
            notes = "")
    private ResponseEntity deleteChannel(@PathVariable String name) {
        return new ResponseEntity(HttpStatus.OK);
    }

    private void validate(@RequestParam(value = "callLetters", required = false) String callLetters,
                          @RequestParam(value = "ccid", required = false) String ccid,
                          @RequestParam(value = "environment", required = false) String environment) {
        if (StringUtils.isBlank(callLetters) && StringUtils.isBlank(ccid) && StringUtils.isBlank(environment)) {
            throw new IllegalArgumentException("At least one parameter is required for successful update.");
        }
    }
}
