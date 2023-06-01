package pizzaApp.pizza.persistence;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

import pizzaApp.pizza.object.PizzaItem;
import pizzaApp.pizza.object.PizzaPlan;

public class DataAccessObject implements DataAccess {
    private Statement st1, st2;
    private Connection c1;
    private ResultSet rs2, rs3;

    private String dbName;
    private String dbType;

    private String cmdString;
    private int updateCount;
    private String result;
    private static String EOF = "  ";

    public DataAccessObject(String dbName)
    {
        this.dbName = dbName;
    }

    public void open(String dbPath) {
        String url;
        try {
            // Setup for HSQL
            dbType = "HSQL";
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
            url = "jdbc:hsqldb:file:" + dbPath; // stored on disk mode
            c1 = DriverManager.getConnection(url, "SA", "");
            st1 = c1.createStatement();
            st2 = c1.createStatement();


        }
        catch (Exception e) {
            processSQLError(e);
        }
        System.out.println("Opened " +dbType +" database " +dbPath);
    }

    public void close() {
        try {	// commit all changes to the database
            cmdString = "shutdown compact";
            rs2 = st1.executeQuery(cmdString);
            c1.close();
        }
        catch (Exception e) {
            processSQLError(e);
        }
        System.out.println("Closed " +dbType +" database " +dbName);
    }

    public PizzaItem getItemByID(String ID) {
        PizzaItem resultItem = null;
        String pizzaItemName="";
        double pizzaItemPrice = 0.00;
        try {
            cmdString = "Select * from ITEMS where ITEMID = " + ID;
            rs2 = st2.executeQuery(cmdString);
        }
        catch (Exception e) {
            processSQLError(e);
        }
        try {
            while (rs2.next()) {
                pizzaItemName = rs2.getString(rs2.getMetaData().getColumnName(2));
                pizzaItemPrice = rs2.getDouble(rs2.getMetaData().getColumnName(3));
                resultItem = new PizzaItem(pizzaItemName, pizzaItemPrice);
            }
            rs2.close();
        }
        catch (Exception e) {
            result = processSQLError(e);
        }
        return resultItem;
    }

    public ArrayList<PizzaPlan> getHistory() {
        ArrayList<PizzaPlan> resultPlanList = new ArrayList<PizzaPlan>();
        PizzaPlan resultPlan = null;
        ArrayList<PizzaItem> planItemList = new ArrayList<PizzaItem>();
        ArrayList<String> planItemIDList = new ArrayList<>();
        PizzaItem resultItem = null;
        String pizzaPlanName = EOF;
        int planIDNext = 200;
        int pizzaPlanID = 100;
        String previousPlanName = EOF;
        try {
            cmdString = "Select * from PLANS";
            rs3 = st2.executeQuery(cmdString);
        }
        catch (Exception e) {
            processSQLError(e);
        }
        try {
            while (rs3.next()) {
                pizzaPlanName = rs3.getString(rs3.getMetaData().getColumnLabel(2));
                pizzaPlanID = rs3.getInt(rs3.getMetaData().getColumnLabel(1));
                if( pizzaPlanID == planIDNext) {
                    resultPlan = new PizzaPlan(previousPlanName,planItemList,planItemIDList);
                    resultPlanList.add(resultPlan);
                    planItemList = new ArrayList<>();
                    planItemIDList = new ArrayList<>();
                    planIDNext = planIDNext + 100;
                }
                resultItem = getItemByID(rs3.getString(rs3.getMetaData().getColumnLabel(3)));
                planItemList.add(resultItem);
                planItemIDList.add(rs3.getString(rs3.getMetaData().getColumnLabel(3)));
                previousPlanName = pizzaPlanName;
            }
            resultPlan = new PizzaPlan(previousPlanName,planItemList,planItemIDList);
            resultPlanList.add(resultPlan);
            rs3.close();
        }
        catch (Exception e) {
            result = processSQLError(e);
        }
        return resultPlanList;
    }

    public String getItemID(String name){
        String resultID = null;
        try {
            cmdString = "Select ITEMID from ITEMS where NAME = \"" + name + "\"";
            rs2 = st2.executeQuery(cmdString);
        }
        catch (Exception e) {
            processSQLError(e);
        }
        try {
            resultID = rs2.getString(rs2.getMetaData().getColumnLabel(1));
            rs2.close();
        }
        catch (Exception e) {
            result = processSQLError(e);
        }
        return resultID;
    }

    public String insertOrder(ArrayList<Integer> newOrder) {
        int newOrderID = getMaxPlanID() + 100;
        String values = "";

        result = null;
        int i = 0;
        try {
            while( i < newOrder.size()) {

                values = newOrderID
                        + ", 'History', "
                        + newOrder.get(i);
                cmdString = "Insert into PLANS " + " Values(" + values + ")";
                updateCount = st1.executeUpdate(cmdString);
                result = checkWarning(st1, updateCount);
                i++;
            }
            newOrderID = newOrderID + 100;
        }
        catch (Exception e) {
            result = processSQLError(e);
        }
        return result;
    }

    public String deletePlanByName(String name)
    {
        String values;

        result = null;
        try
        {
            values = name;
            cmdString = "Delete from PLANS where PLANNAME='" +values +"'";
            //System.out.println(cmdString);
            updateCount = st1.executeUpdate(cmdString);
            result = checkWarning(st1, updateCount);
        }
        catch (Exception e)
        {
            result = processSQLError(e);
        }
        return result;
    }

    public int getMaxPlanID(){
        int resultID = 0;
        int maxID = 0;
        try {
            cmdString = "Select * from PLANS";
            rs2 = st2.executeQuery(cmdString);
        }
        catch (Exception e) {
            processSQLError(e);
        }
        try {
            while (rs2.next()) {
                resultID = rs2.getInt(rs2.getMetaData().getColumnName(1));
                if(resultID > maxID) {
                    maxID = resultID;
                    }
                }
            rs2.close();
        }
        catch (Exception e) {
            result = processSQLError(e);
        }
        return maxID;
    }

    public String checkWarning(Statement st, int updateCount) {
        String result;

        result = null;
        try {
            SQLWarning warning = st.getWarnings();
            if (warning != null) {
                result = warning.getMessage();
            }
        }
        catch (Exception e) {
            result = processSQLError(e);
        }
        if (updateCount != 1) {
            result = "Tuple not inserted correctly.";
        }
        return result;
    }

    public String processSQLError(Exception e) {
        String result = "*** SQL Error: " + e.getMessage();

        e.printStackTrace();

        return result;
    }
}
