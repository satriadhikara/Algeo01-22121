package program.constructors;

import java.util.Scanner;

import program.ADT.Matrix;

public class InputTerminal {
    public static Scanner scan = new Scanner(System.in);

    public static Matrix createMatrix() {
        int row, col;

        row = scan.nextInt();
        col = scan.nextInt();
        Matrix m = Matrix.create(row, col);

        int i, j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.println("Elemen Matriks [" + i + "][" + j + "]");
                float temp = scan.nextFloat();
                m.elmt[i][j] = temp;
                scan.nextLine();
            }
        }
        return m;
    }
}