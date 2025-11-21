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

    @Override
    public void priceTag(){
        super.priceTag();
    }

}
