package org.example.repository;

import org.example.model.CarPart;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

//TODO: create table tbl_carpart(part_no int, part_name varchar(20), car_model varchar(30), price double, quantity int);

@Component("carPartsInv1")
public class CarPartsInventoryImpl1 implements CarPartsInventory {
    @Override
    public void addNewPart(CarPart carPart) {
        Connection conn = null;
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            //conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;db-name", "user", "password");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
            String sql = "insert into tbl_carpart values(?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, carPart.getPartNo());
            st.setString(2, carPart.getPartName());
            st.setString(3, carPart.getCarModel());
            st.setDouble(4, carPart.getPrice());
            st.setInt(5, carPart.getQuantity());
            st.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e) {
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
