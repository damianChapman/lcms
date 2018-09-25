package com.directv.lcms.dto;

public class LayoutBox {
    private long id;
    private long channel_source_id;
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChannel_source_id() {
        return channel_source_id;
    }

    public void setChannel_source_id(long channel_source_id) {
        this.channel_source_id = channel_source_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}