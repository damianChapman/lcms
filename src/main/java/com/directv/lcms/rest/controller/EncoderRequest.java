package com.directv.lcms.rest.controller;

import com.directv.lcms.dto.Encoder;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by scartana on 04/10/18.
 */
public class EncoderRequest {

    @JsonProperty("Encoder")
    private Encoder encoder;

    public EncoderRequest() {
    }

    public EncoderRequest(Encoder encoder) {
        this.encoder = encoder;
    }

    public Encoder getEncoder() {
        return encoder;
    }

    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }
}

