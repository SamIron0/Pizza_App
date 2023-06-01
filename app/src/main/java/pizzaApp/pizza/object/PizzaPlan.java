package pizzaApp.pizza.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PizzaPlan {

    private String ID;
    private List<PizzaItem> items;
    private ArrayList<String> itemIDList;
    private int count = 0;

    public PizzaPlan(String ID) {
        this.ID=ID;
        items = null;

    }//constructor

    public PizzaPlan(String ID, List<PizzaItem> items) {
        this.ID = ID;
        this.items = items;
        if(items!=null) {
            count = items.size();
        }
    }
    public PizzaPlan(String ID, List<PizzaItem> items, ArrayList<String> itemIDs) {
        this.ID = ID;
        this.items = items;
        this.itemIDList = itemIDs;
        if(items!=null) {
            count = items.size();
        }
    }

    public List<PizzaItem> getItems() {
        return items;
    }

    public ArrayList<String> getItemIDs() { return itemIDList; }

    public String getID() {
        return ID;
    }

    public int size(){
        return count;
    }

    public boolean equals(Object object) {
        boolean result;
        PizzaPlan key;

        result = false;

        if (object instanceof PizzaPlan) {
            key = (PizzaPlan) object;
            if (((key.ID == null) && (ID == null)) || (Objects.equals(key.ID, ID))) {
                result = true;
            }
        }
        return result;
    }//equals
}//PizzaPlan
