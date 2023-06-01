package pizzaApp.pizza.object;

public class PizzaItem {
    private String name;

    private double price;

    public PizzaItem(String name) {
        this.name = name;
        price = 0.00;
    }

    public PizzaItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

}//PizzaItem
