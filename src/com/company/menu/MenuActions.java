package com.company.menu;

import com.company.command.ConsoleReader;
import com.company.db.DishConnector;
import com.company.db.FullInfoConnector;
import com.company.db.InstMenuConnector;
import com.company.db.InstitutionConnector;
import com.company.entity.Dish;
import com.company.entity.InstMenu;
import com.company.entity.Institution;
import java.sql.SQLException;
import java.util.List;


public class MenuActions {
//    int id2;

    public static void printAllAction() throws SQLException {
        System.out.println("1. Вывод списка заведений");
        System.out.println("2. Вывод списка блюд");
        System.out.println("3. Вывод меню заведения");
        int id1 = ConsoleReader.readNumber("Введите номер действия: ");
        switch (id1) {
            case 1:
                List<Institution> result = InstitutionConnector.getAll();
                for (Institution institution : result) {
                    System.out.println(institution);
                }
                break;
            case 2:
                List<Dish> result1 = DishConnector.getAll();
                for (Dish dish : result1) {
                    System.out.println(dish);
                }
                break;
            case 3:
                int id2 = ConsoleReader.readNumber("Введите номер заведения: ");
                FullInfoConnector.getAllInfo(id2);
                break;
            default:
                System.out.println("Введенная команда не существует или не реализована!");
        }
        System.out.println();
        System.out.println();
    }

    public static void addAction() throws SQLException {
        System.out.println("1. Добавление заведения");
        System.out.println("2. Добавление блюда");
        System.out.println("3. Добавление блюда в меню заведения");
        int id1 = ConsoleReader.readNumber("Введите номер действия: ");
        switch (id1) {
            case 1:
                Institution instForAdd = ConsoleReader.readInstitution();
                InstitutionConnector.add(instForAdd);
                break;
            case 2:
                Dish dishForAdd = ConsoleReader.readDish();
                DishConnector.add(dishForAdd);
                break;
            case 3:
                InstMenu instMenuForAdd = ConsoleReader.readInstMenu();
                InstMenuConnector.add(instMenuForAdd);
                break;
            default:
                System.out.println("Введенная команда не существует или не реализована!");
        }
        System.out.println();
        System.out.println();
    }

    public static void updateAction() throws SQLException {
        System.out.println("1. Изменение заведения");
        System.out.println("2. Изменение блюда");
        System.out.println("3. Изменение блюда в меню заведения");
        int id1 = ConsoleReader.readNumber("Введите номер действия: ");
        switch (id1) {
            case 1:
                int id2 = ConsoleReader.readNumber("Введите номер заведения: ");
                Institution instForUpd = ConsoleReader.readInstitution();
                InstitutionConnector.update(instForUpd, id2);
                break;
            case 2:
                int id3 = ConsoleReader.readNumber("Введите номер блюда: ");
                Dish dishForUpd = ConsoleReader.readDish();
                DishConnector.update(dishForUpd, id3);
                break;
            case 3:
                int id4 = ConsoleReader.readNumber("Введите номер блюда в меню: ");
                InstMenu instMenuForAdd = ConsoleReader.readInstMenu();
                InstMenuConnector.update(instMenuForAdd, id4);
                break;
            default:
                System.out.println("Введенная команда не существует или не реализована!");
        }
        System.out.println();
        System.out.println();
    }

    public static void deleteAction() throws SQLException {
        System.out.println("1. Удаление заведения");
        System.out.println("2. Удаление блюда");
        System.out.println("3. Удаление блюда в меню заведения");
        int id1 = ConsoleReader.readNumber("Введите номер действия: ");
        switch (id1) {
            case 1:
                int id2 = ConsoleReader.readNumber("Введите номер заведения: ");
                InstitutionConnector.deleteById(id2);
                break;
            case 2:
                int id3 = ConsoleReader.readNumber("Введите номер блюда: ");
                DishConnector.deleteById(id3);
                break;
            case 3:
                int id4 = ConsoleReader.readNumber("Введите номер блюда в меню: ");
                InstMenuConnector.deleteById(id4);
                break;
            default:
                System.out.println("Введенная команда не существует или не реализована!");
        }
        System.out.println();
        System.out.println();
    }
}
