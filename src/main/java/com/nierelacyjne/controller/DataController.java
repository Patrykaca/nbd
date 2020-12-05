package com.nierelacyjne.controller;

import com.nierelacyjne.ResouceNotFoundException;
import com.nierelacyjne.model.Data;
import com.nierelacyjne.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    DataRepository dataRepository;

    @PostMapping("/data")
    public Data addData(@RequestBody Data data) {
        dataRepository.save(data);
        return data;
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<Data> findById(@PathVariable("id") Integer dataId) {
        Data data = dataRepository.findById(dataId).orElseThrow(
                () -> new ResouceNotFoundException("Data not found" + dataId)
        );
        return ResponseEntity.ok().body(data);
    }

    @GetMapping("/data")
    public List<Data> getData() {
        return dataRepository.findAll();
    }

    @PutMapping("/data/{id}")
    public ResponseEntity<Data> updateData(@PathVariable(value = "id") Integer dataId,
                                           @RequestBody Data dataDetails) {
        Data data = dataRepository.findById(dataId).orElseThrow(
                () -> new ResouceNotFoundException("Data not found for this id :: " + dataId)
        );
        final Data updatedData = dataRepository.save(data);
        return ResponseEntity.ok(updatedData);
    }

    @DeleteMapping("data/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable(value = "id") Integer dataId) {
        Data data = dataRepository.findById(dataId).orElseThrow(
                () -> new ResouceNotFoundException("Data not found::: " + dataId)
        );
        dataRepository.delete(data);
        return ResponseEntity.ok().build();
    }



}
