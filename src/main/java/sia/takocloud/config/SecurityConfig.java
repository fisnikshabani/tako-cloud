package sia.takocloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import sia.takocloud.services.UserDetailsService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //in-memory user store
    /*@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                    .withUser("buzz")
                    .password("{noop}password")
                    .authorities("ROLE_USER")
                .and()
                    .withUser("foo")
                    .password("{noop}password")
                    .authorities("ROLE_USER");
    }*/

    //authenticating against a JDBC-based user store
    @Autowired
    DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    public PasswordEncoder encoder(){
        return new StandardPasswordEncoder("53cr3t");
    }

    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }


}
