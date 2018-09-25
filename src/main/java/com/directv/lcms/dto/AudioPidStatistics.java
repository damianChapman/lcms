package com.directv.lcms.dto;

public class AudioPidStatistics {
    private long id;
    private String title;
    private long pid;
    private long device_id;
    private int is_scrambled;
    private long cc_errors;
    private long bitrate;
    private long channel_source_id;
    private String codec;
    private long current_momentary;
    private long current_peak;
    private long current_short;
    private String lang;
    private String hourly_lra;
    private String hourly_peak;
    private String hourly_integrated;
    private String daily_integrated;
    private String daily_lra;
    private String modified;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getPid() {
        return pid;
    }

    public long getDevice_id() {
        return device_id;
    }

    public int getIs_scrambled() {
        return is_scrambled;
    }

    public long getCc_errors() {
        return cc_errors;
    }

    public long getBitrate() {
        return bitrate;
    }

    public long getChannel_source_id() {
        return channel_source_id;
    }

    public String getCodec() {
        return codec;
    }

    public long getCurrent_momentary() {
        return current_momentary;
    }

    public long getCurrent_peak() {
        return current_peak;
    }

    public long getCurrent_short() {
        return current_short;
    }

    public String getLang() {
        return lang;
    }

    public String getHourly_lra() {
        return hourly_lra;
    }

    public String getHourly_peak() {
        return hourly_peak;
    }

    public String getHourly_integrated() {
        return hourly_integrated;
    }

    public String getDaily_integrated() {
        return daily_integrated;
    }

    public String getDaily_lra() {
        return daily_lra;
    }

    public String getModified() {
        return modified;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    public void setIs_scrambled(int is_scrambled) {
        this.is_scrambled = is_scrambled;
    }

    public void setCc_errors(long cc_errors) {
        this.cc_errors = cc_errors;
    }

    public void setBitrate(long bitrate) {
        this.bitrate = bitrate;
    }

    public void setChannel_source_id(long channel_source_id) {
        this.channel_source_id = channel_source_id;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public void setCurrent_momentary(long current_momentary) {
        this.current_momentary = current_momentary;
    }

    public void setCurrent_peak(long current_peak) {
        this.current_peak = current_peak;
    }

    public void setCurrent_short(long current_short) {
        this.current_short = current_short;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setHourly_lra(String hourly_lra) {
        this.hourly_lra = hourly_lra;
    }

    public void setHourly_peak(String hourly_peak) {
        this.hourly_peak = hourly_peak;
    }

    public void setHourly_integrated(String hourly_integrated) {
        this.hourly_integrated = hourly_integrated;
    }

    public void setDaily_integrated(String daily_integrated) {
        this.daily_integrated = daily_integrated;
    }

    public void setDaily_lra(String daily_lra) {
        this.daily_lra = daily_lra;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}

