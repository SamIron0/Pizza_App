package pizzaApp.pizza.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import pizzaApp.pizza.R;


public class SelectSauceActivity extends AppCompatActivity {

    private Button next;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sauce);

        ArrayList<String> selectedButtons = new ArrayList<String>();
        radioGroup = (RadioGroup) findViewById(R.id.sauceSelectionRadio);
        next = (Button) findViewById(R.id.sauceNext);

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //get the id of the selected radio button
                int buttonID = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(buttonID);
                //add selected button to the arrayList of selected buttons,
                switch((String)radioButton.getText()) {
                    case "Classic Red Sauce": id = "020";break;
                    case "Alfredo Sauce": id = "021";break;
                    case "Basil Pesto Blend": id = "022";break;
                    case "Margherita Sauce": id = "023";break;
                }
                MainActivity.order.add((String)radioButton.getText());
                MainActivity.ids.add(id);
                System.out.println("Crust and Sauce ids: "+ MainActivity.ids);
                openSelectCheese();
            }
        });
    }//onCreate

    public void openSelectCheese() {
        Intent intent = new Intent(this, SelectCheeseActivity.class);
        startActivity(intent);
    }//openSelectCheese
}//SelectSauceActivity