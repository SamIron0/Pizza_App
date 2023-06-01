package pizzaApp.pizza.tests.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pizzaApp.pizza.application.Services;
import pizzaApp.pizza.application.Main;
import pizzaApp.pizza.business.Access;
import pizzaApp.pizza.object.PizzaItem;
import static org.junit.Assert.*;
import pizzaApp.pizza.object.PizzaPlan;
import java.util.ArrayList;

public class BusinessPersistenceSeamTest {

    private Access aItem;
    private PizzaItem item;
    String result = "";
    private ArrayList<Integer> pizzaPlan = new ArrayList<Integer>();
    private ArrayList<PizzaPlan> planList = new ArrayList<PizzaPlan>();
    private PizzaPlan currentPlan;
    private String planHistory = "History";

    @Before
    public void setup() {
        Services.closeDataAccess();
        System.out.println("\nStarting Integration test of AccessGetPizzaItem to persistence");
        Services.createDataAccess(Main.dbName);
        aItem = new Access();
    }

    @Test
    public void testAccessGetPizzaItem() {
        //size
        //(1,'Small',12.0E0)
        item = aItem.getPizzaItem("1");
        assertEquals("Small",item.getName());
        assertEquals(12.00,item.getPrice(),0);
        //(2,'Medium',13.0E0)
        item = aItem.getPizzaItem("2");
        assertEquals("Medium",item.getName());
        assertEquals(13.00,item.getPrice(),0);
        //(3,'Large',14.0E0)
        item = aItem.getPizzaItem("3");
        assertEquals("Large",item.getName());
        assertEquals(14.00,item.getPrice(),0);

        //crust
        //(4,'White',3.0E0)
        item = aItem.getPizzaItem("4");
        assertEquals("White",item.getName());
        assertEquals(3.00,item.getPrice(),0);
        //(5,'Whole Wheat',4.0E0)
        item = aItem.getPizzaItem("5");
        assertEquals("Whole Wheat",item.getName());
        assertEquals(4.00,item.getPrice(),0);
        //(6,'Keto',5.0E0)
        item = aItem.getPizzaItem("6");
        assertEquals("Keto",item.getName());
        assertEquals(5.00,item.getPrice(),0);
        //(7,'Gluten-Free',5.0E0)
        item = aItem.getPizzaItem("7");
        assertEquals("Gluten-Free",item.getName());
        assertEquals(5.00,item.getPrice(),0);

        //Vegetable
        //(8,'Mushrooms',1.0E0)
        item = aItem.getPizzaItem("8");
        assertEquals("Mushrooms",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(9,'Basil',1.0E0
        item = aItem.getPizzaItem("9");
        assertEquals("Basil",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(10,'Olives',1.0E0)
        item = aItem.getPizzaItem("10");
        assertEquals("Olives",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(11,'Jalapenos',1.0E0)
        item = aItem.getPizzaItem("11");
        assertEquals("Jalapenos",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(12,'White Onions',1.0E0)
        item = aItem.getPizzaItem("12");
        assertEquals("White Onions",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(13,'Red Onions',1.0E0)
        item = aItem.getPizzaItem("13");
        assertEquals("Red Onions",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(14,'Tomatoes',1.0E0)
        item = aItem.getPizzaItem("14");
        assertEquals("Tomatoes",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(15,'Green Pepper',1.0E0)
        item = aItem.getPizzaItem("15");
        assertEquals("Green Pepper",item.getName());
        assertEquals(1.00,item.getPrice(),0);

        //Meat
        //(16,'Ham',2.0E0)
        item = aItem.getPizzaItem("16");
        assertEquals("Ham",item.getName());
        assertEquals(2.00,item.getPrice(),0);
        //(17,'Chicken',2.0E0)
        item = aItem.getPizzaItem("17");
        assertEquals("Chicken",item.getName());
        assertEquals(2.00,item.getPrice(),0);
        //(18,'Italian Sausage',2.0E0)
        item = aItem.getPizzaItem("18");
        assertEquals("Italian Sausage",item.getName());
        assertEquals(2.00,item.getPrice(),0);
        //(19,'Pepperoni',2.0E0)
        item = aItem.getPizzaItem("19");
        assertEquals("Pepperoni",item.getName());
        assertEquals(2.00,item.getPrice(),0);

        //Sauce
        //(20,'Classic Red Sauce',1.0E0)
        item = aItem.getPizzaItem("20");
        assertEquals("Classic Red Sauce",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(21,'Alfredo Sauce',1.0E0)
        item = aItem.getPizzaItem("21");
        assertEquals("Alfredo Sauce",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(22,'Basil Pesto Blend',1.0E0)
        item = aItem.getPizzaItem("22");
        assertEquals("Basil Pesto Blend",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(23,'Margherita Sauce',1.0E0)
        item = aItem.getPizzaItem("23");
        assertEquals("Margherita Sauce",item.getName());
        assertEquals(1.00,item.getPrice(),0);

        //Cheese
        //(24,'Parmesan',1.0E0)
        item = aItem.getPizzaItem("24");
        assertEquals("Parmesan",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(25,'Feta',1.0E0
        item = aItem.getPizzaItem("25");
        assertEquals("Feta",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(26,'Mozzarella',1.0E0)
        item = aItem.getPizzaItem("26");
        assertEquals("Mozzarella",item.getName());
        assertEquals(1.00,item.getPrice(),0);
        //(27,'Cheddar',1.0E0)
        item = aItem.getPizzaItem("27");
        assertEquals("Cheddar",item.getName());
        assertEquals(1.00,item.getPrice(),0);

        //insert a Plan
        //(1,'Small','Size',12.0E0)
        pizzaPlan.add(1);
        //(5,'Whole Wheat','Crust',4.0E0)
        pizzaPlan.add(5);
        //(20,'Classic Red Sauce','Sauce',1.0E0)
        pizzaPlan.add(20);
        //(27,'Cheddar','Cheese',1.0E0)
        pizzaPlan.add(27);
        //(28,'Barbeque','Sauce',1.0E0)
        pizzaPlan.add(28);
        //(11,'Jalapenos','Vegetable',1.0E0)
        pizzaPlan.add(11);

        //test insertOrder()
        result = aItem.insertOrder(pizzaPlan);
        assertNull(result);
        //test getHistory()
        planList = aItem.getHistory();
        currentPlan = planList.get(1);
        //System.out.printf("id:%s\n", currentPlan.getID());
        assertEquals("Veggie Lovers",currentPlan.getID());
        aItem.deletePlanByName(planHistory);

        Services.closeDataAccess();
        System.out.println("Finished Integration test of AccessGetPizzaItem to persistence");
    }

    @After
    public void breakDown() {
        Services.closeDataAccess();
        System.out.println("Finished Integration test of Access to persistence");
    }
}
