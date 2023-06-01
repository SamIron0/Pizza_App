package pizzaApp.pizza.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import java.util.ArrayList;
import pizzaApp.pizza.R;

public class SelectVeggiesActivity extends AppCompatActivity {
    private Button next;
    private ArrayList<String> checkedBoxes = new ArrayList<String>();
    private ArrayList<String> id = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_veggies);
        next = (Button) findViewById(R.id.veggiesNext);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openOrderSummary();
            }
        });
    }//onCreate

    public void openOrderSummary() {
        mushroomsClicked(findViewById(R.id.mushroomsCheck));
        tomatoesClicked(findViewById(R.id.tomatoCheck));
        olivesClicked(findViewById(R.id.olivesCheck));
        jalapenosClicked(findViewById(R.id.jalapenosCheck));
        greenPeppersClicked(findViewById(R.id.greenPepperCheck));
        redOnionsClicked(findViewById(R.id.redOnionCheck));
        whiteOnionsClicked(findViewById(R.id.whiteOnionCheck));
        basilClicked(findViewById(R.id.basilCheck));

        if(!checkedBoxes.isEmpty()) {
            MainActivity.order.addAll(checkedBoxes);
            MainActivity.ids.addAll(id);
        }
        Intent intent = new Intent(this, OrderSummaryActivity.class);
        startActivity(intent);
    }//openOrderSummary

    private void basilClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("009");
        }
    }

    private void whiteOnionsClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("012");
        }
    }

    private void redOnionsClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("013");
        }
    }

    private void greenPeppersClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("015");
        }
    }

    private void mushroomsClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("008");
        }
    }

    private void tomatoesClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("014");
        }
    }

    private void olivesClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("010");
        }
    }

    public void jalapenosClicked(View view) {
        CheckBox checkbox = (CheckBox) view;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("011");
        }
    }
}//SelectVeggiesActivity