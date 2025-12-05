package model.entities;

import java.time.LocalDate;

public class UsedProduct extends  ComumProduct{

    private LocalDate date;

    public UsedProduct() {
        super();
    }

    public UsedProduct(int amount, double value, String name, LocalDate date) {
        super(amount, value, name);
        this.date = date;
    }

    @Override
    public void priceTag(){
        System.out.println("[U]-" + super.getName() + ", R$" + String.format("%.2f", super.getValue()) + ", Quantidade: "+ super.getAmount() + ", Fabricado: " + date);

    }
}
