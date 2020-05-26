package ru.geekbrains.java.generics;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DB {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement psInsert;
    private static PreparedStatement psDelete;

    public static void clear() {
        try {
            connect();
            statement.executeUpdate("DROP TABLE users;");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void createTable() {
        try {
            connect();
            statement.executeUpdate("CREATE TABLE users" +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    " Name TEXT NOT NULL," +
                    " Age INTEGER NOT NULL, " +
                    "Email TEXT NOT NULL);");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:jdbckats.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to db");
        }
    }

    public static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void prepareInsert() throws SQLException {
        psInsert = connection.prepareStatement("INSERT INTO users (Name, Age, Email) VALUES (?, ?, ?);");
    }

    private static void prepareDelete() throws SQLException {
        psDelete = connection.prepareStatement("DELETE FROM users WHERE Name = ?");
    }

    public static List<String> createUsers(int count) {
        StringBuilder stringBuilder;
        List<String> users = new ArrayList<>();
        for (int i = 1; i <= count; ++i) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("User").append(i).append(" ");
            stringBuilder.append((i * 10) % 100 + 5).append(" ");
            stringBuilder.append("usermail").append(i).append("@mail.ru");
            users.add(stringBuilder.toString());
        }

        return users;
    }

    public static void addList(String users1) {
        addToTable(new ArrayList<>(Arrays.asList(users1)));
    }

    public static void addToTable(List<String> users){
        try {
            connect();
            prepareInsert();
            connection.setAutoCommit(false);
            for (String users1 : users) {
                String[] data = users1.split("\\s");
                psInsert.setString(1, data[0]);
                psInsert.setInt(2, Integer.parseInt(data[1]));
                psInsert.setString(3, data[2]);
                psInsert.executeUpdate();
            }
            connection.setAutoCommit(true);
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            disconnect();
        }
    }
    public static void getFullTable() throws SQLException {
        connect();
        try (ResultSet rs = statement.executeQuery("SELECT * FROM users;")) {
            while (rs.next()) {
                System.out.println(rs.getString("Name") + " "+ rs.getString("Age") + " " + rs.getString("Email"));
            }
        }
    }
    public static void getUsersByAge(int min, int max) throws SQLException {
        connect();

        try (ResultSet rs = statement.executeQuery(String.format("SELECT * FROM users WHERE (Age > %d) AND (Age < %d);", min, max))) {
            while (rs.next()) {
                System.out.println(rs.getString("Name") + " "+ rs.getString("Age") + " " + rs.getString("Email"));
            }
        }
    }

}
