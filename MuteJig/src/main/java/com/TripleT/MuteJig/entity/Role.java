package com.TripleT.MuteJig.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Negative;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Entity(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Role {
    @Id
    @Column(name = "name", nullable = false, unique = true)
    String name;

    @Column(name = "description")
    String description;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH, CascadeType.REMOVE}
    )
    @JoinTable(
            name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_name")},
            inverseJoinColumns = {@JoinColumn(name = "permission_name")}
    )
    Set<Permission> permissions;

}
