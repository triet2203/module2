package ss16_IO_text_file.file_csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileCSV {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("src/ss16_IO_text_file/file_csv/input.csv");
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            String line;
            String[] data;
            String code;
            String name;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");

                int id = Integer.parseInt(data[0]);
                code = data[1].replaceAll("\"","");
                name = data[2].replaceAll("\"","");

                System.out.println("ID: " + id + ", Code: " + code + ", Name: " + name);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Không đọc được dữ liệu");
        }
    }
}
