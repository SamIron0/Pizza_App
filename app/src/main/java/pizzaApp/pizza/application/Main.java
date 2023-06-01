package pizzaApp.pizza.application;

public class Main {
    public static final String dbName = "PizzaData";
    public static final String stubName = "PizzaData";

    private static String dbPathName = "database/PizzaData";

    public static void main(String[] args) {
        startUp();
        shutDown();
        System.out.println("All done");
    }

    public static void startUp()
    {
        Services.createDataAccess(dbName);
    }

    public static void shutDown()
    {
        Services.closeDataAccess();
    }

    public static String getDBPathName() {
        if (dbPathName == null)
            return dbName;
        else
            return dbPathName;
    }

    public static void setDBPathName(String pathName) {
        System.out.println("Setting DB path to: " + pathName);
        dbPathName = pathName;
    }
}
