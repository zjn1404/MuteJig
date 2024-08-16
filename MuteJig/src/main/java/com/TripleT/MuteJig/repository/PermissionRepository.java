package com.TripleT.MuteJig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TripleT.MuteJig.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {}
