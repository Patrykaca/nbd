package com.nierelacyjne.repository;

import com.nierelacyjne.model.Data;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface DataRepository extends CassandraRepository<Data, Integer> {
}
