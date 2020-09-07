package github.apercova.mapping.examples.mapper;

import github.apercova.mapping.examples.dto.UserAddressDto;
import github.apercova.mapping.examples.entity.Address;
import github.apercova.mapping.examples.entity.Person;
import github.apercova.mapping.examples.dto.UserDto;

import java.text.MessageFormat;

public class User2personManualMapper {

    public final static Person convert(UserDto user) {
        final Person person = new Person();
        person.setFirstName(user.getFirstName());
        person.setLastName(user.getSurName());
        person.setEmailAddress(user.getEmail());
        person.setFullName(fullNameConvert(user));

        final UserAddressDto userAddress = user.getAddress();
        if (userAddress != null) {
            person.setAddress(new Address());
            person.getAddress().setStreet(userAddress.getNameOfStreet());
            person.getAddress().setNumber(userAddress.getNumber());
            person.getAddress().setAppartment(userAddress.getFloor());
            person.getAddress().setZip(String.valueOf(userAddress.getZipCode()));
        }

        return person;
    }

    public static String fullNameConvert(UserDto user) {
        return MessageFormat.format("{0} {1}", user.getFirstName(), user.getSurName());
    }

}
