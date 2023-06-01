package pizzaApp.pizza.tests.business;

import pizzaApp.pizza.business.CalculateCost;
import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.object.PizzaPlan;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CalculateCostTest {
    String resultCost, rcEmpty, rcNull, rc1, rc2, rc3, rc4, rc5, rc6, rc7;
    PizzaPlan pizza, pEmpty, p1, p2, p3, p4, p5, p6, p7;
    PizzaItem i1,i2,i3,i4,i5,i6;
    List<PizzaItem> l1,l2,l3,l4,l5,l6,l7,l8;
    double TAX = 1.13;
    double price;

    @Before
    public void setUp() {

        i1 = new PizzaItem("Small",12.00);
        i2 = new PizzaItem("Whole Wheat",4.00);
        i3 = new PizzaItem("Mushrooms",1.00);
        i4 = new PizzaItem("Green Pepper",1.00);
        i5 = new PizzaItem("Classic Red",1.00);
        i6 = new PizzaItem("Cheddar",1.00);

        pizza = new PizzaPlan(null);
        rcNull = null;
        l1 = new ArrayList<>();
        pEmpty = new PizzaPlan("0",l1);
        rcEmpty = "0.0";

        l2 = new ArrayList<>();
        l2.add(i1);
        l2.add(i2);
        l2.add(i5);
        p1 = new PizzaPlan("1",l2);
        rc1 = String.valueOf(19.21);

        l3 = new ArrayList<>();
        l3.add(i2);
        l3.add(i5);
        p2 = new PizzaPlan("2", l3);
        rc2 = String.valueOf(5.65);

        l4 = new ArrayList<>();
        l4.add(i1);
        p3 = new PizzaPlan("3", l4);
        rc3 = String.valueOf(13.56);

        l5 = new ArrayList<>();
        l5.add(i2);
        l5.add(i5);
        l5.add(i3);
        l5.add(i4);
        p4 = new PizzaPlan("4",l5);
        rc4 = String.valueOf(7.91);

        l6 = new ArrayList<>();
        l6.add(i1);
        l6.add(i3);
        l6.add(i4);
        l6.add(i5);
        p5 = new PizzaPlan("5",l6);
        rc5 = String.valueOf(16.95);

        l7 = new ArrayList<>();
        l7.add(i3);
        l7.add(i4);
        l7.add(i5);
        p6 = new PizzaPlan("6",l7);
        rc6 = String.valueOf(3.39);

        l8 = new ArrayList<>();
        l8.add(i1);
        l8.add(i2);
        l8.add(i3);
        l8.add(i4);
        l8.add(i5);
        l8.add(i6);
        p7 = new PizzaPlan("7",l8);
        rc7 = String.valueOf(22.6);
    }

    //------------------
    //test null PizzaPlan
    //------------------
    @Test
    public void testNullPlan() {
        try{
            resultCost = CalculateCost.cost(pizza);
        }catch (NullPointerException npe){}
        assertEquals(rcNull, resultCost);
    }

    //------------------
    //test empty PizzaPlan
    //------------------
    @Test
    public void testEmptyPlan() {
        resultCost = CalculateCost.cost(pEmpty);
        //rcEmpty = $0.0
        assertEquals(rcEmpty, resultCost);
    }

    //------------------
    //test only size, sauce, crust PizzaPlan
    //------------------
    @Test
    public void testNoToppingsPlan() {
        resultCost = CalculateCost.cost(p1);
        //rc1 = $17.00*1.13
        assertEquals(rc1, resultCost);
    }

    //------------------
    //test only crust and sauce PizzaPlan
    //------------------
    @Test
    public void testNoSizeOrToppingsPlan() {
        resultCost = CalculateCost.cost(p2);
        //rc2 = $5.00*1.13
        assertEquals(rc2, resultCost);
    }

    //------------------
    //test only size PizzaPlan
    //------------------
    @Test
    public void testNoCrustOrToppingsPlan() {
        resultCost = CalculateCost.cost(p3);
        //rc3 = $12.00 * 1.13
        assertEquals(rc3, resultCost);
    }

    //------------------
    //test only crust, toppings and sauce PizzaPlan
    //------------------
    @Test
    public void testNoSizePlan() {
        resultCost = CalculateCost.cost(p4);
        //rc4 = $7.00 * 1.13 = 7.91
        assertEquals(rc4, resultCost);
    }

    //------------------
    //test only size, toppings and sauce PizzaPlan
    //------------------
    @Test
    public void testNoCrustPlan() {
        resultCost = CalculateCost.cost(p5);
        //rc5 = $15.00 * 1.13 = 16.95
        assertEquals(rc5, resultCost);
    }

    //------------------
    //test only toppings and sauce PizzaPlan
    //------------------
    @Test
    public void testNoSizeOrCrustPlan() {
        resultCost = CalculateCost.cost(p6);
        //rc6 = $3.00 * 1.13 = 3.39
        assertEquals(rc6, resultCost);
    }

    //------------------
    //test full PizzaPlan
    //------------------
    @Test
    public void testNothingMissingPlan() {
        resultCost = CalculateCost.cost(p7);
        //rc7 = $20.00 * 1.13 = 22.6
        assertEquals(rc7, resultCost);
    }
}
