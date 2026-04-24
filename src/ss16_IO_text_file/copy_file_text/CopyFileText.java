package ss16_IO_text_file.copy_file_text;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file nguồn: ");
        String sourcePath = sc.nextLine();
        System.out.print("Nhập đường dẫn file đích: ");
        String targetPath = sc.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        if (!sourceFile.exists()) {
            System.out.println("File nguồn không tồn tại");
            return;
        }

        if (targetFile.exists()) {
            System.out.println("File đích đã tồn tại");
            return;
        }
        int charCount = 0;
        int charCode;

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {

            while ((charCode = reader.read()) != -1) {
                writer.write(charCode);
                charCount++;
            }
            System.out.println("Sao chép thành công");
            System.out.println("Số ký tự trong file: " + charCount);
        } catch (IOException ex) {
            System.out.println("Không đọc được file");
        }
    }
}


