package com.pablofranca.webservicesmongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public record CommentDTO(String text, LocalDate date, AuthorDTO author) implements Serializable {

    private static final long serialVersionUID = 1L;

}
