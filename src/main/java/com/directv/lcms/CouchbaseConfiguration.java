package com.directv.lcms;

import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

@EnableCouchbaseRepositories
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList("http://nfl-cb.integrated-digital.com");
    }

    @Override
    protected String getBucketName() {
        return "lcms";
    }

    @Override
    protected String getBucketPassword() {
        return "";
    }
}

