package pizzaApp.pizza.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import java.util.ArrayList;
import pizzaApp.pizza.R;

public class SelectCheeseActivity extends AppCompatActivity {

    private Button next;
    private ArrayList<String> checkedBoxes = new ArrayList<String>();
    private ArrayList<String> id = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cheese);
        next = (Button) findViewById(R.id.cheeseNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openSelectMeat();
            }
        });
    }//onCreate

    public void openSelectMeat() {
        mozzarellaClicked(findViewById(R.id.mozzarellaCheck));
        cheddarClicked(findViewById(R.id.cheddarCheck));
        fetaClicked(findViewById(R.id.fetaCheck));
        parmesanClicked(findViewById(R.id.parmesanCheck));

        MainActivity.order.addAll(checkedBoxes);
        MainActivity.ids.addAll(id);

        Intent intent = new Intent(this, SelectMeatActivity.class);
        startActivity(intent);
    }//openSelectMeat

    private void mozzarellaClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add("Mozzarella");
            id.add("026");
        }
    }

    private void cheddarClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add("Cheddar");
            id.add("027");
        }
    }

    private void fetaClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()) {
            checkedBoxes.add("Feta");
            id.add("025");
        }
    }

    public void parmesanClicked(View view) {
        CheckBox checkbox = (CheckBox) view;
        if (checkbox.isChecked()) {
            checkedBoxes.add("Parmesan");
            id.add("024");
        }
    }
}//SelectCheeseActivity