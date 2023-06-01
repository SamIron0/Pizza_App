package pizzaApp.pizza.tests.persistence;

import java.util.ArrayList;
import java.util.List;

import pizzaApp.pizza.application.Main;
import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.object.PizzaPlan;
import pizzaApp.pizza.persistence.DataAccess;

public class DataAccessStub implements DataAccess {
    private String dbName;
    private String dbType = "stub";
    private PizzaItem item;
    private static int count = 0;
    private ArrayList<Items> ItemList;
    private ArrayList<Plans> PlanList;

    public class Items {
        private String itemID;
        private String itemName;
        private String itemType;
        private double itemPrice;

        public Items(String ID, String name, double price) {
            itemID = ID;
            itemName = name;
            itemPrice = price;
        }
        public boolean equals(Object object)
        {
            boolean result;
            Items c;

            result = false;

            if (object instanceof Items)
            {
                c = (Items) object;
                if (((c.itemID == null) && (itemID == null)) || (c.itemID.equals(itemID)))
                {
                    result = true;
                }
            }
            return result;
        }
    }
    public class Plans {
        private String planID;
        private String planName;
        private ArrayList<String> listItemID;

        public Plans(String ID, String name, ArrayList<String> itemIDList) {
        planID = ID;
        planName = name;
        listItemID = new ArrayList<>();
    }
    public boolean equals(Object object)
    {
        boolean result;
        Plans c;

        result = false;

        if (object instanceof Plans)
        {
            c = (Plans) object;
                if (((c.planID == null) && (planID == null)) || (c.planID.equals(planID)))
                {
                    result = true;
                }
            }
            return result;
        }
    }

    public DataAccessStub(String dbName) {
        this.dbName = dbName;
    }

    public DataAccessStub() {
        this(Main.dbName);
    }

    public void open(String dbPath) {
        Plans planToAdd;
        ItemList = new ArrayList<>();
        PlanList = new ArrayList<>();
        ArrayList<String> itemsList = new ArrayList<>();

        Items item1 = new Items("001", "Small",12.00);
        Items item2 = new Items("002", "Medium",13.00);
        Items item3 = new Items("003", "Large",14.00);

        Items item4 = new Items("004", "White",3.00);
        Items item5 = new Items("005", "Whole Wheat",4.00);
        Items item6 = new Items("006", "Keto", 5.00);
        Items item7 = new Items("007", "Gluten-Free", 5.00);

        Items item8 = new Items("008", "Mushrooms", 1.00);
        Items item9 = new Items("009", "Basil", 1.00);
        Items item10 = new Items("010", "Olives", 1.00);
        Items item11 = new Items("011", "Jalapenos", 1.00);
        Items item12 = new Items("012", "White Onions", 1.00);
        Items item13 = new Items("013", "Red Onions", 1.00);
        Items item14 = new Items("014", "Tomatoes", 1.00);
        Items item15 = new Items("015", "Green Pepper", 1.00);
        Items item16 = new Items("016", "Ham", 2.00);
        Items item17 = new Items("017", "Chicken", 2.00);
        Items item18 = new Items("018", "Italian Sausage", 2.00);
        Items item19 = new Items("019", "Pepperoni", 2.00);

        Items item20 = new Items("020", "Classic Red Sauce", 1.00);
        Items item21 = new Items("021", "Alfredo Sauce", 1.00);
        Items item22 = new Items("022", "Basil Pesto Blend", 1.00);
        Items item23 = new Items("023", "Margherita Sauce", 1.00);

        Items item24 = new Items("024", "Parmesan", 1.00);
        Items item25 = new Items("025", "Feta", 1.00);
        Items item26 = new Items("026", "Mozzarella", 1.00);
        Items item27 = new Items("027", "Cheddar", 1.00);
        ItemList.add(item1);
        ItemList.add(item2);
        ItemList.add(item3);
        ItemList.add(item4);
        ItemList.add(item5);
        ItemList.add(item6);
        ItemList.add(item7);
        ItemList.add(item8);
        ItemList.add(item9);
        ItemList.add(item10);
        ItemList.add(item11);
        ItemList.add(item12);
        ItemList.add(item13);
        ItemList.add(item14);
        ItemList.add(item15);
        ItemList.add(item16);
        ItemList.add(item17);
        ItemList.add(item18);
        ItemList.add(item19);
        ItemList.add(item20);
        ItemList.add(item21);
        ItemList.add(item22);
        ItemList.add(item23);
        ItemList.add(item24);
        ItemList.add(item25);
        ItemList.add(item26);
        ItemList.add(item27);


        itemsList.add("004");
        itemsList.add("017");
        itemsList.add("027");
        itemsList.add("028");
        itemsList.add("011");
        planToAdd = new Plans("0100", "BBQ Chicken", itemsList);
        PlanList.add(planToAdd);
        itemsList.clear();
        itemsList.add("005");
        itemsList.add("020");
        itemsList.add("027");
        itemsList.add("014");
        itemsList.add("013");
        itemsList.add("011");
        planToAdd = new Plans("0200", "Veggie Lovers", itemsList);
        PlanList.add(planToAdd);
        itemsList.clear();
        itemsList.add("004");
        itemsList.add("020");
        itemsList.add("027");
        itemsList.add("016");
        itemsList.add("018");
        itemsList.add("017");
        itemsList.add("019");
        planToAdd = new Plans("0300", "Meat Lovers", itemsList);
        PlanList.add(planToAdd);
        itemsList.clear();
        itemsList.add("004");
        itemsList.add("020");
        itemsList.add("027");
        planToAdd = new Plans("0400", "Cheesy Supreme", itemsList);
        PlanList.add(planToAdd);
        itemsList.clear();
        itemsList.add("005");
        itemsList.add("020");
        itemsList.add("026");
        itemsList.add("009");
        planToAdd = new Plans("0500", "Margherita", itemsList);
        PlanList.add(planToAdd);
        itemsList.clear();
        itemsList.add("004");
        itemsList.add("020");
        itemsList.add("026");
        itemsList.add("027");
        itemsList.add("019");
        planToAdd = new Plans("0600", "Classic Pepperoni", itemsList);
        PlanList.add(planToAdd);
        itemsList.clear();
        itemsList.add("005");
        itemsList.add("017");
        itemsList.add("021");
        itemsList.add("024");
        planToAdd = new Plans("0700", "Chicken Alfredo", itemsList);
        PlanList.add(planToAdd);
        itemsList.clear();
        itemsList.add("004");
        itemsList.add("020");
        itemsList.add("026");
        itemsList.add("027");
        itemsList.add("019");
        itemsList.add("015");
        itemsList.add("008");
        itemsList.add("010");
        planToAdd = new Plans("0800", "Deluxe", itemsList);
        PlanList.add(planToAdd);
        itemsList.clear();
        itemsList.add("004");
        itemsList.add("020");
        itemsList.add("026");
        itemsList.add("027");
        itemsList.add("024");
        itemsList.add("025");
        itemsList.add("016");
        itemsList.add("017");
        itemsList.add("018");
        itemsList.add("019");
        itemsList.add("008");
        itemsList.add("010");
        itemsList.add("014");
        itemsList.add("009");
        itemsList.add("012");
        itemsList.add("013");
        itemsList.add("011");
        itemsList.add("015");
        planToAdd = new Plans("0900", "All-In-One", itemsList);
        PlanList.add(planToAdd);
        count = PlanList.size();

        System.out.println("Opened " + dbType + " database " + dbName);
    }

