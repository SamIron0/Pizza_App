package pizzaApp.pizza.persistence;

import java.util.ArrayList;

import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.object.PizzaPlan;

public interface DataAccess {

    void open(String string);

    void close();

    PizzaItem getItemByID(String id);

    ArrayList<PizzaPlan> getHistory();

    String getItemID(String name);

    String insertOrder(ArrayList<Integer> newOrder);

    String deletePlanByName(String name);

    int getMaxPlanID();
}
