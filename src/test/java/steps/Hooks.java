package steps;


import org.junit.After;
import org.junit.Before;
import dataBaseDriverutils.db.DataBaseUtils;

import java.sql.SQLException;

public class Hooks {

    //Implement DB Connection Steps here
    @Before
    public void openConnection() throws SQLException {
        DataBaseUtils.open("food_delivery_db1");
    }


    @After
    public void closeConnection() {
        DataBaseUtils.close();
    }
}


