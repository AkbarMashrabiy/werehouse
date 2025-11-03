package uz.pdp.werehouse.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import uz.pdp.werehouse.security.MyUserDetailsService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private static final String[] WHITE_LIST = new String[]{
            "/api/v1/auth/login",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/api/v1/auth/refresh-token",
            "/sw"
    };

    private final MyUserDetailsService myUserDetailsService;

    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.requestMatchers(WHITE_LIST)
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                });
        return http.build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}