package program;

import java.util.Scanner;

// import program.ADT.Matrix;
import program.ADT.IO.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static InputTerminal input = new InputTerminal();
    public static Output output = new Output();

    public static void main(String[] args) {
        System.out.println("---Menu Kalkulator SPL Matrix---");
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan (invers)");
        System.out.println("4. Kaidah cramer");

        int pilihan;
        pilihan = scan.nextInt();
        switch (pilihan) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }
}
