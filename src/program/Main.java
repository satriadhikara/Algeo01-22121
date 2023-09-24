package program;

import java.util.Scanner;

import program.ADT.Matrix;
import program.ADT.IO.*;
import program.SPL.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static InputTerminal input = new InputTerminal();
    public static Output output = new Output();

    public static void main(String[] args) {
        Menu.MenuUtama();
        int pilihan;
        pilihan = scan.nextInt();
        switch (pilihan) {
            case 1:
                Menu.SubMenu("SPL");
                pilihan = scan.nextInt();
                Matrix m;
                switch (pilihan) {
                    case 1:
                        m = InputTerminal.createMatrix();
                        Gauss.OBE_Gauss(m);
                        Output.displayMatrix(m);
                        break;
                    case 2:
                        m = InputTerminal.createMatrix();
                        Gauss.OBE_GaussJordan(m);
                        Output.displayMatrix(m);
                        break;
                }
                break;
            case 2:
                Menu.SubMenu("Determinan");
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
