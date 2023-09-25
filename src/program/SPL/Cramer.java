package program.SPL;

import program.ADT.Matrix;
import program.ADT.IO.Output;
import program.ADT.primitives.Determinan;

public class Cramer {
    public static Matrix Perhitungan(Matrix m) {
        int i, j;
        Matrix cramer = Matrix.createMatrix(m.row, 1);
        double D = Determinan.DeterminanCofactor(m);
        for (i = 0; i < m.row; i++) {
            Matrix temp = Matrix.createMatrix(m.row, m.row);
            for (j = 0; j < m.row; j++) {
                for (int k = 0; k < m.row; k++) {
                    temp.elmt[j][k] = m.elmt[j][k];
                }
            }
            for (j = 0; j < m.row; j++) {
                temp.elmt[j][i] = m.elmt[j][m.col - 1];
            }
            cramer.elmt[i][0] = Determinan.DeterminanCofactor(temp) / D;
        }
        return cramer;
    }

    public static void Solusi(Matrix m) {
        m = Perhitungan(m);
        Output.displayMatrix(m);
    }

}
