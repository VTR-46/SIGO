package model.entities;

import model.entities.ManuProduct;
import model.services.MachineRules;

import java.util.ArrayList;
import java.util.List;

public class ProductionMachine implements MachineRules {
    private String name;
    private int produced;
    private boolean active;
    private double defectRate;
    private List<ManuProduct> manuProducts = new ArrayList<>();

    public ProductionMachine(){

    }

    public ProductionMachine(String name, double defectRate, boolean active, int produced) {
        this.name = name;
        this.defectRate = defectRate;
        this.active = active;
        this.produced = produced;

    }

    @Override
    public boolean NegativeRule(double amountEntered) {
        if (amountEntered < 0){
            return false;
        }else {
            return true;
        }

    }

    public void addProduct(ManuProduct manuProduct){
        manuProducts.add(manuProduct);
    }

    public int increaseProductAmount(int amount){
        return this.produced += amount;

    }

    public void listedReport(){
        for (ManuProduct manuProduct : manuProducts) {
            System.out.println(manuProduct.getName());
        }
    }

    public double increaseDamege(){
        return this.defectRate += 0.5;
    }

    public String getName() {
        return name;
    }

    public int getProduced() {
        return produced;
    }

    public boolean getActive() {
        return active;
    }

    public double getDefectRate() {
        return defectRate;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "==== MAQUINA " + getName() + " ====" +
                "\nProduzido: " + getProduced() +
                "\nATIVA:" + getActive() +
                "\nTAXA DE DESGASTE: " + getDefectRate() + "%" +
                "\nPRODUTOS PRODUZIDOS: \n" + manuProducts ;
    }
}
