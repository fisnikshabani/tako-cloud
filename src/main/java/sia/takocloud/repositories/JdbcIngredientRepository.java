package sia.takocloud.repositories;


import org.springframework.stereotype.Repository;
import sia.takocloud.domain.Ingredient;
import java.util.Optional;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    @Override
    public <S extends Ingredient> S save(S s) {
        return null;
    }

    @Override
    public <S extends Ingredient> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Ingredient> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return null;
    }

    @Override
    public Iterable<Ingredient> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Ingredient ingredient) {

    }

    @Override
    public void deleteAll(Iterable<? extends Ingredient> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
