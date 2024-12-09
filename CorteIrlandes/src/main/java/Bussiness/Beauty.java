package Bussiness;

import Bussiness.Abstracts.Product;

public class Beauty extends Product {
    private boolean vegan;
    private String season;


    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Beauty{" +
                "name='" + getName() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", price=" + getPrice() +
                ", stock=" + getStock() +
                ", purchaseDate='" + getPurchaseDate() + '\'' +
                ", discount=" + getDiscount() +
                ", vegan='" + vegan + '\'' +
                ", season=" + season +
                '}';
    }
}
