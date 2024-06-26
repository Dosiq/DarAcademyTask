package kz.dar.university.mainapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfiguration {



//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http.csrf().disable()
////                .authorizeHttpRequests()
////                .requestMatchers("/auth/register", "/auth/token", "/auth/validate")
////                .permitAll()
////                .and()
////                .build();
//        return http
//                .securityMatcher("/auth/**")
//                .authorizeHttpRequests(authorize -> authorize
//                        .anyRequest().hasAnyRole()
//                )
//                .httpBasic(Customizer.withDefaults())
//                .build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    };
}
