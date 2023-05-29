package Domain;

import java.util.ArrayList;
import java.util.List;

public class FlowerShop {

    private String name;
    private List<Ticket> invoices;
    private List<Product> inventory;

    public FlowerShop(String name) {
        this.name = name;
        invoices = new ArrayList<>();
        inventory = new ArrayList<>();
    }


}
