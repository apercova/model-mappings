package github.apercova.mapping.examples.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor()
public class UserDto {
    private int id;
    private String userName;
    private String firstName;
    private String surName;
    private String email;
    private UserAddressDto address;
}
