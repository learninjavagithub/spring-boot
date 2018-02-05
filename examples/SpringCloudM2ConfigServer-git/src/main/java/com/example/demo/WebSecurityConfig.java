package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // do not call super, otherwise you'll get BeanCreationException: Error creating bean with name 'authenticationManagerBean' - org.springframework.beans.FatalBeanException: A dependency cycle was detected when trying to resolve the AuthenticationManager. Please ensure you have configured authentication.
        final String sysadminPassword = "ganesh";
        auth.inMemoryAuthentication()
                .withUser("ganesh")
                .password(sysadminPassword)
                .roles("SYSADMIN", "ADMIN", "USER");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("ganesh").password("ganesh").roles("USER");
    }
    
    @Bean @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    

	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}