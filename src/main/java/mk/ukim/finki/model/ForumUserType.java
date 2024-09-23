package mk.ukim.finki.model;

import org.springframework.security.core.GrantedAuthority;

public enum ForumUserType implements GrantedAuthority {
    ROLE_ADMIN,
    REGULAR,
    GOLDEN;

    @Override
    public String getAuthority() {
        return name();
    }
}
