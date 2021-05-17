package sia.takocloud.repositories;


import org.springframework.data.repository.CrudRepository;
import sia.takocloud.domain.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
