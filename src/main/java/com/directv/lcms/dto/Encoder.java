package com.directv.lcms.dto;

import java.util.List;

public class Encoder
{
    private String encoder_codec_type_id;

    private String audio_alarm_agent_id;

    private String device_id;

    private List<TransportStream> TransportStream;

    private String vbv_limit;

    private String encoder_gop_size_mode_id;

    private String error_display_agent_id;

    private List<OutputStream> OutputStream;

    private String modified;

    private String encoder_frame_rate_id;

    private String id;

    private String is_enabled;

    private String title;

    private String created;

    private List<Layout> Layouts;

    private String layout_change_interval;

    private String encoder_gop_size_id;

    private String video_bitrate;

    private String is_deblocking;

    public String getEncoder_codec_type_id ()
    {
        return encoder_codec_type_id;
    }

    public void setEncoder_codec_type_id (String encoder_codec_type_id)
    {
        this.encoder_codec_type_id = encoder_codec_type_id;
    }

    public String getAudio_alarm_agent_id ()
    {
        return audio_alarm_agent_id;
    }

    public void setAudio_alarm_agent_id (String audio_alarm_agent_id)
    {
        this.audio_alarm_agent_id = audio_alarm_agent_id;
    }

    public String getDevice_id ()
    {
        return device_id;
    }

    public void setDevice_id (String device_id)
    {
        this.device_id = device_id;
    }

    public List<TransportStream> getTransportStream ()
    {
        return TransportStream;
    }

    public void setTransportStream (List<TransportStream> TransportStream)
    {
        this.TransportStream = TransportStream;
    }

    public String getVbv_limit ()
    {
        return vbv_limit;
    }

    public void setVbv_limit (String vbv_limit)
    {
        this.vbv_limit = vbv_limit;
    }

    public String getEncoder_gop_size_mode_id ()
    {
        return encoder_gop_size_mode_id;
    }

    public void setEncoder_gop_size_mode_id (String encoder_gop_size_mode_id)
    {
        this.encoder_gop_size_mode_id = encoder_gop_size_mode_id;
    }

    public String getError_display_agent_id ()
    {
        return error_display_agent_id;
    }

    public void setError_display_agent_id (String error_display_agent_id)
    {
        this.error_display_agent_id = error_display_agent_id;
    }

    public List<OutputStream> getOutputStream ()
    {
        return OutputStream;
    }

    public void setOutputStream (List<OutputStream> OutputStream)
    {
        this.OutputStream = OutputStream;
    }

    public String getModified ()
    {
        return modified;
    }

    public void setModified (String modified)
    {
        this.modified = modified;
    }

    public String getEncoder_frame_rate_id ()
    {
        return encoder_frame_rate_id;
    }

    public void setEncoder_frame_rate_id (String encoder_frame_rate_id)
    {
        this.encoder_frame_rate_id = encoder_frame_rate_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIs_enabled ()
    {
        return is_enabled;
    }

    public void setIs_enabled (String is_enabled)
    {
        this.is_enabled = is_enabled;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public List<Layout> getLayouts ()
    {
        return Layouts;
    }

    public void setLayouts (List<Layout> Layouts)
    {
        this.Layouts = Layouts;
    }

    public String getLayout_change_interval ()
    {
        return layout_change_interval;
    }

    public void setLayout_change_interval (String layout_change_interval)
    {
        this.layout_change_interval = layout_change_interval;
    }

    public String getEncoder_gop_size_id ()
    {
        return encoder_gop_size_id;
    }

    public void setEncoder_gop_size_id (String encoder_gop_size_id)
    {
        this.encoder_gop_size_id = encoder_gop_size_id;
    }

    public String getVideo_bitrate ()
    {
        return video_bitrate;
    }

    public void setVideo_bitrate (String video_bitrate)
    {
        this.video_bitrate = video_bitrate;
    }

    public String getIs_deblocking ()
    {
        return is_deblocking;
    }

    public void setIs_deblocking (String is_deblocking)
    {
        this.is_deblocking = is_deblocking;
    }
}

