package pizzaApp.pizza.tests.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pizzaApp.pizza.application.Main;
import pizzaApp.pizza.application.Services;
import pizzaApp.pizza.persistence.DataAccess;
import pizzaApp.pizza.tests.persistence.DataAccessTest;

public class DataAccessHSQLDBTest {
	private static String dbName = Main.dbName;
	private DataAccess dataAccess;

	@Before
	public void setUp(){
		Services.closeDataAccess();

		System.out.println("\nStarting Integration test DataAccess (using default DB)");
		Services.createDataAccess(dbName);
		dataAccess = Services.getDataAccess(dbName);
	}

	@Test
	public void testDataAccess() {
		DataAccessTest.dataAccessTest(dataAccess);
	}

	@After
	public void breakDown() {
		Services.closeDataAccess();
		System.out.println("Finished Integration test DataAccess (using default DB)");
	}
}