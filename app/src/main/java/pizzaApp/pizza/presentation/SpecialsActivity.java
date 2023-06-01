package pizzaApp.pizza.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.Arrays;
import pizzaApp.pizza.R;

public class SpecialsActivity extends AppCompatActivity {
    private Button next;
    //Radio Groups
    private RadioGroup sizeRg;
    private RadioGroup specialsRg;
    // Radio Buttons
    private RadioButton sizeRb;
    private RadioButton specialsRb;

    private String[] orderItems;
    private String[] ids;
    private String size,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specials);

        // get id of the radio group containing buttons for selection
        sizeRg = (RadioGroup) findViewById(R.id.sizeGroup);
        specialsRg = (RadioGroup) findViewById(R.id.specialsGroup);

        next = (Button) findViewById(R.id.specialsNext);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int sizeID = sizeRg.getCheckedRadioButtonId();
                int specialsID = specialsRg.getCheckedRadioButtonId();
                sizeRb = (RadioButton) findViewById(sizeID);
                specialsRb = (RadioButton) findViewById(specialsID);

                switch((String)sizeRb.getText()) {
                    case "Small (10\")": size = "Small"; id = "001"; break;
                    case "Medium (12\")": size = "Medium"; id = "002"; break;
                    case "Large (14\")": size = "Large"; id = "003"; break;
                }
                MainActivity.header = size;
                MainActivity.headerID = id;

                if(specialsRb.getText().equals("Veggie Lovers")) {
                    orderItems = new String[]{"Whole Wheat", "Classic Red Sauce", "Cheddar", "Mushrooms", "Tomatoes", "Red Onions", "Jalapenos"};
                    ids = new String[]{"005","020","027","014","013","011"};
                }
                else if(specialsRb.getText().equals("Meat Lovers")) {
                    orderItems = new String[]{"White", "Classic Red Sauce", "Cheddar", "Ham", "Italian Sausage", "Chicken", "Pepperoni"};
                    ids = new String[]{"004","020","027","016","017","018","019"};
                }
                else if(specialsRb.getText().equals("Cheesey Supreme")) {
                    orderItems = new String[]{"Whole Wheat", "Classic Red Sauce", "Mozzarella", "Cheddar", "Feta", "Parmesan"};
                    ids = new String[]{"004","020","027"};
                }
                else if(specialsRb.getText().equals("Margherita")) {
                    orderItems = new String[]{"Whole Wheat", "Margherita Sauce", "Mozzarella", "Basil"};
                    ids = new String[]{"005","020","026","009"};
                }
                else if(specialsRb.getText().equals("Classic Pepperoni")) {
                    orderItems = new String[]{"White", "Classic Red Sauce", "Cheddar", "Mozzarella", "Pepperoni"};
                    ids = new String[]{"004","020","026","027","019"};
                }
                else if(specialsRb.getText().equals("Chicken Alfredo")) {
                    orderItems = new String[]{"Whole Wheat", "Alfredo Sauce", "Parmesan", "Chicken"};
                    ids = new String[]{"005","017","021","024"};
                }
                else if(specialsRb.getText().equals("Deluxe")) {
                    orderItems = new String[]{"White", "Classic Red Sauce", "Cheddar", "Mozzarella", "Pepperoni", "Green Pepper", "Mushrooms", "Olives"};
                    ids = new String[]{"004","020","026","027","019","015","008","010"};
                }
                else if(specialsRb.getText().equals("All-In-One")) {
                    orderItems = new String[]{"White", "Classic Red Sauce", "Cheddar", "Mozzarella", "Parmesan", "Feta", "Ham", "Italian Sausage", "Chicken", "Pepperoni", "Mushrooms", "Tomatoes", "Olives", "Red Onion", "White Onions", "Basil", "Jalapenos", "Green Pepper"};
                    ids = new String[]{"004","020","026","027","024","025","009","010","011","012","013","014","015","016","017","018","019"};
                }

                MainActivity.order.addAll(Arrays.asList(orderItems));
                MainActivity.ids.addAll(Arrays.asList(ids));
                openSelectCrust();

            }
        });
    }

    public void openSelectCrust() {
        Intent intent = new Intent(SpecialsActivity.this, OrderSummaryActivity.class);
        startActivity(intent);
    }//openSelectCrust
}//OrderTypeActivity

