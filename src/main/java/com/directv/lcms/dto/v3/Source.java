package com.directv.lcms.dto.v3;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Source {
    private String url;
    private String secondary_url;
    private long access_type_id;
    private long service_type_id;
    private String title;
    private String primary_umd;
    private String secondary_umd;
    private long layout_box_id;
    private String coordinates;
    private int is_persistent;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecondary_url() {
        return secondary_url;
    }

    public void setSecondary_url(String secondary_url) {
        this.secondary_url = secondary_url;
    }

    public long getAccess_type_id() {
        return access_type_id;
    }

    public void setAccess_type_id(long access_type_id) {
        this.access_type_id = access_type_id;
    }

    public long getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(long service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimary_umd() {
        return primary_umd;
    }

    public void setPrimary_umd(String primary_umd) {
        this.primary_umd = primary_umd;
    }

    public String getSecondary_umd() {
        return secondary_umd;
    }

    public void setSecondary_umd(String secondary_umd) {
        this.secondary_umd = secondary_umd;
    }

    public long getLayout_box_id() {
        return layout_box_id;
    }

    public void setLayout_box_id(long layout_box_id) {
        this.layout_box_id = layout_box_id;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public int getIs_persistent() {
        return is_persistent;
    }

    public void setIs_persistent(int is_persistent) {
        this.is_persistent = is_persistent;
    }
}