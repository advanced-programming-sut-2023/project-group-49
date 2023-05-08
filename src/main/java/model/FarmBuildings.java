package model;

public class FarmBuildings extends Buildings{
    private Materials product;

    public FarmBuildings(int x, int y, int health) {
        super(x, y, health);
    }

    public void sendProduct(){

    }

    public Materials getProduct() {
        return product;
    }
}
