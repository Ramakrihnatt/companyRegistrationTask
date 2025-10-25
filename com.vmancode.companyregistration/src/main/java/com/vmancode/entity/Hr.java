package com.vmancode.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Hr {
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String username;
    private String email;
}
