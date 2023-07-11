package com.aryan.BMS.repository;

import com.aryan.BMS.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City save(City city); // save and update
    Optional<City> findById(Long id); // select * from city where id = :id:
    List<City> findAllByNameAndPincode(String name); // select * from city where name = :name and pincode = :1

}
