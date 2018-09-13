package com.directv.lcms.dto;

public class ChannelSource
{
    private ChannelProfile[] ChannelProfile;

    private String port;

    private String standard_type_id;

    private String device_id;

    private String is_monitored;

    private String modified;

    private String service_type_id;

    private String id;

    private String is_record_enabled;

    private String title;

    private String ip_address;

    private String program_number;

    private String network_id;

    private String created;

    private String ssm_ip_address;

    private String is_scanned;

    private String uuid;

    private String note;

    public ChannelProfile[] getChannelProfile ()
    {
        return ChannelProfile;
    }

    public void setChannelProfile (ChannelProfile[] ChannelProfile)
    {
        this.ChannelProfile = ChannelProfile;
    }

    public String getPort ()
    {
        return port;
    }

    public void setPort (String port)
    {
        this.port = port;
    }

    public String getStandard_type_id ()
    {
        return standard_type_id;
    }

    public void setStandard_type_id (String standard_type_id)
    {
        this.standard_type_id = standard_type_id;
    }

    public String getDevice_id ()
    {
        return device_id;
    }

    public void setDevice_id (String device_id)
    {
        this.device_id = device_id;
    }

    public String getIs_monitored ()
    {
        return is_monitored;
    }

    public void setIs_monitored (String is_monitored)
    {
        this.is_monitored = is_monitored;
    }

    public String getModified ()
    {
        return modified;
    }

    public void setModified (String modified)
    {
        this.modified = modified;
    }

    public String getService_type_id ()
    {
        return service_type_id;
    }

    public void setService_type_id (String service_type_id)
    {
        this.service_type_id = service_type_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIs_record_enabled ()
    {
        return is_record_enabled;
    }

    public void setIs_record_enabled (String is_record_enabled)
    {
        this.is_record_enabled = is_record_enabled;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getIp_address ()
    {
        return ip_address;
    }

    public void setIp_address (String ip_address)
    {
        this.ip_address = ip_address;
    }

    public String getProgram_number ()
    {
        return program_number;
    }

    public void setProgram_number (String program_number)
    {
        this.program_number = program_number;
    }

    public String getNetwork_id ()
    {
        return network_id;
    }

    public void setNetwork_id (String network_id)
    {
        this.network_id = network_id;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getSsm_ip_address ()
    {
    return ssm_ip_address;
    }

    public void setSsm_ip_address (String ssm_ip_address)
    {
        this.ssm_ip_address = ssm_ip_address;
    }

    public String getIs_scanned ()
    {
        return is_scanned;
    }

    public void setIs_scanned (String is_scanned)
    {
        this.is_scanned = is_scanned;
    }

    public String getUuid ()
    {
        return uuid;
    }

    public void setUuid (String uuid)
    {
        this.uuid = uuid;
    }

    public String getNote ()
    {
        return note;
    }

    public void setNote (String note)
    {
        this.note = note;
    }
}

