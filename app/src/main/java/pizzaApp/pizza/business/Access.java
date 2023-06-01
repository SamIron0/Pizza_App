package pizzaApp.pizza.business;

import java.util.ArrayList;

import pizzaApp.pizza.application.Main;
import pizzaApp.pizza.application.Services;
import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.object.PizzaPlan;
import pizzaApp.pizza.persistence.DataAccess;

public class Access {
    private DataAccess dataAccess;

    public Access(DataAccess access){
        dataAccess=access;
    }

    public Access() {
        dataAccess = Services.getDataAccess(Main.getDBPathName());
    }

    public PizzaItem getPizzaItem(String id)
    {
        return dataAccess.getItemByID(id);
    }

    public String insertOrder(ArrayList<Integer> itemID)
    {
        return dataAccess.insertOrder(itemID);
    }

    public ArrayList<PizzaPlan> getHistory() { return dataAccess.getHistory(); }

    public String deletePlanByName(String name) { return dataAccess.deletePlanByName(name);}

    public String getItemId(String name) { return dataAccess.getItemID(name); }
}//Access
