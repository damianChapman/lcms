package com.directv.lcms.couchbase;

import com.directv.lcms.dto.Channel;
import org.springframework.data.couchbase.core.query.View;
import org.springframework.data.repository.CrudRepository;

public interface ChannelRepository extends CrudRepository<Channel, String> {
    @View
    Channel findByName(String name);
}
