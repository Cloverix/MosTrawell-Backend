package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;
import java.util.Set;

@Data
@Entity

public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority", nullable = false, unique = true)
    private String authority;

    @ToString.Exclude
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authority)) return false;
        Authority authority = (Authority) o;
        return id.equals(authority.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
