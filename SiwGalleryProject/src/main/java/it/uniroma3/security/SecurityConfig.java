package it.uniroma3.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.jdbcAuthentication().dataSource(dataSource)
    .usersByUsernameQuery("select username,password, enabled from users where username=?")
    .authoritiesByUsernameQuery("select username, role from user_roles where username=?");

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/**").permitAll()
       .antMatchers("/amministraArtista","/paginaArtista/**","/artistaAggiunta","/nuovaOpera/**").hasRole("ADMIN")
        .anyRequest().authenticated();
    http.formLogin().defaultSuccessUrl("/amministratore.html", true).and().
    formLogin().loginPage("/loginAmministratore").permitAll().and().logout()
    .permitAll();
    http.exceptionHandling().accessDeniedPage("/403");
  }


}