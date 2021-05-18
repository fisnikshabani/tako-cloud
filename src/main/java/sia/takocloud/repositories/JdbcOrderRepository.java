package sia.takocloud.repositories;

import org.springframework.stereotype.Repository;
import sia.takocloud.domain.Order;
import sia.takocloud.domain.Taco;

import java.sql.Date;
import java.util.*;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    @Override
    public <S extends Order> S save(S s) {
        return null;
    }

    @Override
    public <S extends Order> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Order> findAll() {
        return null;
    }

    @Override
    public Iterable<Order> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Order order) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
