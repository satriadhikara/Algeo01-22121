package program.ADT.primitives;

import program.ADT.Matrix;

public class Determinan {
    public static float Determinant(Matrix m) {
        int i, j, k, p, var = 1;

        float det;
        if (m.CountElmt() == 1) {
            det = (float) m.elmt[0][0];
        } else if (m.CountElmt() == 4) {
            det = (m.elmt[0][0] * m.elmt[1][1]) - (m.elmt[1][0] * m.elmt[0][1]);
            det = (float) (det);
        } else {
            Matrix mFac = Matrix.createMatrix(m.row, m.row);
            det = 0;
            for (i = 0; i < m.row; i++) {
                for (j = 1; j < m.row; j++) {
                    for (k = 0; k < m.col; k++) {
                        if (k == i) {
                            continue;
                        } else if (k < i) {
                            p = k;
                        } else {
                            p = k - 1;
                        }
                        mFac.elmt[j - 1][p] = m.elmt[j][k];
                    }
                }
                det += var * m.elmt[0][i] * Determinant(mFac);
                var *= -1;
            }
        }
        return det;
    }
}
