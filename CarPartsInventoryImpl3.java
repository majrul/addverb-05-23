package org.example.repository;

import org.example.model.CarPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

//TODO: create table tbl_carpart(part_no int, part_name varchar(20), car_model varchar(30), price double, quantity int);

@Component("carPartsInv3")
public class CarPartsInventoryImpl3 implements CarPartsInventory {

    @Autowired
    private DataSource dataSource; //Connection Pooling

    @Override
    public void addNewPart(CarPart carPart) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into tbl_carpart values(?, ?, ?, ?, ?)",
                            carPart.getPartNo(),
                            carPart.getPartName(),
                            carPart.getCarModel(),
                            carPart.getPrice(),
                            carPart.getQuantity());
    }

    @Override
    public List<CarPart> getAvailableParts() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<CarPart> list = jdbcTemplate.query("select * from tbl_carpart",
                                                BeanPropertyRowMapper.newInstance(CarPart.class));
        return list;
    }
}
