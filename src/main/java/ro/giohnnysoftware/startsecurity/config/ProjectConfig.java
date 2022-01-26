package ro.giohnnysoftware.startsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import ro.giohnnysoftware.startsecurity.security.AppUserDetailsManager;
import ro.giohnnysoftware.startsecurity.security.PlainTextPasswordEncoder;
import ro.giohnnysoftware.startsecurity.security.User;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PlainTextPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager () {
        AppUserDetailsManager manager = new AppUserDetailsManager();
        manager.createUser(new User("john","12345"));
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
        //http.authorizeRequests().anyRequest().permitAll();
        //super.configure(http);
    }
}
