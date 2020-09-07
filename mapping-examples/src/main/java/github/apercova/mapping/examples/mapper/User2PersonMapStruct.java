package github.apercova.mapping.examples.mapper;

import github.apercova.mapping.examples.dto.UserDto;
import github.apercova.mapping.examples.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.text.MessageFormat;

@Mapper
public interface User2PersonMapStruct {

    User2PersonMapStruct INSTANCE = Mappers.getMapper(User2PersonMapStruct.class);

    @Mappings({
            @Mapping(source = "surName", target = "lastName"),
            @Mapping(source = "email", target = "emailAddress"),
            @Mapping(source = "user", target = "fullName", qualifiedByName = "User2PersonFullName")
    })
    Person user2Person(UserDto user);

    @Named("User2PersonFullName")
    default String User2PersonFullname(UserDto user) {
        return MessageFormat.format("{0} {1}", user.getFirstName(), user.getSurName());
    }

}
