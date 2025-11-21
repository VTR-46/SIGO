package model.entities;

public class ComumProduct {
    private String name;
    private double value;
    private int amount;

    public ComumProduct(){

    }

    public ComumProduct(int amount, double value, String name) {
        this.amount = amount;
        this.value = value;
        this.name = name;
    }


    public void priceTag(){
        System.out.println("R$" + String.format("%.2f", value));

    }
}
