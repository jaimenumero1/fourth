package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/***
 *Create a Bean class CartItems that has following fields:
 *  id, quantity, total_price, food_id
 *  Override and Implement equals() , hashcode(), compareTo() methods,
 *  that will help you to perform comparison and sorting operations.
 */

@NoArgsConstructor
@Data
@AllArgsConstructor

public class CartItems {
//no access to Database
    public int id;
    public int quantity;
    public double total_price;
    public int food_id;
    public static final String[] columns = {"id", "quantity", "total_price", "food_id"};

    public CartItems(double id, double quantity,double total_price, double food_id){
        this.id = (int)id;
        this.quantity = (int)quantity;
        this.total_price = total_price;
        this. food_id = (int) food_id;

    }


}
