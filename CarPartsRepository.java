package org.example.repository;

import org.example.model.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarPartsRepository extends JpaRepository<CarPart, Integer> {

    @Query("select c from CarPart c where c.carModel = ?1")
    public List<CarPart> fetchByCarModel(String carModel);

    public List<CarPart> findByCarModel(String carModel);
}
