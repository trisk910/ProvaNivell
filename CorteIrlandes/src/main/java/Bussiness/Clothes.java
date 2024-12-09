package Bussiness;

import Bussiness.Abstracts.Product;

public class Clothes extends Product {
    private float size;
    private String fabricType;
    private String clothType;

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    public String getClothType() {
        return clothType;
    }

    public void setClothType(String clothType) {
        this.clothType = clothType;
    }
    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + getName() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", price=" + getPrice() +
                ", stock=" + getStock() +
                ", purchaseDate='" + getPurchaseDate() + '\'' +
                ", discount=" + getDiscount() +
                ", size=" + size +
                ", fabricType='" + fabricType + '\'' +
                ", clothType='" + clothType + '\'' +
                '}';
    }
}
