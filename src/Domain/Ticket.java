package Domain;

import java.io.Serializable;
import java.util.List;

public class Ticket implements Serializable {

    private List<Product> products;
    private static int contador = 0;
    private int id;

    public Ticket(List<Product> products) {
        this.products = products;
        contador++;
        id = contador;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getId() {
        return id;
    }

    public void addProduct(String name, float price, int quantity){
        products.add(new Product(name,price,quantity));
    }

    public double getTotal(){
        double total = 0;
        for (Product p : products){
            total += p.getPrice() * p.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ticket ID " + id + " { \n");
        for (Product p : products) {
            sb.append("  ").append(p.getName()).append(" (x").append(p.getQuantity()).append("): ").append(p.getPrice()).append("\n");
        }
        sb.append("  ---Total: ").append(getTotal()).append("€\n}");

        return sb.toString();
    }
}
