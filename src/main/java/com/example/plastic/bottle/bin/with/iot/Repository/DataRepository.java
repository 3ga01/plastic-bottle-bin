package com.example.plastic.bottle.bin.with.iot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.plastic.bottle.bin.with.iot.Models.Data;

public interface DataRepository extends JpaRepository<Data, Long> {

    
}