    public void close() {
        System.out.println("Closed " + dbType + " database " + dbName);
    }
    public void print(){
        for(int i=0;i<ItemList.size();i++){
            System.out.println(i+"?"+ItemList.get(i).itemName+"?"+ItemList.get(i).itemID);
        }
    }

    public PizzaItem getItemByID(String ID){
        String itemName;
        int index = 0;
        PizzaItem returnItem = null;

        Items listItem = ItemList.get(index);
        while (index != ItemList.size()-1 && !ID.equals(listItem.itemID)) {
            index++;
            listItem = ItemList.get(index);
        }
        if(ID.equals(listItem.itemID)) {
            listItem.itemID = ID;
            returnItem = new PizzaItem(listItem.itemName,listItem.itemPrice);
        }
        return returnItem;
    }

    public ArrayList<PizzaPlan> getHistory() {
        ArrayList<PizzaPlan> historyPlanList = new ArrayList<>();
        ArrayList<PizzaItem> listPlanItems = new ArrayList<>();
        if(PlanList.size() > count) {
            int start = count - 1;
            int end = PlanList.size() -1;
            for(int i = start; i < end; i++){
                for(int j = 0; j < PlanList.get(i).listItemID.size() -1; j++){
                    PizzaItem addItem = getItemByID(PlanList.get(i).listItemID.get(j));
                    listPlanItems.add(addItem);
                }
                PizzaPlan nextPlan = new PizzaPlan("history",listPlanItems);
                historyPlanList.add(nextPlan);
            }
        }
        return  historyPlanList;
    }

    public String getItemID(String name){
        String itemID = "";
        for(int i = 0; i < ItemList.size(); i++){
            if(ItemList.get(i).itemName.equalsIgnoreCase(name)){
                itemID = ItemList.get(i).itemID;
            }
        }
        return itemID;
    }

    public String insertOrder(ArrayList<Integer> newOrder) {
        String orderName = "history";
        int insertAtID = getMaxPlanID() + 100;
        ArrayList<String> newOrderItems = new ArrayList<>();
        for(int i = 0; i < newOrder.size()-1; i++){
            newOrderItems.add(String.valueOf(newOrder.get(i)));
        }
        Plans theOrderPlan = new Plans(String.valueOf(insertAtID), orderName, newOrderItems);
        PlanList.add(theOrderPlan);
        return theOrderPlan.planName;
    }

    public String deletePlanByName(String name) {
        String itemID = "";
        for(int i = 0; i < ItemList.size(); i++){
            if(ItemList.get(i).itemName.equalsIgnoreCase(name)){
                itemID = ItemList.get(i).itemID;
                ItemList.remove(i);
            }
        }
        return itemID;
    }

    public int getMaxPlanID(){
        int maxPlanID = 0;
        for(int i = 0; i < PlanList.size(); i++){
            if(Integer.parseInt(PlanList.get(i).planID) > maxPlanID){
                maxPlanID = Integer.parseInt(PlanList.get(i).planID);
            }
        }
        return maxPlanID;
    }
}
