package com.cccmbiz.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        // require all requests to be authenticated except for the resources
//        http.authorizeRequests().antMatchers("/javax.faces.resource/**")
//                .permitAll().anyRequest().authenticated();

        try {
//            http.csrf().disable();
//            http
//                    .authorizeRequests()
//                    .antMatchers("/").permitAll()
//                    .antMatchers("/**").permitAll()
//                    .antMatchers("/javax.faces.resource/**").permitAll()
//                    .antMatchers("/images/**").permitAll()
//            ;
            http
                    // we don't need CSRF because our token is invulnerable
                    .csrf().disable()
                    // All urls must be authenticated (filter for token always fires (/**)
                    .authorizeRequests().anyRequest().permitAll()
                    .and()
                    // don't create session
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //.and()


            // disable page caching
            http.headers().cacheControl();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication().withUser("user")
//                .password("{noop}1234").roles("USER").and()
//                .withUser("admin").password("{noop}5678").roles("ADMIN");
//    }
//        protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable()
//                .authorizeRequests().antMatchers("/","/meal").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().disable();
//    }
}