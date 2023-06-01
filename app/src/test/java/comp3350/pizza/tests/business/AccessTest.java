package pizzaApp.pizza.tests.business;

import org.junit.Before;
import org.junit.Test;
import pizzaApp.pizza.business.Access;
import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.persistence.DataAccess;
import pizzaApp.pizza.tests.persistence.DataAccessStub;
import static org.junit.Assert.*;

public class AccessTest {
    private DataAccess dataAccess;//data access object (stub)
    private Access access;
    private PizzaItem it;

    @Before
    public void setUp() {
        dataAccess = new DataAccessStub();
        dataAccess.open("stubDataBase");
        access = new Access(dataAccess); // let access point to dataAccess
    }

    //---------------------------
    //test get pizzaItem method
    // return pizzaItem object
    //---------------------------
    @Test
    public void testGetPizzaItem() {
        //("001", "Small", "Size", 12.00)
        it = access.getPizzaItem("001");
        assertEquals("Small",it.getName());
        assertEquals(12.00, it.getPrice(),0);
        //("002", "Medium", "Size", 13.00)
        it = access.getPizzaItem("002");
        assertEquals("Medium",it.getName());
        assertEquals(13.00, it.getPrice(),0);
        //("003", "Large", "Size", 14.00)
        it = access.getPizzaItem("003");
        assertEquals("Large",it.getName());
        assertEquals(14.00, it.getPrice(),0);

        //("004", "White", "Crust", 3.00)
        it = access.getPizzaItem("004");
        assertEquals("White",it.getName());
        assertEquals(3.00, it.getPrice(),0);
        //("005", "Whole Wheat", "Crust", 4.00)
        it = access.getPizzaItem("005");
        assertEquals("Whole Wheat",it.getName());
        assertEquals(4.00, it.getPrice(),0);
        //("006", "Keto", "Crust", 5.00)
        it = access.getPizzaItem("006");
        assertEquals("Keto",it.getName());
        assertEquals(5.00, it.getPrice(),0);
        //("007", "Gluten-Free", "Crust", 5.00)
        it = access.getPizzaItem("007");
        assertEquals("Gluten-Free",it.getName());
        assertEquals(5.00, it.getPrice(),0);

        //("008", "Mushrooms", "Topping", 1.00)
        it = access.getPizzaItem("008");
        assertEquals("Mushrooms",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("009", "Basil", "Topping", 1.00)
        it = access.getPizzaItem("009");
        assertEquals("Basil",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("010", "Olives", "Topping", 1.00)
        it = access.getPizzaItem("010");
        assertEquals("Olives",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("011", "Jalapenos", "Topping", 1.00)
        it = access.getPizzaItem("011");
        assertEquals("Jalapenos",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("012", "White Onions", "Topping", 1.00)
        it = access.getPizzaItem("012");
        assertEquals("White Onions",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("013", "Red Onions", "Topping", 1.00)
        it = access.getPizzaItem("013");
        assertEquals("Red Onions",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("014", "Tomatoes", "Topping", 1.00)
        it = access.getPizzaItem("014");
        assertEquals("Tomatoes",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("015", "Green Pepper", "Topping", 1.00)
        it = access.getPizzaItem("015");
        assertEquals("Green Pepper",it.getName());
        assertEquals(1.00, it.getPrice(),0);

        //("016", "Ham", "Topping", 2.00)
        it = access.getPizzaItem("016");
        assertEquals("Ham",it.getName());
        assertEquals(2.00, it.getPrice(),0);
        //("017", "Chicken", "Topping", 2.00)
        it = access.getPizzaItem("017");
        assertEquals("Chicken",it.getName());
        assertEquals(2.00, it.getPrice(),0);
        //("018", "Italian Sausage", "Topping", 2.00)
        it = access.getPizzaItem("018");
        assertEquals("Italian Sausage",it.getName());
        assertEquals(2.00, it.getPrice(),0);
        //("019", "Pepperoni", "Topping", 2.00)
        it = access.getPizzaItem("019");
        assertEquals("Pepperoni",it.getName());
        assertEquals(2.00, it.getPrice(),0);

        //("020", "Classic Red Sauce", "Topping", 1.00)
        it = access.getPizzaItem("020");
        assertEquals("Classic Red Sauce",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("021", "Alfredo Sauce", "Topping", 1.00)
        it = access.getPizzaItem("021");
        assertEquals("Alfredo Sauce",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("022", "Basil Pesto Blend", "Topping", 1.00)
        it = access.getPizzaItem("022");
        assertEquals("Basil Pesto Blend",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("023", "Margherita Sauce", "Topping", 1.00)
        it = access.getPizzaItem("023");
        assertEquals("Margherita Sauce",it.getName());
        assertEquals(1.00, it.getPrice(),0);

        //("024", "Parmesan", "Topping", 1.00)
        it = access.getPizzaItem("024");
        assertEquals("Parmesan",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("025", "Feta", "Topping", 1.00);
        it = access.getPizzaItem("025");
        assertEquals("Feta",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("026", "Mozzarella", "Topping", 1.00);
        it = access.getPizzaItem("026");
        assertEquals("Mozzarella",it.getName());
        assertEquals(1.00, it.getPrice(),0);
        //("027", "Cheddar", "Topping", 1.00)
        it = access.getPizzaItem("027");
        assertEquals("Cheddar",it.getName());
        assertEquals(1.00, it.getPrice(),0);
    }

    //---------------------------
    //test get pizzaItem method
    // return pizzaItem object
    //---------------------------
    @Test

    public void testNotInStub(){
        //find item not in stub  ITEM ID 11111111 NOT in stub
        //find item not in stub

        it = access.getPizzaItem("1111111");
        assertNull(it);
    }

}
