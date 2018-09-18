package com.directv.lcms.dto;

public class TransportStream {
    private String id;
    private String video_pid;
    private String program_number;
    private String transport_mode_id;
    private String audio_pid;
    private String transport_stream_id;
    private String pmt_pid;
    private String is_null_padding;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideo_pid() {
        return video_pid;
    }

    public void setVideo_pid(String video_pid) {
        this.video_pid = video_pid;
    }

    public String getProgram_number() {
        return program_number;
    }

    public void setProgram_number(String program_number) {
        this.program_number = program_number;
    }

    public String getTransport_mode_id() {
        return transport_mode_id;
    }

    public void setTransport_mode_id(String transport_mode_id) {
        this.transport_mode_id = transport_mode_id;
    }

    public String getAudio_pid() {
        return audio_pid;
    }

    public void setAudio_pid(String audio_pid) {
        this.audio_pid = audio_pid;
    }

    public String getTransport_stream_id() {
        return transport_stream_id;
    }

    public void setTransport_stream_id(String transport_stream_id) {
        this.transport_stream_id = transport_stream_id;
    }

    public String getPmt_pid() {
        return pmt_pid;
    }

    public void setPmt_pid(String pmt_pid) {
        this.pmt_pid = pmt_pid;
    }

    public String getIs_null_padding() {
        return is_null_padding;
    }

    public void setIs_null_padding(String is_null_padding) {
        this.is_null_padding = is_null_padding;
    }
}
