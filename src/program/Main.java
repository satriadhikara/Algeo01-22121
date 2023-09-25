package program;

import java.util.Scanner;

import program.ADT.Matrix;
import program.ADT.IO.*;
import program.SPL.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static InputTerminal input = new InputTerminal();

    public static void main(String[] args) {
        Menu.MenuUtama();
        int pilihan;
        pilihan = scan.nextInt();
        switch (pilihan) {
            case 1:
                Menu.SubMenu("SPL");
                pilihan = scan.nextInt();
                Matrix m;
                m = InputTerminal.SPL();
                switch (pilihan) {
                    case 1:
                        Gauss.Solusi(m);
                        break;
                    case 2:
                        Gauss_Jordan.Solusi(m);
                        break;
                }
                break;
            case 2:
                break;
            case 3:
                Menu.SubMenu("Balikan");
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                System.exit(0);
                break;
        }

    }
}
