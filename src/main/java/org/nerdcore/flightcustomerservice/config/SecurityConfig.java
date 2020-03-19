package org.nerdcore.flightcustomerservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.jdbcAuthentication()
                .dataSource(this.dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM UserPrincipal WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM UserAuthority WHERE username = ?");
                //.passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
                    .antMatchers("/login/**").permitAll()
                    /*
                    * '/ticket' will show the logged in users' tickets if they aren't admin (view-your-tickets)
                    * '/ticket/submit will show the create-ticket form
                    * */
                    .antMatchers("/ticket", "ticket/submit").permitAll()
                    //'/ticket' and'/ticket/repository/*' will user view-tickets, latter will show ALL registered tickets
                    .antMatchers("/ticket/repository/*").hasAuthority("READ_ALL_TICKETS")
                    .antMatchers("/flight/add").hasAuthority("CREATE_FLIGHT")
                    .antMatchers("/flight/**").permitAll()
                    .anyRequest().authenticated()



                .and()
                .formLogin().permitAll();//.loginPage("/login").permitAll();
    }


}
