package program.ADT.IO;

import java.util.Scanner;

import program.ADT.Matrix;

public class InputTerminal {
    public static Scanner scan = new Scanner(System.in);

    // PR: Cara passing by references biar pake void bukan fungsi
    public static Matrix createMatrix() {
        int row, col;

        row = scan.nextInt();
        col = scan.nextInt();
        Matrix m = Matrix.createMatrix(row, col);

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