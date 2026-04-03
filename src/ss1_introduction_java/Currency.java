package ss1_introduction_java;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        double exchange = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền (USD): ");
        usd = sc.nextDouble();
        double vndAmount = usd * exchange;
        System.out.println("Giá trị VND là " + vndAmount + " VND");
    }
}
