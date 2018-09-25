package com.directv.lcms.dto;

import java.util.List;

public class Layout {
    private long id;
    private String title;
    private long layout_type_id;
    private String created;
    private List<LayoutBox> layoutBoxes;
    private List<Encoder> encoders;
    private String modified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getLayout_type_id() {
        return layout_type_id;
    }

    public void setLayout_type_id(long layout_type_id) {
        this.layout_type_id = layout_type_id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public List<LayoutBox> getLayoutBoxes() {
        return layoutBoxes;
    }

    public void setLayoutBoxes(List<LayoutBox> layoutBoxes) {
        this.layoutBoxes = layoutBoxes;
    }

    public List<Encoder> getEncoders() {
        return encoders;
    }

    public void setEncoders(List<Encoder> encoders) {
        this.encoders = encoders;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}