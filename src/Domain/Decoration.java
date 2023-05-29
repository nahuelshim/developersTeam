package Domain;

public class Decoration extends Product{

    private String material;

    public Decoration(String name, float price, int quantity, String material) {
        super( name,price, quantity);
        this.material = material;
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void addQuantity(int quantity) {
        super.addQuantity(quantity);
    }

    @Override
    public void removeQuantity(int quantity) {
        super.removeQuantity(quantity);
    }

    @Override
    public String toString() {
        return super.toString() + material;
    }
}
