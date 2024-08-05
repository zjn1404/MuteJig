package com.TripleT.MuteJig.entity;

import com.TripleT.MuteJig.repository.PermissionRepository;
import com.TripleT.MuteJig.repository.RoleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class role_permission {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @BeforeEach
    void setUp() {
        Set<Permission> permissions = new HashSet<>();
        permissions.add(Permission.builder()
                .name("bo thien ha")
                .description("nhu ten")
                .build());
        permissions.add(Permission.builder()
                .name("con thien ha")
                .description("deo cho")
                .build());

        Role god  = Role.builder()
                .name("wibu")
                .description("wibu dinh xa hoi")
                .permissions(permissions)
                .build();
        entityManager.persist(god);
    }
   @Test
   public void testRelationshipBetweenRoleAndPermission() {
        String testRole = "wibu";
        Role roleWithWibu = roleRepository.
                findById(testRole).orElseThrow();

        assertNotNull(roleWithWibu);
        assertThat(roleWithWibu.getName()).isEqualTo(testRole);

        List<Permission> permissions = new ArrayList<>(roleWithWibu.getPermissions());

        assertNotNull(permissions);
        assertThat(permissions.size()).isEqualTo(2);


   }
   @Test
    public void whenRoleisDeleted_then_itsPermissionDeleted() {
       String testRole = "wibu";
       Role roleWithWibu = roleRepository.
               findById(testRole).orElseThrow();

       Permission firstOne = roleWithWibu.getPermissions().stream().findFirst().orElseThrow();

       roleRepository.deleteById(testRole);

       assertThat(permissionRepository.findById(firstOne.getName()).orElse(null)).isNull();
   }
}