package model.entities;

public class ReserveItem {
    private int amount;
    private Destination destination;

    public ReserveItem(int amount, Destination destination) {
        this.amount = amount;
        this.destination = destination;
    }

    public double totalP(){
        return amount * destination.getPrice();
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return  "\n===================================="+
                "\nDestino: " + destination.getName() +
                "\nQuantidade: " + amount +
                "\nPreço unitario: R$"+ destination.getPrice() +
                "\nTotal: "+ totalP();
    }
}
