package ru.gnezdilov.spring.SecurityApp.services;

import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gnezdilov.spring.SecurityApp.models.Book;
import ru.gnezdilov.spring.SecurityApp.models.Person;
import ru.gnezdilov.spring.SecurityApp.repositories.PeopleRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PeopleService {

    private final PeopleRepository peopleRepository;
    private final JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

//    @Transactional
//    public void update(int id, Person updatedPerson) {
//        updatedPerson.setId(id);
//        peopleRepository.save(updatedPerson);
//    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("update Person set year_of_birth=? where id=?",
                updatedPerson.getYearOfBirth(), id);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

    public Optional<Person> getPersonByFullName(String fullName) {
        return peopleRepository.findByFullName(fullName);
    }

    public List<Book> getBooksByPersonId(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        if (person.isPresent()) {
            Hibernate.initialize(person.get().getBooks());
            person.get().getBooks().forEach(book -> {
                long diffInMillies = Math.abs(book.getTakenAt().getTime() - new Date().getTime());
                // 864000000 = 10 суток
                if (diffInMillies > 864000000)
                    book.setExpired(true);
            });
            return person.get().getBooks();
        }
        else {
            return Collections.emptyList();
        }
    }
}
