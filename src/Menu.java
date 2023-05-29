import Domain.*;
import Services.Method;
import Services.Txt;

import java.io.IOException;
import java.util.List;

public class Menu {

        static FlowerShop flowerShop;

        public static void createFlowerShop() throws IOException {

            if (Txt.checkFlowerShop() != null) {
                flowerShop = Txt.checkFlowerShop();
                System.out.println("We already have a flower shop: " + flowerShop.getName());
            } else {
                flowerShop = FlowerShop.getInstance(Method.getString("Type the flower's shop name."));
                System.out.println(flowerShop.getName() + " created!");

                Txt.createFlowerShop(flowerShop);
            }
        }

        public static int searchDuplicated(String newProduct) {
            boolean flag = false;
            int i = 0;
            int indexProduct = -1;
            Product product;

            if (flowerShop.getInventory() != null) {

                while (i < flowerShop.getInventory().size() && !flag) {
                    product = flowerShop.getInventory().get(i);
                    if (product.getName().equalsIgnoreCase(newProduct)) {
                        indexProduct = i;
                        flag = true;
                    }
                    i++;
                }
            }
            return indexProduct;
        }

        public static void changeQuantityExistingProduct(int indexProduct, String newProductName) throws IOException {

            int option;
            int newQuantity;
            List<Product> databaseList;

            option = Method.getInt("This type of product already exist. Do you want to:\n" +
                    "1. Add more stock to this product.\n" +
                    "2. Quit.");

            if (option == 1) {
                newQuantity = Method.getInt("How many more " + newProductName + " you want to add?");
                databaseList = flowerShop.getInventory();
                databaseList.get(indexProduct).changeSumQuantity(newQuantity);
                flowerShop.updateInventory(databaseList);
                System.out.println("Stock successfully updated!");
            } else {
                System.out.println("Quitting.");
            }
        }

