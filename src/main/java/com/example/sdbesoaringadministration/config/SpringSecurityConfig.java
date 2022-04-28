package com.example.sdbesoaringadministration.config;

import com.example.sdbesoaringadministration.filter.JwtRequestFilter;
import com.example.sdbesoaringadministration.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {
        auth.userDetailsService( customUserDetailsService );
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // DON'T REMOVE 'static' PasswordEncoder. This prevents forming a cycle.
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {

        //JWT token authentication
        http
                .csrf().disable()
                .authorizeRequests()
                .mvcMatchers(HttpMethod.POST,"/users").permitAll()
                .mvcMatchers(HttpMethod.PUT,"/users").permitAll()
                .mvcMatchers("/users").hasRole("ADMIN")
                .mvcMatchers( HttpMethod.DELETE, "/users/").hasRole("ADMIN")
                .mvcMatchers("/authenticated").authenticated()
                .mvcMatchers("/authenticate").permitAll()
                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS );
        http.addFilterBefore( jwtRequestFilter, UsernamePasswordAuthenticationFilter.class );

    }

}