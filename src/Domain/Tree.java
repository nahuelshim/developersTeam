package Domain;

// sería conveniente añadir un atributo stock para poder sumar y restar el total de productos que tenemos¿¿¿
// creo que debemos crear una nueva clase "producto" porque estamos repitiendo mucho codigo en las clases.
public class Tree extends Product{

    private float height;

    public Tree(float price, int quantity, float height) {
        super(price, quantity);
        this.height = height;

    }

    public float getHeight() {
        return height;
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
        return super.toString()+ height;
    }
}
