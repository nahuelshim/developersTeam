package Domain;

import java.io.Serializable;
public class Product implements Serializable {

    private String name;
    private double price;
    private int quantity;



    public Product(String name,double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
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
        return "Product: " + name +
                "\nPrice: " + price + "€" +
                "\nQuantity: " + quantity;
    }
}
