package com.example.sdbesoaringadministration.security;

import com.example.sdbesoaringadministration.repositories.AirportRepository;
import com.example.sdbesoaringadministration.services.JwtService;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    //    @Autowired
//    JwtService jwtService;
    private final JwtService jwtService;

    public SpringSecurityConfig( JwtService jwtService ) {
        this.jwtService = jwtService;
    }

    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser( "karel" ).password( "{noop}appel" ).roles( "ADMIN" )
                .and()
                .withUser( "kees" ).password( "{noop}kaas" ).roles( "USER" );
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http
                .httpBasic()
                .and()
                .sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS )

                .and()
                .authorizeRequests()
                .antMatchers( "/**" ).permitAll() // Remove when activating lines below

//                .antMatchers( HttpMethod.POST, "/auth").permitAll()
//                .antMatchers( HttpMethod.DELETE ).hasRole( "ADMIN" )
//                .antMatchers( HttpMethod.PUT ).hasRole( "ADMIN" )
//                .antMatchers( HttpMethod.POST ).hasRole( "ADMIN" )
//                .antMatchers( HttpMethod.GET ).hasAnyRole( "USER", "ADMIN" )
//                .antMatchers(  "/**").anonymous()

                .and().authorizeRequests().anyRequest().authenticated()

                .and().addFilterBefore( new JwtRequestFilter( jwtService, userDetailsService() ), UsernamePasswordAuthenticationFilter.class )
                .csrf().disable();
    }

}