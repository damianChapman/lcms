package com.directv.lcms.dto;

public class TransportStream {
    private long id;
    private long video_pid;
    private long program_number;
    private long transport_mode_id;
    private long audio_pid;
    private long transport_stream_id;
    private long pmt_pid;
    private int is_null_padding;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVideo_pid() {
        return video_pid;
    }

    public void setVideo_pid(long video_pid) {
        this.video_pid = video_pid;
    }

    public long getProgram_number() {
        return program_number;
    }

    public void setProgram_number(long program_number) {
        this.program_number = program_number;
    }

    public long getTransport_mode_id() {
        return transport_mode_id;
    }

    public void setTransport_mode_id(long transport_mode_id) {
        this.transport_mode_id = transport_mode_id;
    }

    public long getAudio_pid() {
        return audio_pid;
    }

    public void setAudio_pid(long audio_pid) {
        this.audio_pid = audio_pid;
    }

    public long getTransport_stream_id() {
        return transport_stream_id;
    }

    public void setTransport_stream_id(long transport_stream_id) {
        this.transport_stream_id = transport_stream_id;
    }

    public long getPmt_pid() {
        return pmt_pid;
    }

    public void setPmt_pid(long pmt_pid) {
        this.pmt_pid = pmt_pid;
    }

    public int getIs_null_padding() {
        return is_null_padding;
    }

    public void setIs_null_padding(int is_null_padding) {
        this.is_null_padding = is_null_padding;
    }
}
