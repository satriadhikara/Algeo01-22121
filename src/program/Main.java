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
                Menu.MenuSPL();
                pilihan = scan.nextInt();
                switch (pilihan) {
                    case 1:
                        Matrix m = InputTerminal.createMatrix();
                        Gauss.OBE_Gauss(m);
                        Output.displayMatrix(m);
                        break;
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }

    }
}
