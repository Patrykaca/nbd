package com.nierelacyjne.cassandra.springbootcassandrademo.repo;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
