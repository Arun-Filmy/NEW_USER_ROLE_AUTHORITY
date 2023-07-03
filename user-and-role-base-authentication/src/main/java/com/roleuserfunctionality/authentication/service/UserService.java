package com.roleuserfunctionality.authentication.service;

import com.roleuserfunctionality.authentication.dto.UserDto;
import com.roleuserfunctionality.authentication.dto.UserRegistrationDto;
import com.roleuserfunctionality.authentication.entity.Roles;
import com.roleuserfunctionality.authentication.entity.Users;
import com.roleuserfunctionality.authentication.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, RoleService roleService, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    public UserDto registerUser(UserRegistrationDto userRegistrationDto) {
        Users existingUser = userRepository.findByUsername(userRegistrationDto.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists.");
        }

        Users newUser = new Users();
        newUser.setUsername(userRegistrationDto.getUsername());
        newUser.setPassword(encoder.encode(userRegistrationDto.getPassword()));
        System.out.println("newUser is set");
        Roles role = roleService.findRoleByName(userRegistrationDto.getRoleName());
        System.out.println("Comes back");
        if (role == null) {
            throw new NoSuchElementException("Role not found.");
        }
        System.out.println("Checked role of user");
        newUser.getRoles().add(role);

        Users savedUser = userRepository.save(newUser);
        return UserDto.fromEntity(savedUser);
    }

    public Users getUserById(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found."));
        return user;
    }

}
