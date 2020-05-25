package ru.geekbrains.java.generics;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Data data = new Data(Paths.get("data.csv"));
        System.out.printf("Чтение из фала data.csv:\n%s\n", data.toString());

        int header = 3;
        int values = 15;
        Data newData = new Data(dataGeneration(header, values));

        newData.write(Paths.get("newData.csv"));
        System.out.printf("Создан массив %d заголовка, %d строк данных\n%s\n", header, values, newData.toString());


    }
    private static List<String> dataGeneration(int headersCount, int valuesCount) {
        List<String> data = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < headersCount; ++i) {
            sb.append("Value ").append(i).append(";");
        }
        sb.append("Value ").append(headersCount);
        data.add(sb.toString());

        for (int i = 1; i < valuesCount + 1; ++i) {
            sb = new StringBuilder();
            for (int j = 1; j < headersCount; ++j) {
                sb.append(i).append(j).append(";");
            }
            sb.append(i).append(headersCount);
            data.add(sb.toString());
        }
        return data;
    }


}






