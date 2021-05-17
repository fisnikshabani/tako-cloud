package sia.takocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.takocloud.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
