package Domain;

public class Tree extends Product{

    private double height;

    public Tree(String name, double price, int quantity, double height) {
        super(name, price, quantity);
        this.height = height;

    }

    public double getHeight() {
        return height;
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
        return super.toString()+ height;
    }
}
