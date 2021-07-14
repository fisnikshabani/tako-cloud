package sia.takocloud.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sia.takocloud.domain.Order;
import sia.takocloud.repositories.OrderRepository;

@RestController
@RequestMapping(path = "/orders", produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderApiController {

    private OrderRepository orderRepository;

    public OrderApiController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Order> allOrders(){
        return orderRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Order postOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    /*@PatchMapping(path = "/{orderId}", consumes = "application/json")
    public Order patchOrder(@PathVariable("orderId") Long orderId, @RequestBody Order patch){

        Order order = orderRepository.findById(orderId).get();

        if (patch.get)

    }*/
}
