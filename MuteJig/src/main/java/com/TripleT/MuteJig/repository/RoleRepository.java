package com.TripleT.MuteJig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TripleT.MuteJig.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {}
