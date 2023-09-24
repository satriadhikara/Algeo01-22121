package program.SPL;

import program.ADT.Matrix;
import program.ADT.primitives.Determinan;

public class Cramer {
    public static Matrix cramer(Matrix m) {
        int i, j;
        Matrix cramer = Matrix.createMatrix(m.row, 1);
        float D = Determinan.Determinant(m);
        for (i = 0; i < m.row; i++) {
            Matrix m1 = Matrix.createMatrix(m.row, m.row); // Membuat matrix sementara untuk mencari determinan tiap
                                                           // variabel
            for (j = 0; j < m.row; j++) {
                m1.elmt[j][i] = m.elmt[j][m.col - 1];
            }

            cramer.elmt[i][0] = Determinan.Determinant(m1) / D;
        }
        return cramer;

    }

}
