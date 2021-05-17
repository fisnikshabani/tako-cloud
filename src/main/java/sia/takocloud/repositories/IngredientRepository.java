package sia.takocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.takocloud.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
