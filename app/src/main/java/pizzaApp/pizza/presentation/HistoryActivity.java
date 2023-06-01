package pizzaApp.pizza.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pizzaApp.pizza.R;
import pizzaApp.pizza.business.Access;
import pizzaApp.pizza.business.CalculateCost;
import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.object.PizzaPlan;
import pizzaApp.pizza.persistence.DataAccess;
import pizzaApp.pizza.persistence.DataAccessObject;


public class HistoryActivity extends AppCompatActivity {

    private ArrayAdapter<PizzaPlan> planArrayAdapter;
    private ArrayList<PizzaPlan> pizzaPlanHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        displayHistory();
    }
    public void displayHistory(){
        Access dataAccess;
        dataAccess = new Access();
        pizzaPlanHistory = dataAccess.getHistory();
        pizzaPlanHistory = fixHistory(pizzaPlanHistory);
        ArrayList<PizzaItem> planItems = new ArrayList<>();
        planArrayAdapter = new ArrayAdapter<PizzaPlan>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, pizzaPlanHistory) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                PizzaPlan historyPlan = pizzaPlanHistory.get(position);
                text1.setText("Custom Pizza " + historyPlan.getID() +": ");
                text1.append(historyPlan.getItems().get(0).getName());
                for(int i = 1; i < historyPlan.getItems().size(); i++) {
                    text1.append(", ");
                    text1.append(historyPlan.getItems().get(i).getName());
                }
                text2.append(" Total: $" + CalculateCost.cost(historyPlan));
                return view;
            }
        };
        final ListView listView = (ListView)findViewById(R.id.historyList);
        listView.setAdapter(planArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectPlanAtPosition(position);
            }
        });
    }
    public void selectPlanAtPosition(int position){
        PizzaPlan selected = planArrayAdapter.getItem(position);
        MainActivity.header = selected.getItems().get(0).getName();
        MainActivity.headerID = selected.getItemIDs().get(0);
        for(int i = 1; i < selected.getItemIDs().size(); i++){
            MainActivity.ids.add(selected.getItemIDs().get(i));
            MainActivity.order.add(selected.getItems().get(i).getName());
        }
        Intent intent = new Intent(this, OrderSummaryActivity.class);
        startActivity(intent);
    }
    public ArrayList<PizzaPlan> fixHistory(ArrayList<PizzaPlan> history){
        ArrayList<PizzaPlan> oldHistory = new ArrayList<>();
        for(int i =0; i < history.size();i++){
           if(history.get(i).getID().equalsIgnoreCase("history")){
               oldHistory.add(history.get(i));
           }
        }
        return oldHistory;
    }
}

