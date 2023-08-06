package util;

import java.util.Scanner;

public class InputUtil {
    public static int inputRequiredInt(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextInt();
    }
    public static long inputRequiredLong(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLong();
    }
    public static String inputRequiredString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLine();
    }
    public static String inputRequiredDate(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.next();
    }
}
