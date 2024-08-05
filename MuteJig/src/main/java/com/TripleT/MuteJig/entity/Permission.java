package com.TripleT.MuteJig.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Entity(name = "permission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Permission {
    @Id
    @Column(name = "name", nullable = false, unique = true)
    String name;
    
    @Column(name = "description")
    String description;

}
