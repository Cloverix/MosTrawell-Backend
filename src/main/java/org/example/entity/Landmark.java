package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "landmark")
public class Landmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "desc")
    private String desc;

    @ManyToMany
    @JoinTable(
            name = "landmark_to_tag",
            joinColumns = @JoinColumn(name = "landmark_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Landmark)) return false;
        Landmark landmark = (Landmark) o;
        return id.equals(landmark.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
