package org.example.repository;

import org.example.model.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarPartsRepository extends JpaRepository<CarPart, Integer> {

}
