package Domain;

public class Product {

    private float price;
    private int quantity;

    public Product(float price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void addQuantity(int quantity){
        this.quantity = this.quantity + quantity;
    }

    public void removeQuantity(int quantity){
        this.quantity = this.quantity - quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
