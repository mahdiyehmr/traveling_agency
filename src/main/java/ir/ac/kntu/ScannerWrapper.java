package ir.ac.kntu;

import java.util.Scanner;

public class ScannerWrapper {

    private static ScannerWrapper instance = new ScannerWrapper();
    private static Scanner scanner;

    private ScannerWrapper() {
        scanner = new Scanner(System.in);
    }

    public static ScannerWrapper getInstance() {
        return instance;
    }

    public static String next() {
        return scanner.next();
    }

    public static Double nextDouble() {
        return scanner.nextDouble();
    }

    public static Integer nextInt() {
        return scanner.nextInt();
    }
    public static String  nextLine() {
        return scanner.nextLine();
    }
    public static long nextLong(){
        return scanner.nextLong();
    }
    public static void close() {
        scanner.close();
    }
}