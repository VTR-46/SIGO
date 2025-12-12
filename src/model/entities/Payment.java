package model.entities;

import java.time.LocalDate;

public class Payment {
    private double amount;
    private LocalDate date;
    private String description;
    private double tax;
    private String PaymentType;
    private double finalAmount;

    public Payment(double amount, String description, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getDescription() {
        return description;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String paymentType) {
        PaymentType = paymentType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }



    @Override
    public String toString() {
        return "====Pagamento====\n" +
                "\nQuantiade: R$" + amount +
                "\nData: " + date +
                "\nDescrição: " + description +
                "\nTipo de pagamento: " + getPaymentType() +
                "\nTaxa: "+ getTax() +
                "\nValor final: " + getFinalAmount();
    }


}
