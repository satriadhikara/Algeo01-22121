package program.ADT.primitives;

import program.ADT.Matrix;

public class OperasiRelasional {
    public static void CopyMatrix(Matrix m1, Matrix m2) {
        int i, j;
        m2 = Matrix.createMatrix(m1.row, m1.col);
        m2.row = m1.row;
        m2.col = m1.col;
        for (i = 0; i < m1.row; i++) {
            for (j = 0; j < m1.col; j++) {
                m2.elmt[i][j] = m1.elmt[i][j];
            }
        }
    }
}
