package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author Mubeen
 * @apiNote API to handle orders.
 * @version 1.0
 */



@RestController
public class OrderController {

    private List<Order> OrderQueue = new LinkedList<Order>();
    private ObjectMapper mapper = new ObjectMapper();



    @RequestMapping("/postOrder")
    boolean postOrder(@RequestParam(value="orderNumber", defaultValue = "") String on,
                      @RequestParam(value="customerName", defaultValue = "") String cn,
                      @RequestParam(value =  "address", defaultValue = "") String addrs,
                      @RequestParam(value = "item", defaultValue = " ") String i)
    {
        if(on == "" || cn == "" || addrs == "" || i == "" ) {
            return false;
        }
        Order o = new Order(on, cn, addrs, i);
        OrderQueue.add(o);
        return true;
    }

    @RequestMapping
    String getOrder() throws JsonProcessingException {
        if(OrderQueue.isEmpty()) return "No Order";
        Order temp = OrderQueue.get(0);
        OrderQueue.remove(0);

        String stringedObj = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(temp);
        System.out.println(stringedObj);

        return stringedObj;
    }

}
