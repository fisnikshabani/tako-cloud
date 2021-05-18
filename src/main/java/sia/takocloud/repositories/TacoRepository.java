package sia.takocloud.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sia.takocloud.domain.Taco;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
