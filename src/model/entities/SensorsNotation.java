package model.entities;

import java.util.ArrayList;
import java.util.List;

public class SensorsNotation {

    public double average;
    public double bigger;
    public double smaller;
    private List<TemperatureSensor> sensorList = new ArrayList<>();

    public SensorsNotation(){};

    public SensorsNotation(double average, double smaller, double bigger) {
        this.average = average;
        this.smaller = smaller;
        this.bigger = bigger;

    }

    public void addSensor(TemperatureSensor sensorL){
        sensorList.add(sensorL);
    }

    public double averageCalc(){

        int c = 0;
        double total = 0;

        for (TemperatureSensor sensorL : sensorList){
            total += sensorL.getTemp();
            c++;
        }

        double a = total / c;

        return  this.average = a;
    }

    public double Bigger(TemperatureSensor sensorLe){

        double b = sensorList.get(0).getTemp();

        for (TemperatureSensor sensorL : sensorList){
            if (b > sensorL.getTemp()){
                b = sensorL.getTemp();
            }
        }

        return this.bigger = b;
    }

    public double Smaller(TemperatureSensor sensorLe){

        double b = sensorList.get(0).getTemp();

        for (TemperatureSensor sensorL : sensorList){
            if (b < sensorL.getTemp()){
                b = sensorL.getTemp();
            }
        }

        return this.smaller = b;
    }


}
