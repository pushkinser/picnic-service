package ru.picnic.picnicservice.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.picnic.picnicservice.domain.model.User;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails extends User implements UserDetails {

    private static final String ROLE_PREFIX = "ROLE_";

    public CustomUserDetails(User user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleName = getRole().getRoleName().toUpperCase();
        return Collections.singletonList(new SimpleGrantedAuthority(ROLE_PREFIX + roleName));
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
