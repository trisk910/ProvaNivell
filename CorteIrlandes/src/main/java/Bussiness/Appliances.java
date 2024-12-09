package Bussiness;

import Bussiness.Abstracts.Product;

public class Appliances extends Product {
    private float voltage;
    private String dateManufacture;
    private float capacity;
    private final int warranty = 18;



    public float getVoltage() {
        return voltage;
    }

    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }

    public String getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(String dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public int getWarranty() {
        return warranty;
    }

    @Override
    public String toString() {
        return "Appliances{" +
                "name='" + getName() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", price=" + getPrice() +
                ", stock=" + getStock() +
                ", purchaseDate='" + getPurchaseDate() + '\'' +
                ", discount=" + getDiscount() +
                ", voltage=" + voltage +
                ", dateManufacture='" + dateManufacture + '\'' +
                ", capacity=" + capacity +
                ", warranty=" + warranty +
                '}';
    }
}
