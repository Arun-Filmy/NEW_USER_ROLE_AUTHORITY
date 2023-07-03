package com.roleuserfunctionality.authentication.dto;
import com.roleuserfunctionality.authentication.entity.Roles;
import com.roleuserfunctionality.authentication.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private Set<RoleDto> roles;

    public static UserDto fromEntity(Users user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        Set<RoleDto> roleDtos = user.getRoles().stream()
                .map((Roles role) -> RoleDto.fromEntity(role))
                .collect(Collectors.toSet());
        userDto.setRoles(roleDtos);

        return userDto;
    }
}
