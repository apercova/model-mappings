package github.apercova.mapping.examples.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressDto {
    private String nameOfStreet;
    private int number;
    private String floor;
    private int zipCode;
}
