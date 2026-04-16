package com.pablofranca.webservicesmongo.dto;

import com.pablofranca.webservicesmongo.domain.User;

public record UserDTO(String id, String name, String email) {

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.id, userDTO.email, userDTO.name);
    }

}
