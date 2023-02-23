package ru.gnezdilov.spring.SecurityApp.mappers;

import org.mapstruct.Mapper;
import ru.gnezdilov.spring.SecurityApp.dto.PersonDTO;
import ru.gnezdilov.spring.SecurityApp.models.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toEntity(PersonDTO personDTO);
}
