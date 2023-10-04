package program.ADT.primitives;

import program.ADT.Matrix;

public class OperasiIdentitas {
    public static boolean IsNol(Matrix m, int idx) {
        for (int i = 0; i < m.col; i++) {
            if (m.elmt[idx][i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static Matrix Transpose(Matrix m) {
        Matrix m1;
        int i, j;
        m1 = Matrix.createMatrix(m.col, m.row);
        for (i = 0; i < m.col; i++) {
            for (j = 0; j < m.row; j++) {
                m1.elmt[i][j] = m.elmt[j][i];
            }
        }
        return m1;
    }

    public static Matrix TukerRow(Matrix m, int x, int y) {
        Matrix mx = Matrix.createMatrix(1, m.col);
        Matrix my = Matrix.createMatrix(1, m.col);
        int i;
        for (i = 0; i < m.col; i++) {
            mx.elmt[0][i] = m.elmt[x][i];
            my.elmt[0][i] = m.elmt[y][i];
        }
        for (i = 0; i < m.col; i++) {
            m.elmt[y][i] = mx.elmt[0][i];
            m.elmt[x][i] = my.elmt[0][i];
        }
        return m;
    }

}