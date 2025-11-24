package model.entities;

public class ManuProduct {
    private String name;

    public ManuProduct(){

    }

    public ManuProduct(String name) {
        this.name = name;
    }

    public String getName() {
        return getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
