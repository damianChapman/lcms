package com.directv.lcms.dto;

public class OutputStream {
    private int port;
    private long id;
    private String ip_address;
    private long network_id;
    private long ttl;

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
}
