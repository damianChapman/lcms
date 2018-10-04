package com.directv.lcms.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Encoder {
    private long encoder_codec_type_id;
    private long audio_alarm_agent_id;
    private long device_id;
    @JsonProperty("TransportStream")
    private List<TransportStream> transportStream;
    private long vbv_limit;
    private long encoder_gop_size_mode_id;
    private long error_display_agent_id;
    @JsonProperty("OutputStreams")
    private List<OutputStream> outputStream;
    private String modified;
    private long encoder_frame_rate_id;
    private long id;
    private int is_enabled;
    private String title;
    private String created;
    @JsonProperty("Layouts")
    private List<Layout> layouts;
    private long layout_change_interval;
    private long encoder_gop_size_id;
    private long video_bitrate;
    private int is_deblocking;
    private long is_downscale;
    private long is_interlaced;
    private long sdi_out_id;
    private long ftp_agent_id;
    private long output_resolution_id;
    private long enable_alarms_display;
    private long encoder_linear_codec_type_id;
    private long encoder_uhd_tech_type_id;
    private long encoder_latency_type_id;

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

    public List<TransportStream> getTransportStream() {
        return transportStream;
    }

    public void setTransportStream(List<TransportStream> transportStream) {
        this.transportStream = transportStream;
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

    public List<OutputStream> getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(List<OutputStream> outputStream) {
        this.outputStream = outputStream;
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
        return layouts;
    }

    public void setLayouts(List<Layout> layouts) {
        this.layouts = layouts;
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

    public long getIs_downscale() {
        return is_downscale;
    }

    public void setIs_downscale(long is_downscale) {
        this.is_downscale = is_downscale;
    }

    public long getIs_interlaced() {
        return is_interlaced;
    }

    public void setIs_interlaced(long is_interlaced) {
        this.is_interlaced = is_interlaced;
    }

    public long getSdi_out_id() {
        return sdi_out_id;
    }

    public void setSdi_out_id(long sdi_out_id) {
        this.sdi_out_id = sdi_out_id;
    }

    public long getFtp_agent_id() {
        return ftp_agent_id;
    }

    public void setFtp_agent_id(long ftp_agent_id) {
        this.ftp_agent_id = ftp_agent_id;
    }

    public long getOutput_resolution_id() {
        return output_resolution_id;
    }

    public void setOutput_resolution_id(long output_resolution_id) {
        this.output_resolution_id = output_resolution_id;
    }

    public long getEnable_alarms_display() {
        return enable_alarms_display;
    }

    public void setEnable_alarms_display(long enable_alarms_display) {
        this.enable_alarms_display = enable_alarms_display;
    }

    public long getEncoder_linear_codec_type_id() {
        return encoder_linear_codec_type_id;
    }

    public void setEncoder_linear_codec_type_id(long encoder_linear_codec_type_id) {
        this.encoder_linear_codec_type_id = encoder_linear_codec_type_id;
    }

    public long getEncoder_uhd_tech_type_id() {
        return encoder_uhd_tech_type_id;
    }

    public void setEncoder_uhd_tech_type_id(long encoder_uhd_tech_type_id) {
        this.encoder_uhd_tech_type_id = encoder_uhd_tech_type_id;
    }

    public long getEncoder_latency_type_id() {
        return encoder_latency_type_id;
    }

    public void setEncoder_latency_type_id(long encoder_latency_type_id) {
        this.encoder_latency_type_id = encoder_latency_type_id;
    }
}

