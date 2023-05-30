package Domain;

import Services.Txt;

import java.io.IOException;
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

        invoices = Txt.readTicketFile();
        return invoices;
    }

    public List<Product> getInventory() {
        inventory = Txt.readProductFile();
        return inventory;
    }

    public void removeProductFromInventory(String product) throws IOException {
        Txt.removeProductFromFile(product);
    }

    public void addProductToInventory(Product product) throws IOException {
        Txt.addProduct(product);
    }

    public void addTicketToInvoices(Ticket ticket) throws IOException {
        Txt.addTicket(ticket);
        System.out.println("Your shopping ticket is:\n" + ticket.toString());
    }

    public void updateInventory(List<Product> inventory) throws IOException {
        Txt.updateProduct(inventory);

    }
    public static FlowerShop getInstance(String name) {
        if (instance == null) {
            instance = new FlowerShop(name);
        }
        return instance;
    }
}
