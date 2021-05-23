package sia.takocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import sia.takocloud.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
