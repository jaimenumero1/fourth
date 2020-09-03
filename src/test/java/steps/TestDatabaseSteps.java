package steps;

import beans.Employees;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataBaseDriverutils.db.DataBaseUtils;
import dataBaseDriverutils.db.ResultSetHandler;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestDatabaseSteps {


    @Given("^a connection to a database is started$")
    public void a_connection_to_a_database_is_started() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        DataBaseUtils.openTestDataBase();

    }

    @When("^you remove all records from a \"([^\"]*)\" table$")
    public void you_remove_all_records_from_a_table(String table) throws Throwable {

        DataBaseUtils.truncate(table);
        Assert.assertTrue(DataBaseUtils.connection != null);


    }

    @Then("^employees table should be empty$")
    public void employees_table_should_be_empty() throws Throwable {
        Assert.assertTrue(true);
        String query = "SELECT * FROM employees";
        ResultSet rs = DataBaseUtils.executeQuery(query);

        List<Map<String, Object>> fullList = ResultSetHandler.rsToListOfMaps(rs);
        List<Map<String, Object>> empty = new ArrayList<>();
        System.out.println(" \n This is the List that was returned from the Result set of the Query (SELECT * FROM employees)"
                + " \n after it was TRUNCATED " + fullList);
        Assert.assertEquals("Records from table may not have been Truncated(erased)", empty.size(), fullList.size());

    }

    @When("^you add records from the table below$")
    public void you_add_records_from_the_table_below(List<Employees> employees) throws SQLException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        String query = "INSERT INTO employees VALUES(?,?,?,?,?,?,?,?);";
        boolean isInserted;
        for (Employees employeesObject : employees) {
            isInserted = DataBaseUtils.executeInsert(query, employeesObject, Employees.properties_ColumnsNames);

            System.out.println("Object Here Lets see it " + employeesObject);

            System.out.println(" " + employeesObject.getEmployeeNumber() + " this is there first name and email -->>  \t" +
                    employeesObject.getFirstName() + " " + employeesObject.getEmail());
            System.out.println();
            System.out.println();
            System.out.println(isInserted);
            Assert.assertFalse(isInserted);
        }


    }

    @Then("^verify that the database has the following information$")
    public void verify_that_the_database_has_the_following_information(List<Employees> employees) {
        ResultSet allEmployees = Employees.getAllFromDataBaseEmployeesTable();
        System.out.println("====================" + allEmployees);
        List<Employees> databaseEmployeeList = new ArrayList<>();
        Employees emp1 = new Employees();
        databaseEmployeeList = emp1.processRSTobeanList(allEmployees);
        for(int i = 0;i < databaseEmployeeList.size();i++){
            System.out.println("*********************** " + databaseEmployeeList.get(i));
            System.out.println("*********************** " + employees.get(i));
        }
        //System.out.println("*****" + databaseEmployeeList);
        //System.out.println("*****" + employees);
        Assert.assertTrue(employees.containsAll(databaseEmployeeList));
    }


    @When("^employee <\"([^\"]*)\"> and <\"([^\"]*)\"> changes email, change to new <\"([^\"]*)\">$")
    public void employee_and_changes_email_change_to_new(String tableFirstName, String tableLastName, String newEmail) {
        DataBaseUtils.executeUpdate();

    }

    @Then("^database should match new Updated <\"([^\"]*)\">$")
    public void database_should_match_new_Updated(String arg1) throws Throwable {


    }


    @When("^employee ([^\"]*) and ([^\"]*) changes email, change to new ([^\"]*)$")
    public void employeeFirstNameAndLastNameChangesEmailChangeToNew(String tableFirstName, String tableLastName, String newEmail) {
        System.out.println(tableFirstName + tableLastName + newEmail);
        String query = "UPDATE employees\n SET email = '" + newEmail + "'" + "\n WHERE firstName = " + "'" + tableFirstName + "';";
        System.out.println(query);
        try {
            DataBaseUtils.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Then("^database should match new Updated ([^\"]*)$")
    public void databaseShouldMatchNewUpdatedEmail(String newEmail) {
        System.out.println(newEmail);


    }


}
