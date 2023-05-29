package Domain;



public class Tree extends Product{

    private float height;

    public Tree(String name,float price, int quantity, float height) {
        super(name,price, quantity);
        this.height = height;

    }

    public float getHeight() {
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
