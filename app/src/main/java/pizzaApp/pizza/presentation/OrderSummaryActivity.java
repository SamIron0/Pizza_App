package pizzaApp.pizza.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import pizzaApp.pizza.R;
import pizzaApp.pizza.business.Access;
import pizzaApp.pizza.business.CalculateCost;
import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.object.PizzaPlan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;


public class OrderSummaryActivity extends AppCompatActivity {
    private Button cancelOrder;
    private Button placeOrder;
    private ArrayList<Integer> pizzaItemIDs = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        // display orders items
        printOrder(MainActivity.order);

        //display the final price of all items
        displayTotal();

        //clean order list for continue shopping
        MainActivity.order.clear();
        MainActivity.ids.clear();
        MainActivity.header = "";
        MainActivity.headerID = "";

        cancelOrder = (Button) findViewById(R.id.cancelOrder);
        cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
        placeOrder = (Button)findViewById(R.id.placeOrder);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrderPlacedActivity();
                if(MainActivity.isCustom) {
                    Access dataAccess = new Access();
                    String result = dataAccess.insertOrder(pizzaItemIDs);
                }
            }
        });
    }

    public void printOrder(ArrayList<String>order) {
        String header = MainActivity.header + " Pizza- ";
        TextView tv = (TextView) findViewById(R.id.orderDisplay);
        tv.setText(header);
        for (String orderItem:order) {
            tv.append(orderItem);
                if (order.indexOf(orderItem) == (order.size() - 1))
                    tv.append(".");
                else
                    tv.append(", ");
            }
    }// printOrder

    public void displayTotal() {
        Access dataAccess = new Access();
        // arraylist to hold all component of pizza for database access
        ArrayList<PizzaItem> pizzaItems = new ArrayList<PizzaItem>();
        //add the header the arraylist of all items
        pizzaItems.add(dataAccess.getPizzaItem(MainActivity.headerID));
        pizzaItemIDs.add(Integer.parseInt(MainActivity.headerID));
        for (String id : MainActivity.ids) {
            System.out.println("Item ids: " + MainActivity.ids);
            pizzaItemIDs.add(Integer.parseInt(id));
            pizzaItems.add(dataAccess.getPizzaItem(id));
        }

        PizzaPlan finalPlan = new PizzaPlan("finalPlan", pizzaItems);
        TextView textV = (TextView) findViewById(R.id.orderTotal);
        textV.setText("Total: $"+ CalculateCost.cost(finalPlan));
    }// displayTotal//

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }// openMainActivity

    public void openOrderPlacedActivity() {
        Intent intent = new Intent(this, OrderPlacedActivity.class);
        startActivity(intent);

    }// openOrderPlacedActivity
}