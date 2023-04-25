package model;

public class FoodProcessingBuildingsAndWeaponBuildings extends Buildings {
    public Materials material;
    public Materials product;
    public int popularityRate;

    public FoodProcessingBuildingsAndWeaponBuildings(int x, int y, int health) {
        super(x, y, health);
    }

    public void addMaterials(int amount){

    }

    public void addProducts(int amount){

    }


    public void increasePopularityRate(BuildingTypeFoodProcessingAndWeapon building) {

    }

    public void getMaterialByName(String name, Buildings building){

    }

    public void getProductByName(String name, Buildings building){

    }

    public Materials getMaterial() {
        return material;
    }

    public Materials getProduct() {
        return product;
    }
}
