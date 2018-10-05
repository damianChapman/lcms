package com.directv.lcms.dto.v3;

import io.swagger.annotations.ApiModel;

import java.util.List;

public class Layout {
    private long id;
    private String uuid;
    List<Source> sources;

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

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}