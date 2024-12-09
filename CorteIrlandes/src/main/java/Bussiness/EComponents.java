package Bussiness;

import Bussiness.Abstracts.Product;

public class EComponents extends Product {
    private String imageResolution;
    private float batteryCapacity;
    private final int warranty = 9;

    public String getImageResolution() {
        return imageResolution;
    }

    public void setImageResolution(String imageResolution) {
        this.imageResolution = imageResolution;
    }

    public float getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getWarranty() {
        return warranty;
    }
    @Override
    public String toString() {
        return "ElectronicComponents{" +
                "name='" + getName() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", price=" + getPrice() +
                ", stock=" + getStock() +
                ", purchaseDate='" + getPurchaseDate() + '\'' +
                ", discount=" + getDiscount() +
                ", imageResolution='" + imageResolution + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", warranty=" + warranty +
                '}';
    }
}
