package Domain;

// sería conveniente añadir un atributo stock para poder sumar y restar el total de productos que tenemos¿¿¿
// creo que debemos crear una nueva clase "producto" porque estamos repitiendo mucho codigo en las clases.
public class Flower extends  Product {

    private String color;

    public Flower(float price, int quantity, String color) {
        super(price, quantity);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void addQuantity(int quantity) {
        super.addQuantity(quantity);
    }

    @Override
    public void removeQuantity(int quantity) {
        super.removeQuantity(quantity);
    }

    @Override
    public String toString() {
        return super.toString() + color;
    }
}
