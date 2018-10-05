package com.directv.lcms.dto.v3.put;

import com.directv.lcms.dto.v3.Source;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Layout {
    private long id;
    private String uuid;

    @JsonProperty("Source")
    Source source;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}