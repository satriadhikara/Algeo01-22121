package program.ADT.IO;

import program.ADT.Matrix;

public class Output {
    public static void displayMatrix(Matrix m) {
        int i, j;
        for (i = 0; i < m.row; i++) {
            for (j = 0; j < m.col; j++) {
                System.out.print(m.elmt[i][j] + " ");
            }
            System.out.println();
        }
    }
}
