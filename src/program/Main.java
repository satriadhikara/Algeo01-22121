package program;

import java.util.Scanner;
import program.constructors.*;
import program.ADT.Matrix;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static InputTerminal input = new InputTerminal();
    public static OutputTerminal output = new OutputTerminal();

    public static void main(String[] args) {
        Matrix m;
        m = InputTerminal.createMatrix();
        OutputTerminal.printMatrix(m);

    }
}
