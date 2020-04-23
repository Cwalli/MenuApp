package com.company.util;

import com.company.entity.InstMenu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class InstMenuUtil {
    public static InstMenu toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int InstitutionId = resultSet.getInt("inst_id");
        int DishId = resultSet.getInt("dish_id");
        Date createdAt = resultSet.getDate("created_at");
        Date updatedAt = resultSet.getDate("updated_at");


        return new InstMenu(id, InstitutionId, DishId, createdAt, updatedAt);
    }
}

