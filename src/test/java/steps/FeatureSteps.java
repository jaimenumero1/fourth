package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeatureSteps {

    @Given("^remove all records from a \"([^\"]*)\" table$")
    public void remove_all_records_from_a_table(String arg1) throws Throwable {

    }

    @When("^Add new data in the cart_items tables$")
    public void add_new_data_in_the_cart_items_tables(DataTable arg1) throws Throwable {

    }

    @Then("^verify that the cart item table has the following data$")
    public void verify_that_the_cart_item_table_has_the_following_data(DataTable arg1) throws Throwable {

    }

    @When("^Add new data in the food tables$")
    public void add_new_data_in_the_food_tables(DataTable arg1) throws Throwable {

    }

    @Then("^verify that food table has the following food data$")
    public void verify_that_food_table_has_the_following_food_data(DataTable arg1) throws Throwable {

    }

    @Given("^Add new data in the food tables$")
    public void add_new_data_in_the_food_tables(DataTable arg1) {

    }

    @When("^update price to \"([^\"]*)\" in food table for food id \"([^\"]*)\"$")
    public void update_price_to_in_food_table_for_food_id(String arg1, String arg2) throws Throwable {

    }

    @When("^remove food record with food id \"([^\"]*)\"$")
    public void remove_food_record_with_food_id(String arg1) throws Throwable {

    }

    @When("^Add new data in the orders tables$")
    public void add_new_data_in_the_orders_tables(DataTable arg1){

    }

    @Then("^verify that orders table has the following orders$")
    public void verify_that_orders_table_has_the_following_orders(DataTable arg1) {

    }

    @Given("^Add new data in the orders tables$")
    public void add_new_data_in_the_orders_tables(DataTable arg1) {

    }

    @When("^update order status to \"([^\"]*)\" in food table of order id \"([^\"]*)\"$")
    public void update_order_status_to_in_food_table_of_order_id(String arg1, String arg2) throws Throwable {

    }

    @Given("^verify that orders table has the following orders$")
    public void verify_that_orders_table_has_the_following_orders(DataTable arg1) {

    }

    @When("^remove order's records that was placed after \"([^\"]*)\"$")
    public void remove_order_s_records_that_was_placed_after(String arg1) throws Throwable {

    }

}
