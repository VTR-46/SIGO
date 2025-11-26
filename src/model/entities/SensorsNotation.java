package model.entities;

import model.services.SensorRules;

import java.util.ArrayList;
import java.util.List;

public class SensorsNotation implements SensorRules {

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

    public double Bigger(){

        double b = sensorList.getFirst().getTemp();

        for (TemperatureSensor sensorL : sensorList){
            if (b < sensorL.getTemp()){
                b = sensorL.getTemp();
            }
        }

        return this.bigger = b;
    }

    public double Smaller(){

        double b = sensorList.getFirst().getTemp();

        for (TemperatureSensor sensorL : sensorList){
            if (b > sensorL.getTemp()){
                b = sensorL.getTemp();
            }
        }

        return this.smaller = b;
    }

    public void List(){
        System.out.println("NOME \t TEMPERATURA \t STATUS");
        for (TemperatureSensor sensorL : sensorList){
            System.out.println(sensorL.getName() + " \t " + sensorL.getTemp() + " \t " + sensorL.getStatus().getDescription());
        }
    }

    @Override
    public boolean ValidTemperature(double Temp) {
        if (Temp < -20 || Temp > 200){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "\nTemperaturas Registradas\n" +
                "\nMedia " + average +
                "\nMaior " + bigger +
                "\nMenor " + smaller;
    }


}
