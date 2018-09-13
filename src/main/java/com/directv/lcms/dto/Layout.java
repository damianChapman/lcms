package com.directv.lcms.dto;

import java.util.List;

public class Layout
{
    private String id;

    private String title;

    private String layout_type_id;

    private String created;

    private List<LayoutBox> LayoutBoxes;

    private List<Encoder> Encoders;

    private String modified;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getLayout_type_id ()
    {
        return layout_type_id;
    }

    public void setLayout_type_id (String layout_type_id)
    {
        this.layout_type_id = layout_type_id;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public List<LayoutBox> getLayoutBoxes ()
    {
        return LayoutBoxes;
    }

    public void setLayoutBoxes (List<LayoutBox> LayoutBoxes)
    {
        this.LayoutBoxes = LayoutBoxes;
    }

    public List<Encoder> getEncoders ()
    {
        return Encoders;
    }

    public void setEncoders (List<Encoder> Encoders)
    {
        this.Encoders = Encoders;
    }

    public String getModified ()
    {
        return modified;
    }

    public void setModified (String modified)
    {
        this.modified = modified;
    }
}