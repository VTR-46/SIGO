package model.entities;

import model.entities.enums.SensorStatus;
import model.services.SensorRules;

import java.time.LocalDateTime;

public class TemperatureSensor implements SensorRules {

    private String name;
    private double temp;
    private SensorStatus status;
    private String dateTimeCreation;

    public TemperatureSensor(){
    }

    public TemperatureSensor(String name, String dateTimeCreation, SensorStatus status, double temp) {
        this.name = name;
        this.dateTimeCreation = dateTimeCreation;
        this.temp = temp;
        this.status = status;
    }

    @Override
    public boolean ValidTemperature(double Temp) {
        if (Temp < -20 || Temp > 200){
            return false;
        }else {
            return true;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public SensorStatus getStatus() {
        return status;
    }

    public void setStatus(SensorStatus status) {
        this.status = status;
    }
}
