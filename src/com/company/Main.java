package com.company;

import com.company.db.InstitutionConnector;
import com.company.exception.eException;
import com.company.menu.MenuWorker;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {
        InstitutionConnector.getAll();
        boolean continueLoop = true;
        while (continueLoop) {
            try {
                continueLoop = MenuWorker.doAction();
            } catch (eException e) {
                System.out.println("ОШИБКА: " + e.getMessage());
            }

        }

        System.out.println("Программа завершена");

    }

}
