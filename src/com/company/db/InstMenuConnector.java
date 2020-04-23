package com.company.db;

import com.company.entity.InstMenu;
import com.company.util.CurrentDateUtil;
import com.company.util.InstMenuUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstMenuConnector {

    private static final String SELECT_ALL = "SELECT * FROM inst_menu ORDER BY id ASC";
    private static final String SELECT_BY_ID = "SELECT * FROM inst_menu WHERE id = ?";
    private static final String ADD = "INSERT INTO inst_menu (inst_id, dish_id) VALUES(?, ?)";
    private static final String UPDATE = "UPDATE inst_menu SET inst_id = ?, dish_id = ?, updated_at = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM inst_menu WHERE id = ?";

    public static List<InstMenu> getAll() throws SQLException {
        List<InstMenu> result = new ArrayList<>();

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
        ) {

            while (resultSet.next()) {
                InstMenu instMenu = InstMenuUtil.toObject(resultSet);
                result.add(instMenu);
            }
        }

        return result;
    }

    public static void add(InstMenu instMenu) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(ADD)
        ) {

            int institutionId = instMenu.getIstitutionId();
            int dishId = instMenu.getDishId();

            statement.setInt(1, institutionId);
            statement.setInt(2, dishId);

            statement.executeUpdate();
        }
    }

    public static InstMenu getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)
        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            InstMenu instMenu = InstMenuUtil.toObject(resultSet);

            resultSet.close();

            return instMenu;
        }
    }

    public static void update(InstMenu instMenu, int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setInt(1, instMenu.getIstitutionId());
            statement.setInt(2, instMenu.getDishId());
            statement.setDate(3, new Date(CurrentDateUtil.currentUnixTimestamp()));
            statement.setInt(4, id);

            statement.executeUpdate();
        }
    }

    public static void deleteById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(DELETE)
        ) {

            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
