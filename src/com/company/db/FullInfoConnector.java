package com.company.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FullInfoConnector {

    private static final String FULL_INST_INFO = "SELECT i.id, i.inst_name, i.inst_type, i.opening_hours, i.phone, i.address FROM institution i WHERE id=?";
    private static final String FULL_DISH_INFO = "SELECT d.id, d.dish_name, d.dish_size, d.dish_cost, d.dish_weight, d.dish_note FROM inst_menu im JOIN dish d ON im.dish_id = d.id WHERE inst_id=?";

    public static void getAllInfo(int id) throws SQLException {
        Connection connection = DbConnector.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(FULL_INST_INFO);

        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " - " + resultSet.getString("inst_name") + " - " + resultSet.getString("inst_type") + " - " + resultSet.getString("opening_hours") + " - " + resultSet.getString("phone"));
//                resultSet.close();
            }

            try (
                    PreparedStatement statement2 = connection.prepareStatement(FULL_DISH_INFO);

            ) {
                statement2.setInt(1, id);
                resultSet = statement2.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("id") + " - " + resultSet.getString("dish_name") + " - " + resultSet.getString("dish_size") + " - " + resultSet.getString("dish_cost") + " - " + resultSet.getString("dish_weight")+ " - " + resultSet.getString("dish_note"));
                }

            }


        }
    }
}
