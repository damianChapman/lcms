package com.directv.lcms.dto;

import java.util.List;

public class ChannelSource {
    private List<ChannelProfile> channelProfile;
    private int port;
    private long standard_type_id;
    private long device_id;
    private int is_monitored;
    private String modified;
    private long service_type_id;
    private long id;
    private int is_record_enabled;
    private String title;
    private String ip_address;
    private long program_number;
    private long network_id;
    private String created;
    private String ssm_ip_address;
    private int is_scanned;
    private long uuid;
    private String note;

    public List<ChannelProfile> getChannelProfile() {
        return channelProfile;
    }

    public void setChannelProfile(List<ChannelProfile> channelProfile) {
        this.channelProfile = channelProfile;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public long getStandard_type_id() {
        return standard_type_id;
    }

    public void setStandard_type_id(long standard_type_id) {
        this.standard_type_id = standard_type_id;
    }

    public long getDevice_id() {
        return device_id;
    }

    public void setDevice_id(long device_id) {
        this.device_id = device_id;
    }

    public int getIs_monitored() {
        return is_monitored;
    }

    public void setIs_monitored(int is_monitored) {
        this.is_monitored = is_monitored;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public long getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(long service_type_id) {
        this.service_type_id = service_type_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIs_record_enabled() {
        return is_record_enabled;
    }

    public void setIs_record_enabled(int is_record_enabled) {
        this.is_record_enabled = is_record_enabled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public long getProgram_number() {
        return program_number;
    }

    public void setProgram_number(long program_number) {
        this.program_number = program_number;
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

    public String getSsm_ip_address() {
        return ssm_ip_address;
    }

    public void setSsm_ip_address(String ssm_ip_address) {
        this.ssm_ip_address = ssm_ip_address;
    }

    public int getIs_scanned() {
        return is_scanned;
    }

    public void setIs_scanned(int is_scanned) {
        this.is_scanned = is_scanned;
    }

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

