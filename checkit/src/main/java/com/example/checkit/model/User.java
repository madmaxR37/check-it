package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@Entity
@Accessors(chain = true)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    protected Long id;

    @Column(name="first_name")
    protected String firstname;

    @Column(name="surname")
    protected String surname;

    @Column(name="email")
    protected String email;

    @Column(name="phoneNumber")
    protected String phoneNumber;

    protected String password;

    protected Boolean activeStatus;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @Embedded
    protected Address address;


    protected Float accountBalance;


    protected String role;

    @Column(name="profilURL")
    protected String profileUrl;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
