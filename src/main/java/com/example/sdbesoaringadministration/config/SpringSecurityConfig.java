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
//                /users
                .mvcMatchers( HttpMethod.GET, "/users" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.GET, "/users/**" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.POST, "/users" ).permitAll()
                .mvcMatchers( HttpMethod.PUT, "/users" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.DELETE, "/users/**" ).hasRole( "ADMIN" )
                .antMatchers( HttpMethod.POST, "/users/**/authorities" ).hasAnyRole( "ADMIN" )
                .antMatchers( HttpMethod.POST, "/users/**/authorities/**" ).hasAnyRole( "ADMIN" )
//                /Memberships
                .mvcMatchers( HttpMethod.GET, "/memberships" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.GET, "/memberships/**" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.POST, "/memberships" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.PUT, "/memberships/**" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.DELETE, "/memberships/**" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.PUT, "/membership/" ).hasRole( "ADMIN" )
//                /persons
                .mvcMatchers( HttpMethod.GET, "/persons" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.GET, "/persons/**" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.POST, "/persons" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.PUT, "/persons/**" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.DELETE, "/persons/**" ).hasAnyRole( "ADMIN" )
//                /airports
                .mvcMatchers( HttpMethod.GET, "/airports" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.GET, "/airports/**" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.POST, "/airports" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.PUT, "/airports/**" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.DELETE, "/airports/**" ).hasRole( "ADMIN" )
//                 /addresses
                .mvcMatchers( HttpMethod.GET, "/addresses").hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.GET, "/addresses/**" ).hasAnyRole( "ADMIN", "USER" )
//                /planes
                .mvcMatchers( HttpMethod.GET, "/planes" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.GET, "/planes/**" ).hasAnyRole( "ADMIN", "USER", "TECHNICIAN" )
                .mvcMatchers( HttpMethod.POST, "/planes" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.PUT, "/planes/flightstatus/**" ).hasRole( "TECHNICIAN" )
                .mvcMatchers( HttpMethod.GET, "/planes/flightstatus/**" ).hasAnyRole( "ADMIN", "USER", "TECHNICIAN" )
                .mvcMatchers( HttpMethod.PUT, "/planes/**" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.DELETE, "/planes" ).hasRole( "ADMIN" )
//                /Startingmethodes
                .mvcMatchers( HttpMethod.GET, "/startingmethodes" ).hasRole( "USER" )
                .mvcMatchers( HttpMethod.GET, "/startingmethodes" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.POST, "/startingmethodes" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.PUT, "/startingmethodes/**" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.DELETE, "/startingmethodes/**" ).hasRole( "ADMIN" )
//                /flights
                .mvcMatchers( HttpMethod.GET, "/flights" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.GET, "/flights/**" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.POST, "/flights" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.PUT, "/flights/**" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.DELETE, "/flights/**" ).hasRole( "ADMIN" )
//                  /Invoices
                .mvcMatchers( HttpMethod.GET, "/invoices/**" ).hasAnyRole( "ADMIN", "USER" )
                .mvcMatchers( HttpMethod.GET, "/invoices" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.POST, "/invoices/**" ).hasRole( "ADMIN" )
                .mvcMatchers( HttpMethod.DELETE, "/invoices/**" ).hasRole( "ADMIN" )
//                  /Authenticate
                .mvcMatchers( "/authenticated" ).authenticated()
                .mvcMatchers( "/authenticate" ).permitAll()
                .anyRequest().denyAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS );
        http.addFilterBefore( jwtRequestFilter, UsernamePasswordAuthenticationFilter.class );

    }

}