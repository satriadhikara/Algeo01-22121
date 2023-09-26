package program.SPL;

import program.ADT.Matrix;
import program.ADT.primitives.Determinan;
import program.ADT.primitives.OperasiAritmatika;
import program.ADT.primitives.OperasiIdentitas;

public class Invers {
    public static Matrix Cofactor(Matrix m) {
        Matrix mCof = Matrix.createMatrix(m.row, m.col - 1);
        for (int i = 0; i < m.row; i++) {
            for (int j = 0; j < m.row; j++) {
                Matrix mtemp = Matrix.createMatrix(m.row - 1, m.row - 1);
                int p = 0, q = 0;
                for (int k = 0; k < m.row; k++) {
                    for (int l = 0; l < m.row; l++) {
                        if (p == mtemp.row - 1 && q == mtemp.col) {
                            break;
                        } else if (q == mtemp.col) {
                            q = 0;
                            p += 1;
                        }
                        if (k != i && l != j) {
                            mtemp.elmt[p][q] = m.elmt[k][l];
                            q += 1;
                        }
                    }
                }
                double det = Determinan.DeterminanCofactor(mtemp) * Math.pow(-1, (i + j + 1 + 1));
                mCof.elmt[i][j] = det;
            }
        }
        return mCof;
    }

    public static Matrix InversB(Matrix m) {
        Matrix mCof = Invers.Cofactor(m);
        Matrix mInv = OperasiIdentitas.Transpose(mCof);
        double det = Determinan.DeterminanCofactor(m);

        int i, j;

        if (det == 0) {
            System.out.println("Matriks tidak memiliki invers");
        }

        for (i = 0; i < mInv.row; i++) {
            for (j = 0; j < mInv.col; j++) {
                mInv.elmt[i][j] /= det;
            }
        }
        return mInv;
    }

    public static Matrix Solusi(Matrix m) {
        int i;
        Matrix mInv = Invers.InversB(m);
        Matrix mSum = Matrix.createMatrix(m.row, 1);
        Matrix mB = Matrix.createMatrix(m.row, 1);
        for (i = 0; i < m.row; i++) {
            mB.elmt[i][0] = m.elmt[i][m.col - 1];
        }
        mSum = OperasiAritmatika.Perkalian(mInv, mB);
        return mSum;

    }
}
