package com.example.plastic.bottle.bin.with.iot.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Data {
    @Id
    private long sensor_id;

    public long getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(long sensor_id) {
        this.sensor_id = 1;
    }

    @Column
    private double distance_1;

    public double getDistance_1() {
        return distance_1;
    }

    public void setDistance_1(double distance_1) {
        this.distance_1 = distance_1;
    }

    @Column
    private double distance_2;

    public double getDistance_2() {
        return distance_2;
    }

    public void setDistance_2(double distance_2) {
        this.distance_2 = distance_2;
    }

}
