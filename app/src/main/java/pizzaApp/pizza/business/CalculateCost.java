package pizzaApp.pizza.business;

import java.util.Iterator;
import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.object.PizzaPlan;

public class CalculateCost {

    public static String cost(PizzaPlan pizza) {

        double TAX = 1.13;
        PizzaItem element;
        double totalCost = 0.0;
        double price;
        String money = null;

        if (pizza.getItems() != null) {
            for (Iterator<PizzaItem> it = pizza.getItems().iterator(); it.hasNext(); ) {
                element = it.next();
                if (!(element instanceof PizzaItem)) {
                    money = "wrong input ";
                    //print wrong input
                    System.out.println(money);
                    break;
                }//if
                else{
                    price = ((PizzaItem)element).getPrice();
                    totalCost += price;
                }//else
            }//for
            totalCost = totalCost*TAX;
            totalCost = Math.round(totalCost * 100.0)/100.0;
            money = "" + totalCost;
        }//if

        return money;
    }//cost
}//CalculateCost
