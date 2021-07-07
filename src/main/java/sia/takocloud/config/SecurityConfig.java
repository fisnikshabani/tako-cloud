package sia.takocloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // =================================================================//
        //using in-memory user store and creating two users
        auth.inMemoryAuthentication()

                .withUser("fisnik")
                .password(encoder().encode("password"))
                .authorities("ROLE_USER")

                .and()

                .withUser("root")
                .password(encoder().encode("root"))
                .authorities("ROLE_USER");
        // =================================================================//

        // =================================================================//
        // using JDBC-based user store
        /*auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from User " + "where username = ?")
                .authoritiesByUsernameQuery("select username, authority from UserAuthorities " + "where username = ?")
                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));*/
        // =================================================================//

        // =================================================================//
        // using LDAP-backed user store

        /*auth.ldapAuthentication()
                .userSearchBase("ou=people")      // a base query for finding users
                .userSearchFilter("(uid={0})")    // the search will be done from the root of the LDAP hierarchy!
                .groupSearchBase("ou=groups")     // base query for finding groups
                .groupSearchFilter("member={0}") // the search will be done from the root of the LDAP hierarchy!
                .passwordCompare()               //This involves sending the entered password to the LDAP directory and asking the server to compare the password against a user’s password attribute.
                .passwordEncoder(new BCryptPasswordEncoder())
                .passwordAttribute("passcode"); //If the password is kept in a different attribute, you can specify the password attribute’s name with passwordAttribute():
*/
        // By default, Spring Security’s LDAP authentication assumes that the LDAP server is listening on port 33389 on localhost. But if your LDAP server is on another machine,
        //you can use the contextSource() method to configure the location
         // auth.ldapAuthentication().contextSource().url("ldap://tacocloud.com:389/dc=tacocloud, dc=com");

        //If you don’t happen to have an LDAP server lying around waiting to be authenticated against, Spring Security can provide an embedded LDAP server for you.
        /* auth.ldapAuthentication().contextSource().root("dc=tacocloud, dc=com")*/

        //When the LDAP server starts, it will attempt to load data from any LDIF files that it  can find in the classpath. LDIF (LDAP Data Interchange Format) is a standard way of
        //representing LDAP data in a plain text file
         /*.ldif("classpath:users.ldif");*/
        // =================================================================//

        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new StandardPasswordEncoder("53cr3t");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/design", "/orders")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").permitAll()

                .and()

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design", true)

                .and()

                .logout()
                .logoutSuccessUrl("/")

                .and()

                .csrf()
                .ignoringAntMatchers("/h2-console/**")

                .and()

                .headers()
                .frameOptions()
                .sameOrigin();
    }
}
