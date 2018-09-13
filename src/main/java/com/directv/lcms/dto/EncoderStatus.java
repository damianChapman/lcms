package com.directv.lcms.dto;

public class EncoderStatus {
    private long id;
    private long device_id;
    private String title;
    private long encoder_codec_type_id;
    private long current_layout_id;
    private long video_bitrate;
    private long total_bitrate;
    private long failed_bitrate;
    private long encoded_frame_counter;
    private long rendered_frame_counter;
    private String ip_address;
    private int port;
    private long severity_id;
    private String program_number;
    private long network_id;
    private String modified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getEncoder_codec_type_id() {
        return encoder_codec_type_id;
    }

    public void setEncoder_codec_type_id(long encoder_codec_type_id) {
        this.encoder_codec_type_id = encoder_codec_type_id;
    }

    public long getCurrent_layout_id() {
        return current_layout_id;
    }

    public void setCurrent_layout_id(long current_layout_id) {
        this.current_layout_id = current_layout_id;
    }

    public long getVideo_bitrate() {
        return video_bitrate;
    }

    public void setVideo_bitrate(long video_bitrate) {
        this.video_bitrate = video_bitrate;
    }

    public long getTotal_bitrate() {
        return total_bitrate;
    }

    public void setTotal_bitrate(long total_bitrate) {
        this.total_bitrate = total_bitrate;
    }

    public long getFailed_bitrate() {
        return failed_bitrate;
    }

    public void setFailed_bitrate(long failed_bitrate) {
        this.failed_bitrate = failed_bitrate;
    }

    public long getEncoded_frame_counter() {
        return encoded_frame_counter;
    }

    public void setEncoded_frame_counter(long encoded_frame_counter) {
        this.encoded_frame_counter = encoded_frame_counter;
    }

    public long getRendered_frame_counter() {
        return rendered_frame_counter;
    }

    public void setRendered_frame_counter(long rendered_frame_counter) {
        this.rendered_frame_counter = rendered_frame_counter;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public long getSeverity_id() {
        return severity_id;
    }

    public void setSeverity_id(long severity_id) {
        this.severity_id = severity_id;
    }

    public String getProgram_number() {
        return program_number;
    }

    public void setProgram_number(String program_number) {
        this.program_number = program_number;
    }

    public long getNetwork_id() {
        return network_id;
    }

    public void setNetwork_id(long network_id) {
        this.network_id = network_id;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}
