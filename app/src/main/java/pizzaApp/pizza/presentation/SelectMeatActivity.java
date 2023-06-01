package pizzaApp.pizza.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import java.util.ArrayList;
import pizzaApp.pizza.R;

public class SelectMeatActivity extends AppCompatActivity {

    private Button next;
    private ArrayList<String> checkedBoxes = new ArrayList<String>();
    private ArrayList<String> id = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_meat);
        next = (Button) findViewById(R.id.meatNext);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSelectVeggies();
            }
        });
    }//onCreate

    public void openSelectVeggies() {
        hamClicked(findViewById(R.id.hamCheck));
        sausageClicked(findViewById(R.id.sausageCheck));
        chickenClicked(findViewById(R.id.chickenCheck));
        pepperoniClicked(findViewById(R.id.pepperoniCheck));

        if(!checkedBoxes.isEmpty()){
            MainActivity.order.addAll(checkedBoxes);
            MainActivity.ids.addAll(id);
        }

        Intent intent = new Intent(this, SelectVeggiesActivity.class);
        startActivity(intent);
    }//openVeggies

    private void hamClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("016");
        }
    }//hamclicked

    private void sausageClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("018");
        }
    }//sausageClicked

    private void chickenClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("017");
        }
    }//chickenClicked

    public void pepperoniClicked(View view) {
        CheckBox checkbox = (CheckBox) view;
        if (checkbox.isChecked()) {
            checkedBoxes.add((String) checkbox.getText());
            id.add("019");
        }
    }//pepperoniClicked
}//SelectMeatActivity