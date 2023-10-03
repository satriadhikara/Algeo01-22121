package program.ADT.IO;

import java.util.Scanner;

import program.ADT.Matrix;

public class Terminal {
    public static Scanner scan = new Scanner(System.in);

    public static Matrix Augmented() {
        System.out.println("Silahkan input matrix augmented");
        System.out.println("      //Contoh");
        System.out.println("2 3   //n x m Matriks");
        System.out.println("1 2 5");
        System.out.println("3 4 5");
        System.out.println("-------------------------------");

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
        System.out.println("Silahkan input matrix");
        System.out.println("    //Contoh");
        System.out.println("2   //n x n Matriks");
        System.out.println("1 2");
        System.out.println("3 4");
        System.out.println("--------------------");

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
        System.out.println("Silahkan input titik");
        System.out.println("      //Contoh");
        System.out.println("2     //dua titik (x,y)");
        System.out.println("8 2.07");
        System.out.println("9 2.19");
        System.out.println("8.3   // x taksiran");
        System.out.println("--------------------");
        int n;
        n = scan.nextInt();
        Matrix m = Matrix.createMatrix(n + 1, 2);
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < 2; j++) {
                double temp = scan.nextDouble();
                m.elmt[i][j] = temp;
            }
        }
        m.elmt[i][0] = scan.nextDouble();
        return m;
    }
}