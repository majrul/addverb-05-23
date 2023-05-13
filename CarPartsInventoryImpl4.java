package org.example.repository;

import org.example.model.CarPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//TODO: create table tbl_carpart(part_no int, part_name varchar(20), car_model varchar(30), price double, quantity int);

@Component("carPartsInv4")
public class CarPartsInventoryImpl4 implements CarPartsInventory {

    @PersistenceContext //@Autowired does not works for injecting EntityManager object
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addNewPart(CarPart carPart) {
        entityManager.persist(carPart);
    }

    @Override
    public List<CarPart> getAvailableParts() {
        return entityManager
                .createQuery("select c from CarPart c where c.quantity > :qty", CarPart.class)
                .setParameter("qty", 0)
                .getResultList();
    }
}
