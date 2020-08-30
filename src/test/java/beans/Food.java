package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




/***
 *Create a Bean class Food that has following fields:
 *  id, description, food_type, image_url,name,price
 *  Override and Implement equals() , hashcode(), compareTo() methods,
 *  that will help you to perform comparison and sorting operations.
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Food {

    public int id;
    public String description;
    public int food_type;
    public String image_url;
    public String name;
    public double price;


//private static final
}
