package Domain;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private float price;
    private int quantity;
    private static int contador = 0;
    private int id;

    public Product(String name,float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        contador++;
        id = contador;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
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
