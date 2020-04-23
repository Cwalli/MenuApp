package com.company.db;

import com.company.entity.Institution;
import com.company.util.CurrentDateUtil;
import com.company.util.InstitutionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstitutionConnector {


    private static final String SELECT_ALL = "SELECT * FROM institution ORDER BY id ASC";
    private static final String SELECT_BY_ID = "SELECT * FROM institution WHERE id = ?";
    private static final String ADD = "INSERT INTO institution (inst_name, inst_type, opening_hours, phone, address) VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE institution SET inst_name = ?, inst_type = ?, opening_hours = ?, phone = ?, address = ?, updated_at = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM inst_menu WHERE inst_id = ?; DELETE FROM institution WHERE id = ?";

    public static List<Institution> getAll() throws SQLException {
        List<Institution> result = new ArrayList<>();

        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = statement.executeQuery();
        ) {

            while (resultSet.next()) {
                Institution institution = InstitutionUtil.toObject(resultSet);
                result.add(institution);
            }
        }

        return result;
    }

    public static void add(Institution institution) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(ADD)
        ) {

            String instName = institution.getInstName();
            String instType = institution.getInstType();
            String openingHours = institution.getOpeningHours();
            String phone = institution.getPhone();
            String address = institution.getAddress();

            statement.setString(1, instName);
            statement.setString(2, instType);
            statement.setString(3, openingHours);
            statement.setString(4, phone);
            statement.setString(5, address);

            statement.executeUpdate();
        }
    }

    public static Institution getById(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)
        ) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            Institution institution = InstitutionUtil.toObject(resultSet);

            resultSet.close();

            return institution;
        }
    }

    public static void update(Institution institution, int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE)
        ) {
            statement.setString(1, institution.getInstName());
            statement.setString(2, institution.getInstType());
            statement.setString(3, institution.getOpeningHours());
            statement.setString(4, institution.getPhone());
            statement.setString(5, institution.getAddress());
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
