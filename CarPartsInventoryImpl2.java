package org.example.repository;

import org.example.model.CarPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

//TODO: create table tbl_carpart(part_no int, part_name varchar(20), car_model varchar(30), price double, quantity int);

@Component("carPartsInv2")
public class CarPartsInventoryImpl2 implements CarPartsInventory {

    @Autowired
    private DataSource dataSource; //Connection Pooling

    @Override
    public void addNewPart(CarPart carPart) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            String sql = "insert into tbl_carpart values(?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, carPart.getPartNo());
            st.setString(2, carPart.getPartName());
            st.setString(3, carPart.getCarModel());
            st.setDouble(4, carPart.getPrice());
            st.setInt(5, carPart.getQuantity());
            st.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try { conn.close(); } catch (Exception e)  { }
        }

    }

    @Override
    public List<CarPart> getAvailableParts() {
        return null;
    }
}
