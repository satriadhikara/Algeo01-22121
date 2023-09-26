package program.ADT.IO;

import java.util.Scanner;

import program.ADT.Matrix;

public class InputTerminal {
    public static Scanner scan = new Scanner(System.in);

    public static Matrix SPL() {
        int row, col;
        row = scan.nextInt();
        col = scan.nextInt();
        Matrix m = Matrix.createMatrix(row, col);
        int i, j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                double temp = scan.nextDouble();
                m.elmt[i][j] = temp;
            }
        }
        scan.close();
        return m;
    }

    public static Matrix Square() {
        int n;
        n = scan.nextInt();
        Matrix m = Matrix.createMatrix(n, n);
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                double temp = scan.nextDouble();
                m.elmt[i][j] = temp;
            }
        }
        scan.close();
        return m;
    }

    public static Matrix Interpolasi() {
        int n;
        n = scan.nextInt();
        Matrix m = Matrix.createMatrix(n, 2);
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < 2; j++) {
                double temp = scan.nextDouble();
                m.elmt[i][j] = temp;
            }
        }
        return m;
    }
}