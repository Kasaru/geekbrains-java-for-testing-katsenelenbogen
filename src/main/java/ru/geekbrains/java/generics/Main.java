package ru.geekbrains.java.generics;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DB.clear();
        DB.createTable();

        int count = 20;
        List<String> users = DB.createUsers(count);
        DB.addToTable(users);
        System.out.printf("В базу данных добавлено %d новых пользователей\n\n", count);

        System.out.println("Таблица users:");
        DB.getFullTable();

        int min = 10;
        int max = 50;
        System.out.printf("Пользователи старше %d и младше %d\n", min, max);
        DB.showUsersByAge(min,max);

        String name = "User3";
        System.out.printf("Из таблицы удалён пользователь %s\n", name);
        DB.delRowByName(name);
        DB.getFullTable();

    }
}
