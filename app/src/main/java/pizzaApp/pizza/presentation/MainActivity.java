package pizzaApp.pizza.presentation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import pizzaApp.pizza.R;
import pizzaApp.pizza.application.Main;
import pizzaApp.pizza.object.PizzaItem;

public class MainActivity extends AppCompatActivity {
    private Button mainHistory;
    private Button mainOrder;
    private Button mainSpecials;
    static protected ArrayList<String> allOrders = new ArrayList<String>();
    // selections represents the customer's order
    // all classes in presentation can edit the order
    static protected ArrayList<String> order = new ArrayList<String>();
    static protected ArrayList<PizzaItem> pizzaPlanItems = new ArrayList<PizzaItem>();
    static protected ArrayList<String> ids = new ArrayList<String>();
    static protected String header;
    static protected String headerID;
    static protected boolean isCustom = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        copyDatabaseToDevice();
        Main.startUp();
        setContentView(R.layout.activity_main);

        mainOrder = (Button) findViewById(R.id.main_order);
        mainHistory = (Button) findViewById(R.id.main_history);
        mainSpecials = (Button) findViewById(R.id.main_specials);
        mainOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                isCustom = true;
                Intent intent = new Intent(MainActivity.this, SelectSizeActivity.class);
                startActivity(intent);
            }
        });

        mainHistory.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                isCustom = false;
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });

        mainSpecials.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                isCustom = false;
                Intent intent = new Intent(MainActivity.this, SpecialsActivity.class);
                startActivity(intent);
            }
        });
    }
    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.dbName);

        }
        catch (IOException ioe) {
            //Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];
            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }
}//MainActivity