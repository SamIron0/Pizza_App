package pizzaApp.pizza.presentation;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import pizzaApp.pizza.R;

public class SelectSizeActivity extends AppCompatActivity {
    private Button next;
    // selections represents the customer's order
    // all classes in presentation can edit the order
    //static protected Map<String, String> header = new HashMap<String, String>();
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button;
    private String size,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_size);

        ArrayList<String> selectedButtons = new ArrayList<String>();
        // get id of the radio group containing buttons for selection
        radioGroup = (RadioGroup) findViewById(R.id.selectionRadio);
        next = (Button) findViewById(R.id.sizeNext);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //get the id of the selected radio button
                int buttonID = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(buttonID);
                //add selected button to the arrayList of selected buttons
                switch((String)radioButton.getText()) {
                    case "Small (10\")": size = "Small"; id = "001"; break;
                    case "Medium (12\")": size = "Medium"; id = "002"; break;
                    case "Large (14\")": size = "Large"; id = "003"; break;
                }

                //add size as a header of pizza
                MainActivity.header = size;
                MainActivity.headerID = id;

                openSelectCrust();
            }
        });
    }//onCreate

    public void openSelectCrust() {
        Intent intent = new Intent(this, SelectCrustActivity.class);
        startActivity(intent);
    }//openSelectCrust
}//SelectSizeActivity