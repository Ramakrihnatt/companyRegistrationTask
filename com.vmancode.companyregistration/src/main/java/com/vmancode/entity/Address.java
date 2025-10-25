package com.vmancode.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    private String type;
    private String houseNo;
    private String street;
    private String landmark;
    private String city;
    private String state;
    private String country;
    private String zip;
}
