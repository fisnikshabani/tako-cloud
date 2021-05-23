package sia.takocloud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sia.takocloud.domain.User;
import sia.takocloud.repositories.UserRepository;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService{

    private UserRepository userRepository;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user != null){
            return user;
        }
        throw new UsernameNotFoundException("User " + username + " not found");
    }
}
