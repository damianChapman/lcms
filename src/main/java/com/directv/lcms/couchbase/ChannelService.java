package com.directv.lcms.couchbase;

import com.directv.lcms.dto.Channel;

public interface ChannelService {
    Channel findById(String id);
    void create(Channel channel);
    void delete(String name);
}
