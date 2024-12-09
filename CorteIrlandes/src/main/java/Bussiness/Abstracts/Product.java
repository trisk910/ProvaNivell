package Bussiness.Abstracts;

public abstract class Product {
    private static int incrementID = 0;
    private int id;
    private String name;
    private String brand;
    private double price;
    private int stock;
    private String purchaseDate;
    private float discount;

    public Product() {
        this.id = ++incrementID;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }

    public float getDiscount() { return discount; }
    public void setDiscount(float discount) { this.discount = discount; }
}