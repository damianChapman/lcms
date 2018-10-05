package com.directv.lcms.dto.v3.put;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Output {
    @JsonProperty("Layout")
    private Layout layout;

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }
}
