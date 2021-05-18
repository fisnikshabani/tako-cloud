package sia.takocloud.repositories;


import org.springframework.stereotype.Repository;
import sia.takocloud.domain.Taco;
import java.util.Optional;

@Repository
public class JdbcTacoRepository implements TacoRepository{


    @Override
    public <S extends Taco> S save(S s) {
        return null;
    }

    @Override
    public <S extends Taco> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Taco> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Taco> findAll() {
        return null;
    }

    @Override
    public Iterable<Taco> findAllById(Iterable<Long> iterable) {
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
    public void delete(Taco taco) {

    }

    @Override
    public void deleteAll(Iterable<? extends Taco> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
