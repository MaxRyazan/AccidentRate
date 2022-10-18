package ru.maxryazan.accidentrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxryazan.accidentrate.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByFirstNameAndLastNameAndPatronymic(String firstName, String lastName, String patrinymic);

}
