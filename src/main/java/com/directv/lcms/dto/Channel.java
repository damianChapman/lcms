package com.directv.lcms.dto;

import com.couchbase.client.java.repository.annotation.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;
import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.USE_ATTRIBUTES;

@Document
public class Channel {

    @Id @GeneratedValue(strategy = UNIQUE)
    private String id;
    private String name;
    private String callLetters;
    private String ccid;
    private String environment;
    private String key;
    private String primarySourceIPAddress;
    private String backupSourceIPAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCallLetters() {
        return callLetters;
    }

    public void setCallLetters(String callLetters) {
        this.callLetters = callLetters;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPrimarySourceIPAddress() {
        return primarySourceIPAddress;
    }

    public void setPrimarySourceIPAddress(String primarySourceIPAddress) {
        this.primarySourceIPAddress = primarySourceIPAddress;
    }

    public String getBackupSourceIPAddress() {
        return backupSourceIPAddress;
    }

    public void setBackupSourceIPAddress(String backupSourceIPAddress) {
        this.backupSourceIPAddress = backupSourceIPAddress;
    }

    public String getPrimaryGroupIPAddress() {
        return primaryGroupIPAddress;
    }

    public void setPrimaryGroupIPAddress(String primaryGroupIPAddress) {
        this.primaryGroupIPAddress = primaryGroupIPAddress;
    }

    public String getBackupGroupIPAddress() {
        return backupGroupIPAddress;
    }

    public void setBackupGroupIPAddress(String backupGroupIPAddress) {
        this.backupGroupIPAddress = backupGroupIPAddress;
    }

    public String getPrimaryPortNumber() {
        return primaryPortNumber;
    }

    public void setPrimaryPortNumber(String primaryPortNumber) {
        this.primaryPortNumber = primaryPortNumber;
    }

    public String getBackupPortNumber() {
        return backupPortNumber;
    }

    public void setBackupPortNumber(String backupPortNumber) {
        this.backupPortNumber = backupPortNumber;
    }

    public String getPrimaryMPEGProgramNumber() {
        return primaryMPEGProgramNumber;
    }

    public void setPrimaryMPEGProgramNumber(String primaryMPEGProgramNumber) {
        this.primaryMPEGProgramNumber = primaryMPEGProgramNumber;
    }

    public String getBackupMPEGProgramNumber() {
        return backupMPEGProgramNumber;
    }

    public void setBackupMPEGProgramNumber(String backupMPEGProgramNumber) {
        this.backupMPEGProgramNumber = backupMPEGProgramNumber;
    }

    public String getHlsTvUrl() {
        return hlsTvUrl;
    }

    public void setHlsTvUrl(String hlsTvUrl) {
        this.hlsTvUrl = hlsTvUrl;
    }

    public String getHlsMobileUrl() {
        return hlsMobileUrl;
    }

    public void setHlsMobileUrl(String hlsMobileUrl) {
        this.hlsMobileUrl = hlsMobileUrl;
    }

    public String getDashTvUrl() {
        return dashTvUrl;
    }

    public void setDashTvUrl(String dashTvUrl) {
        this.dashTvUrl = dashTvUrl;
    }

    public String getDashMobileUrl() {
        return dashMobileUrl;
    }

    public void setDashMobileUrl(String dashMobileUrl) {
        this.dashMobileUrl = dashMobileUrl;
    }

    private String primaryGroupIPAddress;
    private String backupGroupIPAddress;
    private String primaryPortNumber;
    private String backupPortNumber;
    private String primaryMPEGProgramNumber;
    private String backupMPEGProgramNumber;
    private String hlsTvUrl;
    private String hlsMobileUrl;
    private String dashTvUrl;
    private String dashMobileUrl;
}
