import Persistance.Exceptions.NoWarrantyException;
import Persistance.Exceptions.OutOfStockException;
import Persistance.Exceptions.ProductNotFoundException;
import Presentation.MenuManager;
import Presentation.UIController;

public class Main {
    public static void main(String[] args) throws ProductNotFoundException, NoWarrantyException, OutOfStockException {
        MenuManager menu = new MenuManager();
        UIController uiController = new UIController(menu);
        uiController.start();

    }
}