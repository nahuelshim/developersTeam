package Services;

import Domain.FlowerShop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Txt {
    private static final String productPath = "Products.txt";
    private static final String ticketPath = "Ticket.txt";
    private static final String flowerShopPath = "FlowerShop.txt";

    public static FlowerShop checkFlowerShop() throws IOException {

        File file = new File(flowerShopPath);
        FlowerShop flowerShop = null;

        ObjectInputStream fis = null;


        try {

            if (file.exists()){

                fis = new ObjectInputStream(new FileInputStream(flowerShopPath));

                while ((flowerShop = (FlowerShop) fis.readObject()) != null){
                    flowerShop = (FlowerShop) fis.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return flowerShop;

    }
}
