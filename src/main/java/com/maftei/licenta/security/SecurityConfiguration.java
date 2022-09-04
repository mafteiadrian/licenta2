package com.maftei.licenta.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().formLogin().loginPage("/login")
                .failureUrl("/login?login_error=t")
                .loginProcessingUrl("/resources/j_spring_security_check")
                .and()
                .logout()
                .logoutUrl("/resources/j_spring_security_logout")
                .and()
                .authorizeRequests()
                .antMatchers("/utilizators/**").hasRole("admin")
                .antMatchers("/angajats/**").hasRole("admin")
                .antMatchers("/rols/**").hasRole("admin")
                .antMatchers("/jobs/**").hasRole("sales")
                .antMatchers("/echipamentservices/**").hasRole("service")
                .antMatchers("/constatares/**").hasRole("service")
                .antMatchers("/interventies/**").hasRole("service")
                .antMatchers("/clients/**").hasRole("sales")
                .antMatchers("/echipamentproducties/**").hasRole("manager")
                .antMatchers("/materials/**").hasRole("manager")
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/index").authenticated()
                .antMatchers("/").authenticated();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcDaoImpl jdbcDaoImpl = new JdbcUserDetailsManager(dataSource);
        jdbcDaoImpl.setUsersByUsernameQuery("select nume_utilizator,parola,1 from utilizator where nume_utilizator=?");
        jdbcDaoImpl.setAuthoritiesByUsernameQuery("select u.nume_utilizator, r.nume_rol from rol r join utilizator_rol ur on r.id=ur.rol_id join utilizator u on ur.utilizator_id=u.id where u.nume_utilizator=?");
        jdbcDaoImpl.setRolePrefix("ROLE_");
        return jdbcDaoImpl;

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}