package security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;

@Configuration
public class WebSecurityConfiguration {
    @Bean
    SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
            .requestMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
            .requestMatchers("/api/**").authenticated()
            .anyRequest().authenticated())
            .oauth2ResourceServer(it -> it.jwt(Customizer.withDefaults()));
            return http.build();
    }
}
