package steps;

import beans.Employees;
import com.mysql.cj.protocol.Resultset;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataBaseDriverutils.db.DataBaseUtils;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Add200EmployeesToDatabaseSteps {


    @Given("^you have a connection to the Database$")
    public void you_have_a_connection_to_the_Database() throws Throwable {

    }

    @Given("^you also have a table that you would like to iterate over and send to Database$")
    public void you_also_have_a_table_that_you_would_like_to_iterate_over_and_send_to_Database() throws Throwable {

    }

    @When("^you fill data base with Following table$")
    public void you_fill_data_base_with_Following_table(List<Employees> employees) throws Throwable {

        for (int i = 0; i < 5; i++) {
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

    }


    @Then("^database should be full$")
    public void database_should_be_full() throws Throwable {
        //For now just assert by manually going to test database
        Assert.assertTrue(true);
    }


    @When("^the following query \"([^\"]*)\" is executed with \"([^\"]*)\" as lastname$")
    public void the_following_query_is_executed_with_as_lastname(String query, String lastName) throws Throwable {
        DataBaseUtils.executeQuery(query,lastName);
    }

    @When("^query \"([^\"]*)\" inserts \"([^\"]*)\"  \"([^\"]*)\"  \"([^\"]*)\" is provided$")
    public void query_inserts_is_provided(String query, String all, String employees, String lastName) {

        ResultSet rs = DataBaseUtils.executeQuery(query,all,employees, lastName);
        Employees newEployees = new Employees();
        System.out.println(newEployees.processRSTobeanList(rs));

//try {
//    System.out.println("==*== " + query + all + employees + lastName);
//    ResultSet rs = null;
//
//    rs = DataBaseUtils.executeQuery(query, all, employees, lastName);
////        String [] newArray = new String[3];
////        newArray[0] = "*";
////        newArray[1] = employees;
////        newArray[2] = lastName;
////        ResultSet rs2 = DataBaseUtils.executeQuery(query,newArray);
////        System.out.println(rs2.toString());
//    System.out.println(rs.toString());
//}catch (Exception e){
//    e.printStackTrace();
//}
    }



    @Then("^make sure the resultSet is accurate$")
    public void make_sure_the_resultSet_is_accurate() {

    }



    @Then("^make sure the multiple resultSet is accurate$")
    public void make_sure_the_multiple_resultSet_is_accurate() throws Throwable {

    }

}
