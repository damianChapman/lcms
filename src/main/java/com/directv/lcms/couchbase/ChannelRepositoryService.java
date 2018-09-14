package com.directv.lcms.couchbase;

import com.directv.lcms.dto.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.couchbase.repository.support.SimpleCouchbaseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("ChannelRepositoryService")
public class ChannelRepositoryService implements ChannelService {
    private ChannelRepository channelRepository;

    @Autowired
    public void ChannelRepositoryService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public Channel findById(String id) {
        Optional<Channel> channel = channelRepository.findById(id);
        if (channel.isPresent()) {
            return channel.get();
        }
        // TODO Do not return null
        return null;
    }

    public void create(Channel channel) {
        channelRepository.save(channel);
    }

    // TODO Delete by name
    public void delete(String name) {
        Channel channel = channelRepository.findByName(name);
        channelRepository.delete(channel);
    }
}
