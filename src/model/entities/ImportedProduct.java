package model.entities;

public class ImportedProduct extends ComumProduct{
    private double TAX;

    public ImportedProduct(double TAX) {
        super();
    }

    public ImportedProduct(int amount, double value, String name, double TAX) {
        super(amount, value, name);
        this.TAX = TAX;
    }

    public double priceTax(){
        return TAX + super.getValue();
    }

    @Override
    public void priceTag(){
        System.out.println("[I]-" + super.getName() + ", R$" + String.format("%.2f", priceTax())  + ", Quantidade: "+ super.getAmount());
    }

}
