package com.nierelacyjne.cassandra.springbootcassandrademo.repo;

import com.nierelacyjne.cassandra.springbootcassandrademo.model.Student;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface StudentRepository extends CassandraRepository<Student, Integer> {

}
