package com.directv.lcms.dto.v3.put;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OutputRequest {

    @JsonProperty("Output")
    private Output output;

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }
}
