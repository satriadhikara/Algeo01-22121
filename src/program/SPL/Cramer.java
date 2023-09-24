package program.SPL;

import program.SPL.Gauss;
import program.ADT.Matrix;

public class Cramer {
    public static int Penjumlahan(Matrix m) {
        int i, j;
        for (i = 0; i < m.row; i++) {
            Matrix m1 = Matrix.createMatrix(m.row, m.row);
            for (j = 0; j < m.row; j++) {
                if (j == 0) {
                    m1.elmt[i][j] = m.elmt[i][m.col - 1];
                } else {
                    m1.elmt[i][j] = m.elmt[i][j];
                }
            }
            int det;

        }

    }

}
