package com.example.deplom.models;

import com.example.deplom.models.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails, Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {// якщо що забрати
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public Object getCredentials() {// якщо що забрати
        return true;
    }

    @Override
    public Object getDetails() {// якщо що забрати
        return true;
    }

    @Override
    public Object getPrincipal() {// якщо що забрати
        return null;
    }

    @Override
    public boolean isAuthenticated() {// якщо що забрати
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    } // якщо що забрати

    @Override
    public String getUsername() {
        return username;
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

    @Override
    public String getName() {
        return null;
    }
}
