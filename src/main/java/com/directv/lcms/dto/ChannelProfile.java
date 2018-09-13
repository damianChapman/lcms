package com.directv.lcms.dto;

public class ChannelProfile {
    private float id;
    private String title;
    private float notification_set_id;
    private float event_rule_set_id;
    private float is_default;
    private float is_scanned;
    private float is_scrambled;


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getNotification_set_id() {
        return notification_set_id;
    }

    public float getEvent_rule_set_id() {
        return event_rule_set_id;
    }

    public float getIs_default() {
        return is_default;
    }

    public float getIs_scanned() {
        return is_scanned;
    }

    public float getIs_scrambled() {
        return is_scrambled;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNotification_set_id(float notification_set_id) {
        this.notification_set_id = notification_set_id;
    }

    public void setEvent_rule_set_id(float event_rule_set_id) {
        this.event_rule_set_id = event_rule_set_id;
    }

    public void setIs_default(float is_default) {
        this.is_default = is_default;
    }

    public void setIs_scanned(float is_scanned) {
        this.is_scanned = is_scanned;
    }

    public void setIs_scrambled(float is_scrambled) {
        this.is_scrambled = is_scrambled;
    }
}