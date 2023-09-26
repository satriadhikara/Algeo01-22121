package program.ADT.primitives;

import program.ADT.Matrix;

public class OperasiIdentitas {

    public static Matrix Transpose(Matrix m) {
        Matrix m1;
        int i, j;
        m1 = Matrix.createMatrix(m.row, m.col);
        for (i = 0; i < m.row; i++) {
            for (j = 0; j < m.col; j++) {
                m1.elmt[i][j] = m.elmt[j][i];
            }
        }
        return m1;
    }

}
