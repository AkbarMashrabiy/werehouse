package uz.pdp.werehouse.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Optional;

public class SpringSecurityAuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null || !authentication.isAuthenticated()) {
                return Optional.of("system");
            }

            Object principal = authentication.getPrincipal();

            if (principal instanceof org.springframework.security.core.userdetails.User) {
                return Optional.of(((org.springframework.security.core.userdetails.User) principal).getUsername());
            } else if (principal instanceof String) {
                return Optional.of((String) principal);
            }

            return Optional.of("unknown");
        } catch (Exception e) {
            return Optional.of("system");
        }
    }
}
