import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException {

        int option;

        do {
            System.out.println("""
                    
                    What would you like to do?
                    1- Create Flower Shop.
                    2. Add a tree.
                    3. Add a flower.
                    4. Add a decoration.
                    5. Print all the stock from the flower shop.
                    6. Remove tree.
                    7. Remove flower.
                    8. Remove decoration.
                    9. Print stock & quantities.
                    10. Print full flower shop value.
                    11. Create a purchase ticket.
                    12. Print old purchases.
                    13. Print total sum of all purchases.
                    Choose an option""");

            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            switch (option) {
                case 1 -> Menu.createFlowerShop();
                case 2 -> Menu.addTree();
                case 3 -> Menu.addFlower();
                case 4 -> Menu.addDecoration();
                case 5 -> Menu.printAllStock();
                case 6 -> Menu.removeProduct("tree");
                case 7 -> Menu.removeProduct("flower");
                case 8 -> Menu.removeProduct("decoration");
                case 9 -> Menu.printStockAndQuantities();
                case 10 -> Menu.printFullValue();
                case 11 -> Menu.createPurchaseTicket();
                case 12 -> Menu.printOldPurchases();
                case 13 -> Menu.printTotalSumPurchases();
            }
        } while (option != 0);
    }
}