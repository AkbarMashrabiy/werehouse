package uz.pdp.werehouse.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // Hozircha test uchun fixed user
        //TODO Keyinchalik SecurityContextHolder’dan
        return Optional.of("system");
    }
}
