package com.nierelacyjne.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @PrimaryKey
    private int id;
    private String name;
}
