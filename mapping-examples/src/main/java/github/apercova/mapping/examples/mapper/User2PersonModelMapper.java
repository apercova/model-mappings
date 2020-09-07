package github.apercova.mapping.examples.mapper;

import github.apercova.mapping.examples.dto.UserDto;
import github.apercova.mapping.examples.entity.Person;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.text.MessageFormat;

public class User2PersonModelMapper {

    public final static Person user2Person(UserDto user) {
        org.modelmapper.ModelMapper modelMapper = new org.modelmapper.ModelMapper();
        modelMapper.typeMap(UserDto.class, Person.class).addMappings(mapper -> {
            mapper.map(UserDto::getSurName, Person::setLastName);
            mapper.map(UserDto::getEmail, Person::setEmailAddress);
            mapper.using(FullNameConverter.INSTANCE).map(src -> src, Person::setFullName);
        });
        final Person person = modelMapper.map(user, Person.class);
        return person;
    }

    public final static class FullNameConverter implements Converter<UserDto, String> {

        public final static FullNameConverter INSTANCE = new FullNameConverter();

        private FullNameConverter() {}

        @Override
        public String convert(MappingContext<UserDto, String> context) {
            final UserDto user = context.getSource();
            return MessageFormat.format("{0} {1}", user.getFirstName(), user.getSurName());
        }
    }

}
