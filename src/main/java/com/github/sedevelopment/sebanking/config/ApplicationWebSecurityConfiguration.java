package com.github.sedevelopment.sebanking.config;

import com.github.sedevelopment.sebanking.logging.LoggingAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf().disable();

        //Landing page
        httpSecurity.authorizeRequests().antMatchers("/", "/login", "/logout");

       //Access Denied Handler
        httpSecurity.authorizeRequests().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);

        //ADMIN
        httpSecurity.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

        //Login form
        httpSecurity.authorizeRequests().and()
                .formLogin()
                .loginProcessingUrl("process_login")
                .loginPage("/login")
                .defaultSuccessUrl("/userAccount")
                .usernameParameter("username")
                .passwordParameter("password")
                //logout
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logoutSuccess");
    }
}
