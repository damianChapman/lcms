package com.directv.lcms.dto;

import java.util.List;

public class Encoder {
    private long encoder_codec_type_id;
    private long audio_alarm_agent_id;
    private long device_id;
    private List<TransportStream> transportStream;
    private long vbv_limit;
    private long encoder_gop_size_mode_id;
    private long error_display_agent_id;
    private List<OutputStream> outputStream;
    private String modified;
    private long encoder_frame_rate_id;
    private long id;
    private int is_enabled;
    private String title;
    private String created;
    private List<Layout> Layouts;
    private long layout_change_interval;
    private long encoder_gop_size_id;
    private long video_bitrate;
    private int is_deblocking;

    public long getEncoder_codec_type_id() {
        return encoder_codec_type_id;
    }

    public void setEncoder_codec_type_id(long encoder_codec_type_id) {
        this.encoder_codec_type_id = encoder_codec_type_id;
    }

    public long getAudio_alarm_agent_id() {
        return audio_alarm_agent_id;
    }

    public void setAudio_alarm_agent_id(long audio_alarm_agent_id) {
        this.audio_alarm_agent_id = audio_alarm_agent_id;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }


    public long getVbv_limit() {
        return vbv_limit;
    }

    public void setVbv_limit(long vbv_limit) {
        this.vbv_limit = vbv_limit;
    }

    public long getEncoder_gop_size_mode_id() {
        return encoder_gop_size_mode_id;
    }

    public void setEncoder_gop_size_mode_id(long encoder_gop_size_mode_id) {
        this.encoder_gop_size_mode_id = encoder_gop_size_mode_id;
    }

    public long getError_display_agent_id() {
        return error_display_agent_id;
    }

    public void setError_display_agent_id(long error_display_agent_id) {
        this.error_display_agent_id = error_display_agent_id;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public long getEncoder_frame_rate_id() {
        return encoder_frame_rate_id;
    }

    public void setEncoder_frame_rate_id(long encoder_frame_rate_id) {
        this.encoder_frame_rate_id = encoder_frame_rate_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(int is_enabled) {
        this.is_enabled = is_enabled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public List<Layout> getLayouts() {
        return Layouts;
    }

    public void setLayouts(List<Layout> Layouts) {
        this.Layouts = Layouts;
    }

    public long getLayout_change_interval() {
        return layout_change_interval;
    }

    public void setLayout_change_interval(long layout_change_interval) {
        this.layout_change_interval = layout_change_interval;
    }

    public long getEncoder_gop_size_id() {
        return encoder_gop_size_id;
    }

    public void setEncoder_gop_size_id(long encoder_gop_size_id) {
        this.encoder_gop_size_id = encoder_gop_size_id;
    }

    public long getVideo_bitrate() {
        return video_bitrate;
    }

    public void setVideo_bitrate(long video_bitrate) {
        this.video_bitrate = video_bitrate;
    }

    public int getIs_deblocking() {
        return is_deblocking;
    }

    public void setIs_deblocking(int is_deblocking) {
        this.is_deblocking = is_deblocking;
    }

    public List<TransportStream> getTransportStream() {
        return transportStream;
    }

    public void setTransportStream(List<TransportStream> transportStream) {
        this.transportStream = transportStream;
    }

    public List<OutputStream> getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(List<OutputStream> outputStream) {
        this.outputStream = outputStream;
    }
}

