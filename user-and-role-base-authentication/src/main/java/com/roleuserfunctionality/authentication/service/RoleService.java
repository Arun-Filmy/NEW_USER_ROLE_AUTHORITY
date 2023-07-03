package com.roleuserfunctionality.authentication.service;

import com.roleuserfunctionality.authentication.entity.Roles;
import com.roleuserfunctionality.authentication.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Roles findRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
