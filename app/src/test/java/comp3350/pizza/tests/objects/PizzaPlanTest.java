package pizzaApp.pizza.tests.objects;

import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.object.PizzaPlan;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class PizzaPlanTest {
    private PizzaPlan plan1,plan2,plan3,plan4,plan5,plan6,plan7,plan8,plan9;
    private PizzaItem item1,item2,item3;
    private List<PizzaItem> ListItem1,ListItem2,ListItem3;
    private ArrayList<String> ids;

    @Before
    public void setUp() {
        item1 = new PizzaItem("item1");
        item2 = new PizzaItem("item2");
        item3 = new PizzaItem("item3");
        plan1 = new PizzaPlan("001");
        plan2 = new PizzaPlan(null);
        plan3 = new PizzaPlan("001",null);
        plan4 = new PizzaPlan(null,null);
        ListItem1 = new ArrayList<>();
        plan5 = new PizzaPlan("003",ListItem1);
        ListItem2 = new ArrayList<>();
        ListItem3 = new ArrayList<>();
        ListItem3.add(item1);
        plan6 = new PizzaPlan("",ListItem3);
        ListItem2.add(item1);
        ListItem2.add(item2);
        ListItem2.add(item3);
        plan7 = new PizzaPlan("002",ListItem2);
        plan8 = new PizzaPlan("008",ListItem2,null);
        ids = new ArrayList<String>();
        ids.add("100");
        ids.add("101");
        ids.add("102");
        plan9 = new PizzaPlan("009",ListItem2,ids);
    }

    //------------------
    //test method getID()
    //------------------
    @Test
    public void testID() {
        //plan1 ID:"001"
        assertEquals("001",plan1.getID());
        //plan3 ID:"001"
        assertEquals("001",plan3.getID());
        //plan7 ID:"002"
        assertEquals("002",plan7.getID());
    }

    //------------------
    //test method getItems()
    //------------------
    @Test
    public void testItem() {
        //ListItem3: item1  plan6 : ID= "", List<PizzaItem>=ListItem3
        assertTrue(ListItem3.equals(plan6.getItems()));
        //ListItem1: empty
        // plan5 : ID= "003", List<PizzaItem>=ListItem1
        assertTrue(ListItem1.equals(plan5.getItems()));
        //ListItem2: item1 item2 item3
        // plan7 : ID= "002", List<PizzaItem>=ListItem2
        assertTrue(ListItem2.equals(plan7.getItems()));

    }

    //------------------
    //test method getSize()
    //number of items
    //------------------
    @Test
    public void testItemCount() {
        assertEquals(0,plan5.size());
        assertEquals(0,plan1.size());
        assertEquals(1,plan6.size());
        assertEquals(3,plan7.size());
    }

    //------------------
    //test empty ID
    //------------------
    @Test
    public void testEmptyID() {
        //plan6 ID=""
        assertEquals("",plan6.getID());
    }

    //------------------
    //test empty item
    //------------------
    @Test
    public void testEmptyItems() {
        //plan1： List<PizzaItem> empty
        assertEquals(0,plan1.size());
        //plan2： List<PizzaItem> empty
        assertEquals(0,plan2.size());
        //plan3： List<PizzaItem> empty
        assertEquals(0,plan3.size());
        //plan4： List<PizzaItem> empty
        assertEquals(0,plan4.size());
    }

    //------------------
    //test ItemIDList
    //------------------
    @Test
    public void testItemIDList() {
        //plan8： List<PizzaItem>=ListItem2, null
        assertNull(plan8.getItemIDs());
        //plan9： List<PizzaItem>=ListItem2,ids
        assertEquals(ids,plan9.getItemIDs());
    }

}


