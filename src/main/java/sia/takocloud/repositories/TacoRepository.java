package sia.takocloud.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sia.takocloud.domain.Taco;

@Repository
public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {
}
