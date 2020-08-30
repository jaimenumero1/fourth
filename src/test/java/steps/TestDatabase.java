package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataBaseDriverutils.db.DataBaseUtils;
import dataBaseDriverutils.db.ResultSetHandler;
import gherkin.lexer.Th;
import org.junit.Assert;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDatabase {



    @Given("^a connection to a database is started$")
    public void a_connection_to_a_database_is_started() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        DataBaseUtils.openTestDataBase();

    }

    @When("^you remove all records from a \"([^\"]*)\" table$")
    public void you_remove_all_records_from_a_table(String table) throws Throwable {

        DataBaseUtils.truncate(table);
       Assert.assertTrue(DataBaseUtils.connection != null);
       String query = "SELECT * FROM employees";
      ResultSet rs = DataBaseUtils.executeQuery(query);

        List<Map<String, Object>> fullList= ResultSetHandler.rsToList(rs);
        List<Map<String, Object>> empty = new ArrayList<>();
        System.out.println(" \n This is the List that was returned from the Result set of the Query (SELECT * FROM employees)"
                + " \n after it was TRUNCATED " + fullList);
        Assert.assertEquals("Records from table may not have been Truncated(erased)",empty.size(),fullList.size());

    }

    @Then("^employees table should be empty$")
    public void employees_table_should_be_empty() throws Throwable {
        Assert.assertTrue(true);

    }



}
