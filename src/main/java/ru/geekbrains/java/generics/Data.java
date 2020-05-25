package ru.geekbrains.java.generics;

import java.nio.file.Path;
import java.util.List;
import java.nio.charset.Charset;
import java.nio.file.Files;


public class Data {
    private String[] header;
    private int[][] data;
    private void getData(List<String> data) throws Exception {

        header = data.get(0).split(";");
        this.data = new int[data.size() - 1][header.length];

        for (int i = 1; i < data.size(); ++i) {
            String[] line = data.get(i).split(";");
            for (int j = 0; j < line.length; ++j) {
                this.data[i - 1][j] = Integer.parseInt(line[j]);
            }
        }
    }
    public Data(List<String> data) {
        try {
            getData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Data(Path path) {
        read(path);
    }
    public void read(Path path) {
        read(path, Charset.defaultCharset());
    }
    public void read(Path path, Charset charset) {
        try {
            getData(Files.readAllLines(path, charset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < header.length; ++i) {
            sb.append(header[i]).append(":\t");
            for (int[] values : data) {
                sb.append(values[i]).append("; ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


