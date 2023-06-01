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

public class SelectCrustActivity extends AppCompatActivity {

    private Button next;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String crust,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_crust);

        ArrayList<String> selectedButtons = new ArrayList<String>();
        radioGroup = (RadioGroup) findViewById(R.id.selectCrustRadio);
        next = (Button) findViewById(R.id.crustNext);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //get the id of the selected radio button
                int buttonID = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(buttonID);
                // add selected button to the arrayList of selected buttons,
                switch((String)radioButton.getText()){
                    case "White": crust = "White"; id = "004"; break;
                    case "Whole Wheat": crust = "Whole Wheat"; id = "005"; break;
                    case "Gluten-Free (+$3)": crust = "Gluten-Free"; id = "007"; break;
                    case "Keto Cauliflower (+$5)": crust = "Keto"; id = "006"; break;
                }

                MainActivity.order.add(crust);
                MainActivity.ids.add(id);

                openSelectSauce();
            }
        });
    }//onCreate

    public void openSelectSauce() {
        Intent intent = new Intent(this, SelectSauceActivity.class);
        startActivity(intent);
    }//openSelectSauce
}//SelectCrustACtivity