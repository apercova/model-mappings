package github.apercova.mapping.examples;

import github.apercova.mapping.examples.dto.UserAddressDto;
import github.apercova.mapping.examples.entity.Person;
import github.apercova.mapping.examples.dto.UserDto;
import github.apercova.mapping.examples.mapper.User2PersonMapStruct;
import github.apercova.mapping.examples.mapper.User2PersonModelMapper;
import github.apercova.mapping.examples.mapper.User2personManualMapper;

public class User2PersonMappingTest {

    public static void main(String[] args) {
        final UserAddressDto userAddressDto = new UserAddressDto("Rock Mountains", 103, "C104", 12834);
        final UserDto user = new UserDto(1001, "ppedro", "Pedro", "Picapiedra", "ppedro@petra.com", userAddressDto);
        System.out.println("-------------------- manualUser2PersonMapping --------------------");
        System.out.println(manualUser2PersonMapping(user).toString());

        System.out.println("--------------------- modelMapperUser2Person ---------------------");
        System.out.println(modelMapperUser2Person(user).toString());

        System.out.println("---------------------- mapStructUser2Person ----------------------");
        System.out.println(mapStructUser2Person(user).toString());
    }

    private static Person manualUser2PersonMapping(UserDto user) {
        return User2personManualMapper.convert(user);
    }

    private static Person modelMapperUser2Person(UserDto user) {
        return User2PersonModelMapper.user2Person(user);
    }

    private static Person mapStructUser2Person(UserDto user) {
        return User2PersonMapStruct.INSTANCE.user2Person(user);
    }

}
