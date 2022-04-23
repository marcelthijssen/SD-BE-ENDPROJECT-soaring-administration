package com.example.sdbesoaringadministration.config;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    @Qualifier("jwtAuthenticationEntryPoint")
    public void setJwtAuthenticationEntryPoint(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint){
        this.jwtAuthenticationEntryPoint=jwtAuthenticationEntryPoint;
    }
//    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
//    @Qualifier("jwtUserDetailsService")
    public void setUserDetailsService(UserDetailsService userDetailsService){
        this.userDetailsService=userDetailsService;
    }
//    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    @Qualifier("jwtRequestFilter")
    public void setJwtRequestFilter(JwtRequestFilter jwtRequestFilter){
        this.jwtRequestFilter=jwtRequestFilter;
    }
//@Autowired
//    public WebSecurityConfig( JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
//                              UserDetailsService userDetailsService
////        , JwtRequestFilter jwtRequestFilter
//        ) {
//        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
//        this.userDetailsService = userDetailsService;
////        this.jwtRequestFilter = jwtRequestFilter;
//    }

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {

        auth.userDetailsService( userDetailsService ).passwordEncoder( passwordEncoder() );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure( HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests().antMatchers( "/authenticate", "/register" ).permitAll().
                anyRequest().authenticated().and().

                exceptionHandling().authenticationEntryPoint( jwtAuthenticationEntryPoint ).and().sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS );

        http.addFilterBefore( jwtRequestFilter, UsernamePasswordAuthenticationFilter.class );
    }
}
