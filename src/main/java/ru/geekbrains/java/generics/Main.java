package ru.geekbrains.java.generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DB.clear();
        DB.createTable();

        int count = 200;
        List<String> users = DB.createUsers(count);
        DB.addToTable(users);
        System.out.printf("В базу данных добавлено %d новых пользователей\n", count);

        System.out.println("Таблица users:");
        DB.getFullTable();

        int min = 10;
        int max = 50;
        System.out.printf("Пользователи старше %d и младше %d\n", min, max);
        DB.getUsersByAge(min,max);



    }
}
