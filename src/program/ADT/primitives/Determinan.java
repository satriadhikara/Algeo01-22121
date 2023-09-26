package program.ADT.primitives;

import program.ADT.Matrix;

public class Determinan {
    public static double DeterminanCofactor(Matrix m) {
        int i, j, k, p, var = 1;

        double det;
        if (m.CountElmt() == 1) {
            det = (double) m.elmt[0][0];
        } else if (m.CountElmt() == 4) {
            det = (m.elmt[0][0] * m.elmt[1][1]) - (m.elmt[1][0] * m.elmt[0][1]);
            det = (double) (det);
        } else {
            Matrix mFac = Matrix.createMatrix(m.row - 1, m.row - 1);
            det = 0;
            for (i = 0; i < m.row; i++) {
                for (j = 1; j < m.row; j++) {
                    for (k = 0; k < m.row; k++) {
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
                det += var * m.elmt[0][i] * DeterminanCofactor(mFac);
                var *= -1;
            }
        }
        return det;
    }

    public static double DeterminanOBE(Matrix m) {
        int x, y, z;
        for (x = 0; x < m.row; x++) {
            if (x != m.row - 1) {
                for (y = x + 1; y < m.row; y++) {
                    double temp = m.elmt[y][x];
                    for (z = x; z < m.col; z++) {
                        m.elmt[y][z] = m.elmt[y][z] - (temp * m.elmt[x][z]);
                    }
                }
            }
        }
        double det = 0;
        if (m.CountElmt() > 4) {
            det = 1;
            for (x = 0; x < m.row; x++) {
                det *= m.elmt[x][x];
            }
        } else if (m.CountElmt() == 4) {
            det = (m.elmt[0][0] * m.elmt[1][1]) - (m.elmt[1][0] * m.elmt[0][1]);
        } else if (m.CountElmt() == 1) {
            det = m.elmt[0][0];
        }
        return det;
    }
}
