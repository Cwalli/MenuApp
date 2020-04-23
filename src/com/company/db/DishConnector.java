package com.company.db;

import com.company.entity.Dish;
import com.company.util.CurrentDateUtil;
import com.company.util.DishUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishConnector {

    private static final String SELECT_ALL = "SELECT * FROM dish ORDER BY id ASC";
    private static final String SELECT_BY_ID = "SELECT * FROM dish WHERE id = ?";
    private static final String ADD = "INSERT INTO dish (dish_name, dish_size, dish_cost, dish_weight, dish_note) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE dish SET dish_name = ?, dish_size = ?, dish_cost = ?, dish_weight = ?, dish_note = ?, updated_at = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM inst_menu WHERE dish_id = ?; DELETE FROM dish WHERE id = ?";

    public static List<Dish> getAll() throws SQLException {
        List<Dish> result = new ArrayList<>();

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
        ) {

            while (resultSet.next()) {
                Dish dish = DishUtil.toObject(resultSet);
                result.add(dish);
            }
        }

        return result;
    }

    public static void add(Dish dish) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(ADD)
        ) {

            String dishName = dish.getDishName();
            String dishSize = dish.getDishSize();
            double dishCost = dish.getDishCost();
            int dishWeight = dish.getDishWeight();
            String dishNote = dish.getDishNote();

            statement.setString(1, dishName);
            statement.setString(2, dishSize);
            statement.setDouble(3, dishCost);
            statement.setInt(4, dishWeight);
            statement.setString(5, dishNote);

            statement.executeUpdate();
        }
    }

    public static Dish getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)
        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            Dish dish = DishUtil.toObject(resultSet);

            resultSet.close();

            return dish;
        }
    }

    public static void update(Dish dish, int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1, dish.getDishName());
            statement.setString(2, dish.getDishSize());
            statement.setDouble(3, dish.getDishCost());
            statement.setInt(4, dish.getDishWeight());
            statement.setString(5, dish.getDishNote());
            statement.setDate(6, new Date(CurrentDateUtil.currentUnixTimestamp()));
            statement.setInt(7, id);

            statement.executeUpdate();
        }
    }

    public static void deleteById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(DELETE)
        ) {

            statement.setInt(1, id);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }
}
