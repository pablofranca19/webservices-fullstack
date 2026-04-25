package com.pablofranca.webservicesmongo.dto;

import com.pablofranca.webservicesmongo.domain.User;

import java.io.Serializable;

public record AuthorDTO(String id, String name) implements Serializable {

    private static final long serialVersionUID = 1L;

    public AuthorDTO (User user) {
        this(user.getId(), user.getName());
    }

}
