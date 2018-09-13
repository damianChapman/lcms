package com.directv.lcms.dto;

public class LayoutBox
{
    private String id;

    private String channel_source_id;

    private String title;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getChannel_source_id ()
    {
        return channel_source_id;
    }

    public void setChannel_source_id (String channel_source_id)
    {
        this.channel_source_id = channel_source_id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }
}