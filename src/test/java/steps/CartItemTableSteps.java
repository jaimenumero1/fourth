package steps;

import beans.CartItems;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataBaseDriverutils.db.DataBaseUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CartItemTableSteps<T> {

    @Given("^remove all records from a \"([^\"]*)\" table$")
    public void remove_all_records_from_a_table(String table) throws SQLException {
        DataBaseUtils.open();
//        try{
//            DataBaseUtils.open();
//        }catch (SQLException e){
//            Assert.fail(e.getMessage());
//        }
//        DataBaseUtils.truncate(table);
        DataBaseUtils.close();
    }

    @When("^Add new data in the cart_items tables$")
    public void add_new_data_in_the_cart_items_tables(List<Map<String, Double>> listCartItems) throws SQLException {

        DataBaseUtils.open();
        CartItems cartItems1 = new CartItems();
        System.out.println(Arrays.toString(cartItems1.columns));

        String query = "INSERT INTO cart_item VALUES(?, ?, ?, ?);";
        CartItems cartItems2 = new CartItems(listCartItems.get(0).get("id"), listCartItems.get(0).get("quantity"),
                listCartItems.get(0).get("total_price"), listCartItems.get(0).get("food_id"));
        boolean isInsertTrue = DataBaseUtils.executeInsert(query, cartItems2, cartItems1.columns);
        System.out.println(isInsertTrue);
        DataBaseUtils.close();
    }

    @Then("^verify that the cart item table has the following data$")
    public void verify_that_the_cart_item_table_has_the_following_data(DataTable arg1) {

    }
}
