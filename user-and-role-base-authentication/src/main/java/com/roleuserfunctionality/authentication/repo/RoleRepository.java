package com.roleuserfunctionality.authentication.repo;

import com.roleuserfunctionality.authentication.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}
