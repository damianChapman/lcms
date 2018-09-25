package com.directv.lcms.dto;

public class ScanTask {
    private long progress;
    private String ip_address_from;
    private String status;
    private String ssm_to;
    private String port_to;
    private long mode_id;
    private long device_id;
    private String ip_address_to;
    private String modified;
    private int port_from;
    private long id;
    private long network_id;
    private String created;
    private String ssm_from;
    private long time_remained;

    public long getProgress() {
        return progress;
    }

    public void setProgress(long progress) {
        this.progress = progress;
    }

    public String getIp_address_from() {
        return ip_address_from;
    }

    public void setIp_address_from(String ip_address_from) {
        this.ip_address_from = ip_address_from;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSsm_to() {
        return ssm_to;
    }

    public void setSsm_to(String ssm_to) {
        this.ssm_to = ssm_to;
    }

    public String getPort_to() {
        return port_to;
    }

    public void setPort_to(String port_to) {
        this.port_to = port_to;
    }

    public long getMode_id() {
        return mode_id;
    }

    public void setMode_id(long mode_id) {
        this.mode_id = mode_id;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    public String getIp_address_to() {
        return ip_address_to;
    }

    public void setIp_address_to(String ip_address_to) {
        this.ip_address_to = ip_address_to;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public int getPort_from() {
        return port_from;
    }

    public void setPort_from(int port_from) {
        this.port_from = port_from;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNetwork_id() {
        return network_id;
    }

    public void setNetwork_id(long network_id) {
        this.network_id = network_id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSsm_from() {
        return ssm_from;
    }

    public void setSsm_from(String ssm_from) {
        this.ssm_from = ssm_from;
    }

    public long getTime_remained() {
        return time_remained;
    }

    public void setTime_remained(long time_remained) {
        this.time_remained = time_remained;
    }
}
