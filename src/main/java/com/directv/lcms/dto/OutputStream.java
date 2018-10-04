package com.directv.lcms.dto;

public class OutputStream {
    private int port;
    private long id;
    private String ip_address;
    private long network_id;
    private long ttl;
    private long output_stream_type_id;
    private long enabled;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public long getNetwork_id() {
        return network_id;
    }

    public void setNetwork_id(long network_id) {
        this.network_id = network_id;
    }

    public long getTtl() {
        return ttl;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    public long getOutput_stream_type_id() {
        return output_stream_type_id;
    }

    public void setOutput_stream_type_id(long output_stream_type_id) {
        this.output_stream_type_id = output_stream_type_id;
    }

    public long getEnabled() {
        return enabled;
    }

    public void setEnabled(long enabled) {
        this.enabled = enabled;
    }
}
