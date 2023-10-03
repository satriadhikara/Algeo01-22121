package program.Interpolasi;

import program.ADT.Matrix;
import program.SPL.Gauss;

import java.lang.Math;

public class Polinom {

    public static Matrix Fungsi(Matrix m) {
        Matrix mfuc = Matrix.createMatrix(m.row - 1, m.row + 1);
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
        Matrix mb = Fungsi(m);
        Gauss.OBE(mb);
        mb = Gauss.X(mb);
        System.out.print("f(x) = ");
        for (int i = mb.col - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(String.format("%.4f", mb.elmt[0][i]) + ", ");
            } else {
                System.out.print(String.format("%.4f", mb.elmt[0][i]) + "x^" + i + " + ");
            }
        }
        double hasil = 0;
        for (int j = 0; j < mb.col; j++) {
            hasil += m.elmt[m.row - 1][0] * mb.elmt[0][j];
        }
        System.out.println(("f(" + (m.elmt[m.row - 1][0]) + ") = " + String.format("%.4f", hasil)));
    }
    
}
