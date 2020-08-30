package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/***
 *Create a Bean class Orders that has following fields:
 *  id, order_placed_at, order_status, order_updated_at,custom_user_id
 *  Override and Implement equals() , hashcode(), compareTo() methods,
 *  that will help you to perform comparison and sorting operations.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders  {

    int id;
    LocalDateTime order_placed_at;
    int order_status;
    LocalDateTime order_updated_at;
    int custom_user_id;
}
