package sia.takocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.takocloud.domain.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
