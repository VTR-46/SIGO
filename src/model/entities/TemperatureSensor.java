package model.entities;

import model.services.SensorRules;

public class TemperatureSensor implements SensorRules {

    private String name;
    private boolean active;
    private double temp;

    public TemperatureSensor(){
    }

    public TemperatureSensor(String name, double temp, boolean active) {
        this.name = name;
        this.temp = temp;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
