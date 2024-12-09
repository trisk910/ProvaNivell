package Presentation;

import Bussiness.Abstracts.Product;
import Bussiness.Appliances;
import Bussiness.Beauty;
import Bussiness.Clothes;
import Bussiness.EComponents;
import Persistance.Exceptions.NoWarrantyException;
import Persistance.Exceptions.OutOfStockException;
import Persistance.Exceptions.ProductNotFoundException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UIController {
    private MenuManager menu;
    public UIController(MenuManager menu) {
        this.menu = menu;
    }
    private final String[] systemMessages = {"Welcome to El Corte Irlandes", "Invalid option",
            "Product not avaliable","ERROR: use y/n","ERROR: Wrong Date Format","There is no products"};
    private final String[] exceptionMessages = {"No Appliances found.", "No Beauty products found.",
            "No Clothes products found.", "No Electronic Components found.","The selected product has no warranty.",
            "The selected product is out of stock."};
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Product> productList = new ArrayList<>();

    public void start() throws ProductNotFoundException, NoWarrantyException, OutOfStockException {
        System.out.println(systemMessages[0]);
        int mainOption;
        do{
            mainOption = menu.showMainMenu();
            switch (mainOption) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    createProduct();
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    if (productList.size() > 0){
                        removeProducts();
                    } else{
                        System.out.println(systemMessages[5]);}
                    break;
                case 4:
                    if (productList.size() > 0){
                        calculateWarrantyExpiration();
                    } else{
                        System.out.println(systemMessages[5]);}
                    break;
                case 5:
                    if (productList.size() > 0){
                        applyDiscount();
                    } else{
                        System.out.println(systemMessages[5]);}
                    break;
                case 6:
                    if (productList.size() > 0){
                        listDiscountedProducts();
                    } else{
                        System.out.println(systemMessages[5]);}
                    break;
                case 7:
                    if (productList.size() > 0){
                        checkStock();
                    } else{
                        System.out.println(systemMessages[5]);}
                    break;
                default:
                    System.out.println(systemMessages[1]);
            }
        }while (mainOption != 0);
    }

    private void createProduct(){
        int productOption;
        boolean validOption = false;
        do{
            productOption = menu.showProductMenu();

            switch (productOption) {
                case 1:
                    createAppliance();
                    validOption = true;
                    break;
                case 2:
                    createBeauty();
                    validOption = true;
                    break;
                case 3:
                    createClothes();
                    validOption = true;
                    break;
                case 4:
                    createElectronicComponent();
                    validOption = true;
                    break;
                default:
                    System.out.println(systemMessages[2]);
            }
        }while (!validOption);
    }

    private void createAppliance(){
        Product baseProduct = createBaseProduct();
        System.out.print("Voltage: ");
        float voltage = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Date of Manufacture (YYYY-MM-DD): ");
        String dateManufacture = scanner.nextLine();
        System.out.print("Capacity: ");
        float capacity = scanner.nextFloat();
        scanner.nextLine();
        Appliances appliance = new Appliances();
        appliance.setName(baseProduct.getName());
        appliance.setBrand(baseProduct.getBrand());
        appliance.setPrice(baseProduct.getPrice());
        appliance.setStock(baseProduct.getStock());
        appliance.setPurchaseDate(baseProduct.getPurchaseDate());
        appliance.setDiscount(baseProduct.getDiscount());
        appliance.setVoltage(voltage);
        appliance.setDateManufacture(dateManufacture);
        appliance.setCapacity(capacity);
        productList.add(appliance);
    }

    private void createBeauty(){
        Product baseProduct = createBaseProduct();
        String isVeganQ;
        boolean isVegan = false;
        boolean validOption = false;
        do {
            System.out.print("Is the product vegan?(y/n): ");
            isVeganQ = scanner.nextLine().toLowerCase();
            if (isVeganQ.equals("y") || isVeganQ.equals("n")) {
                validOption = true;
            } else {
                System.out.println(systemMessages[3]);
            }
        } while (!validOption);
        if (isVeganQ.equals("y")){
            isVegan = true;
        }
        System.out.print("What season is it for?: ");
        String season = scanner.nextLine();
        Beauty beauty = new Beauty();
        beauty.setName(baseProduct.getName());
        beauty.setBrand(baseProduct.getBrand());
        beauty.setPrice(baseProduct.getPrice());
        beauty.setStock(baseProduct.getStock());
        beauty.setPurchaseDate(baseProduct.getPurchaseDate());
        beauty.setDiscount(baseProduct.getDiscount());
        beauty.setVegan(isVegan);
        beauty.setSeason(season);
        productList.add(beauty);
    }

    private void createClothes() {
        Product baseProduct = createBaseProduct();
        System.out.print("Size: ");
        float size = askForFloat();
        System.out.print("Fabric Type: ");
        String fabricType = askForString();
        System.out.print("Cloth Type: ");
        String clothType = askForString();
        Clothes clothes = new Clothes();
        clothes.setName(baseProduct.getName());
        clothes.setBrand(baseProduct.getBrand());
        clothes.setPrice(baseProduct.getPrice());
        clothes.setStock(baseProduct.getStock());
        clothes.setPurchaseDate(baseProduct.getPurchaseDate());
        clothes.setDiscount(baseProduct.getDiscount());
        clothes.setSize(size);
        clothes.setFabricType(fabricType);
        clothes.setClothType(clothType);
        productList.add(clothes);
    }

    private void createElectronicComponent(){
        Product baseProduct = createBaseProduct();
        System.out.print("Resolution: ");
        String resolution = askForString();
        System.out.print("Battery Capacity: ");
        float batteryCapacity = askForFloat();
        EComponents electronicComponent = new EComponents();
        electronicComponent.setName(baseProduct.getName());
        electronicComponent.setBrand(baseProduct.getBrand());
        electronicComponent.setPrice(baseProduct.getPrice());
        electronicComponent.setStock(baseProduct.getStock());
        electronicComponent.setPurchaseDate(baseProduct.getPurchaseDate());
        electronicComponent.setDiscount(baseProduct.getDiscount());
        electronicComponent.setImageResolution(resolution);
        electronicComponent.setBatteryCapacity(batteryCapacity);
        productList.add(electronicComponent);
    }

    private Product createBaseProduct() {
        System.out.println("Enter Appliance Details:");
        System.out.print("Name: ");
        String name = askForString();
        System.out.print("Brand: ");
        String brand = askForString();
        System.out.print("Price: ");
        double price = askForDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Purchase Date (YYYY-MM-DD): ");
        String purchaseDate = scanner.nextLine();
        System.out.print("Discount: ");
        float discount = scanner.nextFloat();
        scanner.nextLine();
        Product baseProduct = new Product() {};
        baseProduct.setName(name);
        baseProduct.setBrand(brand);
        baseProduct.setPrice(price);
        baseProduct.setStock(stock);
        baseProduct.setPurchaseDate(purchaseDate);
        baseProduct.setDiscount(discount);
        return baseProduct;
    }

    private void sortProductListByPrice() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
    }

    private void removeProducts() throws ProductNotFoundException {
        int productOption;
        boolean validOption = false;
        do{
            productOption = menu.showRemoveProductMenu();
            switch (productOption) {
                case 1:
                    removeAppliance();
                    validOption = true;
                    break;
                case 2:
                    removeBeauty();
                    validOption = true;
                    break;
                case 3:
                    removeClothes();
                    validOption = true;
                    break;
                case 4:
                    removeElectronicComponent();
                    validOption = true;
                    break;
                default:
                    System.out.println(systemMessages[2]);
            }
        }while (!validOption);
    }

    private void removeAppliance() throws ProductNotFoundException {
        boolean found = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Appliances) {
                System.out.println(i + ". " + productList.get(i).getName());
                found = true;
            }
        }
        if (!found) {
            throw new ProductNotFoundException(exceptionMessages[0]);
        }else{
            System.out.print("Enter the number to remove: ");
            int index = askForInt();
            scanner.nextLine();
            productList.remove(index);
        }
    }
    private void removeBeauty() throws ProductNotFoundException {
        boolean found = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Beauty) {
                System.out.println(i + ". " + productList.get(i).getName());
                found = true;
            }
        }
        if (!found) {
            throw new ProductNotFoundException(exceptionMessages[1]);
        }else{
            System.out.print("Enter the number to remove: ");
            int index = askForInt();
            scanner.nextLine();
            productList.remove(index);
        }
    }
    private void removeClothes() throws ProductNotFoundException {
        boolean found = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof Clothes) {
                System.out.println(i + ". " + productList.get(i).getName());
                found = true;
            }
        }
        if (!found) {
            throw new ProductNotFoundException(exceptionMessages[2]);
        }else{
            System.out.print("Enter the number to remove: ");
            int index = askForInt();
            scanner.nextLine();
            productList.remove(index);
        }

    }
    private void removeElectronicComponent() throws ProductNotFoundException {
        boolean found = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) instanceof EComponents) {
                System.out.println(i + ". " + productList.get(i).getName());
                found = true;
            }
        }
        if (!found) {
            throw new ProductNotFoundException(exceptionMessages[3]);
        }else{
            System.out.print("Enter the number to remove: ");
            int index = askForInt();
            scanner.nextLine();
            productList.remove(index);
        }

    }

    private void calculateWarrantyExpiration() throws NoWarrantyException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i+1) + ". " + productList.get(i).getName());
        }

        System.out.print("Enter the number of the product to check warranty expiration: ");
        int index = askForInt();
        index--;
        scanner.nextLine();

        if (index >= 0 && index < productList.size()) {
            Product product = productList.get(index);
            LocalDate purchaseDate = LocalDate.parse(product.getPurchaseDate(), formatter);
            int warranty = 0;

            if (product instanceof Appliances) {
                warranty = ((Appliances) product).getWarranty();
            } else if (product instanceof EComponents) {
                warranty = ((EComponents) product).getWarranty();
            }
            if (warranty > 0) {
                LocalDate expirationDate = purchaseDate.plus(warranty, ChronoUnit.MONTHS);
                System.out.println("Product: " + product.getName() + ", Warranty Expiration Date: " + expirationDate);
            } else {
                throw new NoWarrantyException(exceptionMessages[4]);
            }
        } else {
            System.out.println(systemMessages[1]);
        }
    }

    private void applyDiscount() {
        if (productList.size() > 0) {
            for (int i = 0; i < productList.size(); i++) {
                System.out.println((i + 1) + ". " + productList.get(i).getName());
            }
            System.out.print("Enter the number of the product to apply discount: ");
            int index = askForInt();
            index--;
            scanner.nextLine();
            if (index >= 0 && index < productList.size()) {
                Product product = productList.get(index);
                System.out.print("Enter the discount value: ");
                float discount = askForFloat();
                scanner.nextLine();
                product.setDiscount(discount);
            } else {
                System.out.println(systemMessages[1]);
            }
        } else {
            System.out.println(systemMessages[5]);
        }


    }

    private void listDiscountedProducts() {
        productList.forEach(product -> {
            if (product.getDiscount() > 0) {
                System.out.println(product);
            }
        });
    }
    private void listProducts() {
        if (productList.size() > 0) {
            sortProductListByPrice();
            productList.forEach(product -> System.out.println(product));
        } else {
            System.out.println(systemMessages[5]);
        }
    }


    private void checkStock() throws OutOfStockException {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i+1) + ". " + productList.get(i).getName());
        }
        System.out.print("Enter the number of the product to check stock: ");
        int index = askForInt();
        index--;
        scanner.nextLine();
        if (index >= 0 && index < productList.size()) {
            Product product = productList.get(index);
            if(product.getStock() > 0){
                System.out.println("Product: " + product.getName() + ", Stock: " + product.getStock());
            } else {
                throw new OutOfStockException(exceptionMessages[5]);
            }
        } else {
            System.out.println(systemMessages[1]);
        }
    }
    private String askForString() {
        return scanner.nextLine();
    }
    private double askForDouble() {
        return scanner.nextDouble();
    }
    private float askForFloat() {
        return scanner.nextFloat();
    }
    private int askForInt() {
        return scanner.nextInt();
    }


}
