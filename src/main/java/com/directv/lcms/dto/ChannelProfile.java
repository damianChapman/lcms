package com.directv.lcms.dto;

public class ChannelProfile {
    private long id;
    private String title;
    private long notification_set_id;
    private long event_rule_set_id;
    private int is_default;
    private int is_scanned;
    private int is_scrambled;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getNotification_set_id() {
        return notification_set_id;
    }

    public void setNotification_set_id(long notification_set_id) {
        this.notification_set_id = notification_set_id;
    }

    public long getEvent_rule_set_id() {
        return event_rule_set_id;
    }

    public void setEvent_rule_set_id(long event_rule_set_id) {
        this.event_rule_set_id = event_rule_set_id;
    }

    public int getIs_default() {
        return is_default;
    }

    public void setIs_default(int is_default) {
        this.is_default = is_default;
    }

    public int getIs_scanned() {
        return is_scanned;
    }

    public void setIs_scanned(int is_scanned) {
        this.is_scanned = is_scanned;
    }

    public int getIs_scrambled() {
        return is_scrambled;
    }

    public void setIs_scrambled(int is_scrambled) {
        this.is_scrambled = is_scrambled;
    }
}