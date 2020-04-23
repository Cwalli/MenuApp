package com.company.menu;

import com.company.command.ConsoleReader;
import java.sql.SQLException;

public class MenuWorker {

    public static boolean doAction() throws SQLException {
        MenuWorker.showMenu();

        int command = ConsoleReader.readNumber("Введите команду: ");
        System.out.println();

        switch (command) {
            case 1:
                MenuActions.printAllAction();
                break;
            case 2:
                MenuActions.addAction();
                break;
            case 3:
                MenuActions.deleteAction();
                break;
            case 4:
                MenuActions.updateAction();
                break;
            case 5:
                return false;
            default:
                System.out.println("Введенная команда не существует или не реализована!");
        }

        return true;
    }

    private static void showMenu() {
        System.out.println("1. Вывод на экран");
        System.out.println("2. Добавление");
        System.out.println("3. Удалление");
        System.out.println("4. Обновление");
        System.out.println("5. Выход");

        System.out.println();
    }
}
