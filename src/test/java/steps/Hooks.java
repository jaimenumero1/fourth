package steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import dataBaseDriverutils.db.DataBaseUtils;

import java.sql.SQLException;

public class Hooks {

    //Implement DB Connection Steps here
    @Before
    public void openConnection() throws SQLException {
        DataBaseUtils.openTestDataBase();
    }


    @After
    public void closeConnection() {
        DataBaseUtils.close();
    }
}


