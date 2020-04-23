package com.company.util;

import com.company.entity.Institution;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class InstitutionUtil {

    public static Institution toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String instName = resultSet.getString("inst_name");
        String instType = resultSet.getString("inst_type");
        String openingHours = resultSet.getString("opening_hours");
        String phone = resultSet.getString("phone");
        String address = resultSet.getString("address");
        Date createdAt = resultSet.getDate("created_at");
        Date updatedAt = resultSet.getDate("updated_at");

        return new Institution(id, instName, instType, openingHours, phone, address, createdAt, updatedAt);
    }
}
