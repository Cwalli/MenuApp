package com.company.command;

import com.company.entity.Dish;
import com.company.entity.InstMenu;
import com.company.entity.Institution;
import java.util.Scanner;

public class ConsoleReader {
    private static final Scanner scanner = new Scanner(System.in);

    public static Institution readInstitution() {
        String instName =  ConsoleReader.readString("Введите название заведения: ");
        String instType =  ConsoleReader.readString("Введите тип заведения: ");
        String openingHours =  ConsoleReader.readString("Введите время работы заведения: ");
        String phone =  ConsoleReader.readString("Введите телефон заведения: ");
        String  address =  ConsoleReader.readString("Введите адрес заведения: ");



        return new Institution( instName,  instType,  openingHours,  phone, address);
    }
    public static Dish readDish() {
        String dishName =  ConsoleReader.readString("Введите название блюда: ");
        String  dishSize =  ConsoleReader.readString("Введите размер блюда: ");
        double dishCost =  ConsoleReader.readCost("Введите стоимость блюда: ");
        int dishWeight =  ConsoleReader.readNumber("Введите вес блюда: ");
        String  dishNote =  ConsoleReader.readString("Введите описание блюда: ");

        return new Dish(dishName, dishSize, dishCost, dishWeight, dishNote);
    }

    public static InstMenu readInstMenu() {
        int DishId =  ConsoleReader.readNumber("Введите номер блюда: ");
        int IstitutionId =  ConsoleReader.readNumber("Введите номер заведения, в меню которого нужно добавить блюдо: ");

        return new InstMenu(DishId, IstitutionId);
    }

    public static int readNumber(String message) {
        System.out.print(message);

        return Integer.parseInt(scanner.nextLine());
    }

    public static double readCost(String message) {
        System.out.print(message);

        return Double.parseDouble(scanner.nextLine());
    }

    public static String readString(String message) {
        System.out.print(message);

        return scanner.nextLine();
    }
}
