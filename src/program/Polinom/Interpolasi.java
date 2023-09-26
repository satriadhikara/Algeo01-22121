package program.Polinom;

import program.ADT.Matrix;
import program.SPL.Gauss;

import java.lang.Math;

public class Interpolasi {

    public static Matrix Fungsi(Matrix m) {
        Matrix mfuc = Matrix.createMatrix(m.row, m.row + 1);
        for (int i = 0; i < mfuc.row; i++) {
            for (int j = 0; j < mfuc.col; j++) {
                if (j == 0) {
                    mfuc.elmt[i][j] = 1;
                } else if (j == mfuc.col - 1) {
                    mfuc.elmt[i][j] = m.elmt[i][1];
                } else {
                    mfuc.elmt[i][j] = Math.pow(m.elmt[i][0], j);
                }
            }
        }
        return mfuc;
    }

    public static void Solusi(Matrix m) {
        m = Fungsi(m);
        Gauss.OBE(m);
        m = Gauss.X(m);
        for (int i = m.col - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.println(String.format("%.4f", m.elmt[0][i]));
            } else {
                System.out.print(String.format("%.4f", m.elmt[0][i]) + "x^" + i + " + ");
            }
        }
    }
}
