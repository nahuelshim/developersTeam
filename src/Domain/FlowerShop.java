package Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlowerShop implements Serializable {

    private String name;
    private List<Ticket> invoices;
    private List<Product> inventory;
    private static FlowerShop instance;

    public FlowerShop(String name) {
        this.name = name;
        invoices = new ArrayList<>();
        inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Ticket> getInvoices() {
        return invoices;
    }

    public List<Product> getInventory() {
        return inventory;
    }
    public static FlowerShop getInstance(String name) {
        if (instance == null) {
            instance = new FlowerShop(name);
        }
        return instance;
    }
}
