package pizzaApp.pizza.tests.objects;

import org.junit.Before;
import org.junit.Test;
import pizzaApp.pizza.object.PizzaItem;
import static org.junit.Assert.*;

public class PizzaItemTest {
    private PizzaItem PI1,PI2,PI3,PI4,PI5;

    @Before
    public void setUp() {
        PI1 = new PizzaItem("Item1",12.00);
        PI2 = new PizzaItem("Item2",5.00);
        PI3 = new PizzaItem("");
        PI4 = new PizzaItem("",0.00);
        PI5 = new PizzaItem(null,0.00);

    }

    //------------------
    //test method getPrice()
    //------------------
    @Test
    public void testPrice() {
        //PI1 name: "Item1 " price: 12.00
        assertEquals(12.00,PI1.getPrice(),0);
        //PI2 name: "Item2 " price: 5.00
        assertEquals(5.00,PI2.getPrice(),0);
    }

    //------------------
    //test method getName()
    //------------------
    @Test
    public void testName() {
        //PI2 name: "Item2 "
        assertEquals("Item2",PI2.getName());
        //PI5 name: null price: null
        assertEquals(null,PI5.getName());
    }

    //------------------
    //test empty name and price
    //------------------
    @Test
    public void testEmpty() {
        //PI3 name: "" price: 5
        assertEquals("",PI3.getName());
        //PI4 name: "" price: 0.00
        assertEquals("",PI4.getName());
        //PI4 name: "" price: 0.00
        assertEquals(0.00,PI4.getPrice(),0);
    }
}
