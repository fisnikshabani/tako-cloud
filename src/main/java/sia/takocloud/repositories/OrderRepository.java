package sia.takocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.takocloud.domain.Order;

import java.sql.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {



}
