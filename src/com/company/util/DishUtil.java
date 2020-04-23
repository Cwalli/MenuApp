package com.company.util;

import com.company.entity.Dish;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DishUtil {
    public static Dish toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String dishName = resultSet.getString("dish_name");
        String dishSize = resultSet.getString("dish_size");
        double dishCost = resultSet.getDouble( "dish_cost");
        int dishWeight = resultSet.getInt("dish_weight");
        String dishNote = resultSet.getString("dish_note");
        Date createdAt = resultSet.getDate("created_at");
        Date updatedAt = resultSet.getDate("updated_at");

        return new Dish(id, dishName, dishSize, dishCost, dishWeight, dishNote, createdAt, updatedAt);
    }
}
