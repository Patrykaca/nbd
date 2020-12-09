package com.nierelacyjne.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Table
@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    @PrimaryKey
    private int id;
    private String state;
    private String state_abbreviation;
    private String county;
    private String party;
    private String candidate;
    private Integer votes;
    private double fraction_votes;
    private Integer fips;

}
