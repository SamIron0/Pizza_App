package pizzaApp.pizza.tests.persistence;

import junit.framework.TestCase;

import pizzaApp.pizza.object.PizzaItem;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import pizzaApp.pizza.object.PizzaPlan;
import pizzaApp.pizza.persistence.DataAccess;

public class DataAccessTest{
    private DataAccess dataAccess;
    private PizzaItem theItem;
    private ArrayList<PizzaPlan> thePlanList;
    private PizzaPlan thePlan;
    private String result;

    public DataAccessTest() {
        super();
    }

    /*public DataAccessTest(String arg0)
    {
        super(arg0);
    }*/

    @Before
    public void setUp() {
        //open data stub
        System.out.println("\nStarting Persistence test DataAccess (using stub)");
        dataAccess = new DataAccessStub();
        dataAccess.open("Stub");
    }

    @After
    public void tearDown() {
        System.out.println("Finished Persistence test DataAccess (using stub)");
    }

    public static void dataAccessTest(DataAccess dataAccess) {
        DataAccessTest dataAccessTest = new DataAccessTest();
        dataAccessTest.dataAccess = dataAccess;
        dataAccessTest.itemName();

    }

    //---------------------------
    //test getItemByID method
    //---------------------------
    @Test
    public void itemName() {
        //("001", "Small", "Size", 12.00)
        theItem = dataAccess.getItemByID("001");
        assertEquals("Small",theItem.getName());
        assertEquals(12.00, theItem.getPrice(), 0);
        //("002", "Medium", "Size", 13.00)
        theItem = dataAccess.getItemByID("002");
        assertEquals("Medium",theItem.getName());
        assertEquals(13.00, theItem.getPrice(), 0);
        //("003", "Large", "Size", 14.00)
        theItem = dataAccess.getItemByID("003");
        assertEquals("Large",theItem.getName());
        assertEquals(14.00, theItem.getPrice(), 0);

        //("004", "White", "Crust", 3.00)
        theItem = dataAccess.getItemByID("004");
        assertEquals("White",theItem.getName());
        assertEquals(3.00, theItem.getPrice(), 0);
        //("005", "Whole Wheat", "Crust", 4.00)
        theItem = dataAccess.getItemByID("005");
        assertEquals("Whole Wheat",theItem.getName());
        assertEquals(4.00, theItem.getPrice(), 0);
        //("006", "Keto", "Crust", 5.00)
        theItem = dataAccess.getItemByID("006");
        assertEquals("Keto",theItem.getName());
        assertEquals(5.00, theItem.getPrice(), 0);
        //("007", "Gluten-Free", "Crust", 5.00)
        theItem = dataAccess.getItemByID("007");
        assertEquals("Gluten-Free",theItem.getName());
        assertEquals(5.00, theItem.getPrice(), 0);

        //("008", "Mushrooms", "Topping", 1.00)
        theItem = dataAccess.getItemByID("008");
        assertEquals("Mushrooms",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("009", "Basil", "Topping", 1.00)
        theItem = dataAccess.getItemByID("009");
        assertEquals("Basil",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("010", "Olives", "Topping", 1.00)
        theItem = dataAccess.getItemByID("010");
        assertEquals("Olives",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("011", "Jalapenos", "Topping", 1.00)
        theItem = dataAccess.getItemByID("011");
        assertEquals("Jalapenos",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("012", "White Onions", "Topping", 1.00)
        theItem = dataAccess.getItemByID("012");
        assertEquals("White Onions",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("013", "Red Onions", "Topping", 1.00)
        theItem = dataAccess.getItemByID("013");
        assertEquals("Red Onions",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("014", "Tomatoes", "Topping", 1.00)
        theItem = dataAccess.getItemByID("014");
        assertEquals("Tomatoes",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("015", "Green Pepper", "Topping", 1.00)
        theItem = dataAccess.getItemByID("015");
        assertEquals("Green Pepper",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);

        //("016", "Ham", "Topping", 2.00)
        theItem = dataAccess.getItemByID("016");
        assertEquals("Ham",theItem.getName());
        assertEquals(2.00, theItem.getPrice(), 0);
        //("017", "Chicken", "Topping", 2.00)
        theItem = dataAccess.getItemByID("017");
        assertEquals("Chicken",theItem.getName());
        assertEquals(2.00, theItem.getPrice(), 0);
        //("018", "Italian Sausage", "Topping", 2.00)
        theItem = dataAccess.getItemByID("018");
        assertEquals("Italian Sausage",theItem.getName());
        assertEquals(2.00, theItem.getPrice(), 0);
        //("019", "Pepperoni", "Topping", 2.00)
        theItem = dataAccess.getItemByID("019");
        assertEquals("Pepperoni",theItem.getName());
        assertEquals(2.00, theItem.getPrice(), 0);

        //("020", "Classic Red Sauce", "Topping", 1.00)
        theItem = dataAccess.getItemByID("020");
        assertEquals("Classic Red Sauce",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("021", "Alfredo Sauce", "Topping", 1.00)
        theItem = dataAccess.getItemByID("021");
        assertEquals("Alfredo Sauce",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("022", "Basil Pesto Blend", "Topping", 1.00)
        theItem = dataAccess.getItemByID("022");
        assertEquals("Basil Pesto Blend",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("023", "Margherita Sauce", "Topping", 1.00)
        theItem = dataAccess.getItemByID("023");
        assertEquals("Margherita Sauce",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);

        //("024", "Parmesan", "Topping", 1.00)
        theItem = dataAccess.getItemByID("024");
        assertEquals("Parmesan",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("025", "Feta", "Topping", 1.00);
        theItem = dataAccess.getItemByID("025");
        assertEquals("Feta",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("026", "Mozzarella", "Topping", 1.00);
        theItem = dataAccess.getItemByID("026");
        assertEquals("Mozzarella",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
        //("027", "Cheddar", "Topping", 1.00)
        theItem = dataAccess.getItemByID("027");
        assertEquals("Cheddar",theItem.getName());
        assertEquals(1.00, theItem.getPrice(), 0);
    }
    //--------------------------------------------------
    //test getHistory, maxPlanID and insertOrder methods
    //--------------------------------------------------
    @Test
    public void history() {
        //test maxID with empty history
        int maxID = dataAccess.getMaxPlanID();
        assertEquals(900, maxID);
        //retrieve empty history
        thePlanList = dataAccess.getHistory();
        assertNotNull(thePlanList);
        assertEquals(0,thePlanList.size());
        thePlanList.clear();
        //test insertOrder
        ArrayList<Integer> newItemsForOrder = new ArrayList<>();
        newItemsForOrder.add(Integer.parseInt("004"));//white, 3.00
        newItemsForOrder.add(Integer.parseInt("019")); //pepperoni, 2.00
        newItemsForOrder.add(Integer.parseInt("020"));//classic red sauce, 1.00
        newItemsForOrder.add(Integer.parseInt("027"));//cheddar, 1.00
        assertEquals(4,newItemsForOrder.size());
        result = dataAccess.insertOrder(newItemsForOrder);
        assertEquals("history",result);
        //test maxID with one order inserted into history
        maxID = dataAccess.getMaxPlanID();
        assertEquals(1000,maxID);
        //history with 1 item
        thePlanList = dataAccess.getHistory();
        assertNotNull(thePlanList);
        assertEquals(1, thePlanList.size());
        //history with multiple items
        newItemsForOrder.clear();
        newItemsForOrder.add(004);//white, 3.00
        newItemsForOrder.add(19); //pepperoni, 2.00
        newItemsForOrder.add(020);//classic red sauce, 1.00
        newItemsForOrder.add(027);//cheddar, 1.00
        dataAccess.insertOrder(newItemsForOrder);
        thePlanList = dataAccess.getHistory();
        assertNotNull(thePlanList);
        assertEquals(2, thePlanList.size());
    }

    //--------------------------
    //test getItemID method
    //--------------------------
    @Test
    public void itemID() {
        //some item
        result = dataAccess.getItemID("Mushrooms");
        assertNotNull(result);
        assertEquals("008", result);
        //first item
        result = dataAccess.getItemID("Small");
        assertNotNull(result);
        assertEquals("001", result);
        //last item
        result = dataAccess.getItemID("Cheddar");
        assertNotNull(result);
        assertEquals("027", result);
    }

}

