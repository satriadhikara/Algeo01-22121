package program.constructors;

import program.ADT.Matrix;

public class OutputTerminal {
    public static void printMatrix(Matrix m) {
        int i, j;
        for (i = 0; i < m.row; i++) {
            for (j = 0; j < m.col; j++) {
                System.out.print(m.elmt[i][j] + " ");
            }
            System.out.println();
        }
    }
}
