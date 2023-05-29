package Domain;

public class Flower extends  Product {

    private String color;

    public Flower(String name,double price, int quantity, String color) {
        super(name,price, quantity);
        this.color = color;
    }

    public String getColor() {
        return color;
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
        return super.toString() + color;
    }
}