        public static void addTree() throws IOException {

            String newTree;
            int found;
            Product tree;

            if (Txt.checkFlowerShop() != null) {
                newTree = Method.getString("What kind of tree is?");
                found = searchDuplicated(newTree);

                if (found != -1){
                    changeQuantityExistingProduct(found, newTree);
                } else {
                    tree = new Tree(newTree,
                            Method.getDouble("Enter the tree's retail price."),
                            Method.getInt("How many trees are you adding?"),
                            Method.getDouble("Type the tree's height."));
                    try {
                        flowerShop.addProductToInventory(tree);
                        System.out.println("Products successfully added!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("First create a flower shop, for God's sake!");
            }
        }

        public static void addFlower() throws IOException {

            String newFlower;
            int found;
            Product flower;

            if (Txt.checkFlowerShop() != null) {
                newFlower = Method.getString("What kind of flower is?");
                found = searchDuplicated(newFlower);

                if (found != -1){
                    changeQuantityExistingProduct(found, newFlower);
                } else {
                    flower = new Flower(newFlower,
                            Method.getDouble("Enter the flower's retail price."),
                            Method.getInt("How many flowers are you adding?"),
                            Method.getString("Type the flower's color."));
                    try {
                        flowerShop.addProductToInventory(flower);
                        System.out.println("Products successfully added!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("First create a flower shop, for God's sake!");
            }
        }

        public static void addDecoration() throws IOException {

            String newDecoration;
            int found;
            Product decoration;

            if (Txt.checkFlowerShop() != null) {
                newDecoration = Method.getString("What kind of decoration is?");
                found = searchDuplicated(newDecoration);

                if (found != -1){
                    changeQuantityExistingProduct(found, newDecoration);
                } else {
                    decoration = new Decoration(newDecoration,
                            Method.getDouble("Enter the decoration's retail price."),
                            Method.getInt("How many decorations are you adding?"),
                            Method.getString("It is plastic or wood made?"));
                    try {
                        flowerShop.addProductToInventory(decoration);
                        System.out.println("Products successfully added!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("First create a flower shop, for God's sake!");
            }
        }

        public static void printAllStock() throws IOException {

            if (Txt.checkFlowerShop() != null) {
                if (!flowerShop.getInventory().isEmpty()) {
                    flowerShop.getInventory().forEach(System.out::println);
                } else {
                    System.out.println("You need to add some products first!");
                }
            } else {
                System.out.println("First create a flower shop, for God's sake!");
            }
        }

        public static void removeProduct(String product) throws IOException {

            String removeProduct;

            if (Txt.checkFlowerShop() != null) {
                if (!flowerShop.getInventory().isEmpty()) {
                    removeProduct = Method.getString("Type the name of the " + product + " you want to remove");
                    if(searchDuplicated(removeProduct) != -1) {
                        flowerShop.removeProductFromInventory(removeProduct);
                        System.out.println("Products successfully removed!");
                    } else {
                        System.out.println("There's no product with this name in our inventory");
                    }

                } else {
                    System.out.println("You need to add some products first!");
                }
            } else {
                System.out.println("First create a flower shop, for God's sake!");
            }
        }

        public static void printStockAndQuantities() throws IOException {

            if (Txt.checkFlowerShop() != null) {
                if (!flowerShop.getInventory().isEmpty()) {
                    flowerShop.getInventory().forEach(p -> System.out.println("Name: " + p.getName() + " - Quantity: " + p.getQuantity()));
                } else {
                    System.out.println("You need to add some products first!");
                }
            } else {
                System.out.println("First create a flower shop, for God's sake!");
            }
        }

        public static void printFullValue() throws IOException {

            if (Txt.checkFlowerShop() != null) {
                double totalValue =
                        flowerShop.getInventory().stream()
                                .mapToDouble(p -> p.getQuantity() * p.getPrice())
                                .sum();
                System.out.println("The total value of stock is: " + totalValue + "€");
            } else {
                System.out.println("First create a flower shop, for God's sake!");
            }
        }

        public static void createPurchaseTicket() throws IOException {

            Ticket ticket = null;
            int option;

            if (Txt.checkFlowerShop() != null){
                if (flowerShop.getInventory() != null){
                    do {
                        option = Method.getInt("1. Add product to the ticket." +
                                "\n2. Exit.");

                        switch (option){
                            case 1 -> {
                                if (ticket == null){
                                    ticket = new Ticket();
                                    addProductsTicket(ticket);
                                } else {
                                    addProductsTicket(ticket);
                                }
                            }
                            case 2 -> {
                                if (ticket != null){
                                    flowerShop.addTicketToInvoices(ticket);
                                }
                                System.out.println("Bye!");
                            }
                        }
                    } while (option != 2);
                } else {
                    System.out.println("First add some products, for Gods sake!");
                }
            } else {
                System.out.println("First create a flower shop!");
            }

        }

        private static void addProductsTicket(Ticket ticket) {

            Product product;
            String productName;
            int amount, index;

            productName = Method.getString("Type the name of the product you want to buy");
            index = searchDuplicated(productName);

            if (index != -1){
                amount = Method.getInt("Type the quantity you want to add to the ticket");
                product = flowerShop.getInventory().get(index);
                createPurchaseTicketCalcul(product, amount, ticket, index);
                System.out.println("Product added to the ticket!");
            } else {
                System.out.println("We don't have this type of product");
            }
        }

        public static void createPurchaseTicketCalcul(Product product, int productAmountTicket, Ticket ticket, int index) {

            List<Product> databaseList;

            if (product.getQuantity() >= productAmountTicket) {
                ticket.addProduct(product.getName(), product.getPrice(), productAmountTicket);

                product.removeQuantity(productAmountTicket);
                try {
                    databaseList = flowerShop.getInventory();
                    databaseList.get(index).removeQuantity(productAmountTicket);
                    flowerShop.updateInventory(databaseList);
                    System.out.println("Stock successfully updated!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (product.getQuantity() == 0){
                    try {
                        flowerShop.removeProductFromInventory(product.getName());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                System.out.println("The desired quantity exceeds the stock.");
            }

        }

        public static void printOldPurchases() throws IOException {

            if (Txt.checkFlowerShop() != null) {
                if (!flowerShop.getInvoices().isEmpty()) {
                    System.out.println("All " + flowerShop.getName() + " purchases are:");
                    flowerShop.getInvoices().forEach(System.out::println);
                } else {
                    System.out.println("Create a ticket first!");
                }
            } else {
                System.out.println("First create a flower shop, for God's sake!");
            }
        }

        public static void printTotalSumPurchases() throws IOException {

            double totalValue = 0;

            if (Txt.checkFlowerShop() != null) {
                if (!flowerShop.getInvoices().isEmpty()) {
                    for (Ticket ticket : flowerShop.getInvoices()){
                        totalValue = totalValue + ticket.getTotal();
                    }

                    System.out.println("The flower shop " + flowerShop.getName() + " has sold a total value of " + totalValue + "€.");
                } else {
                    System.out.println("Create a ticket first!");
                }
            } else {
                System.out.println("First create a flower shop, for God's sake!");
            }
        }

    }
}
