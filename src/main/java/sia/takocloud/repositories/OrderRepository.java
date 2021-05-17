package sia.takocloud.repositories;

import sia.takocloud.domain.Order;

public interface OrderRepository {

    Order save(Order order);
}
