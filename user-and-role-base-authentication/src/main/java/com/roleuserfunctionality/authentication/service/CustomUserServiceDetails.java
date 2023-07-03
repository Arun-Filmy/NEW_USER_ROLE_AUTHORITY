package com.roleuserfunctionality.authentication.service;

import com.roleuserfunctionality.authentication.details.CustomUserDetails;
import com.roleuserfunctionality.authentication.entity.Roles;
import com.roleuserfunctionality.authentication.entity.Users;
import com.roleuserfunctionality.authentication.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomUserServiceDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        List<Users> userList = new ArrayList<>();
        userList.add(user);

        for (Users userDetails : userList) {
            System.out.println(userDetails);
        }
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found!!");
        }
        return new CustomUserDetails(user);
    }

//    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Roles> roles) {
//        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
//        return mapRoles;
//    }
}
