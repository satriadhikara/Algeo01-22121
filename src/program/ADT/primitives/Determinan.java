package program.ADT.primitives;

import program.ADT.Matrix;
import program.ADT.IO.Output;

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
            Matrix mFac = Matrix.createMatrix(m.row - 1, m.row - 1); //Mmebuat matrix Cofactor
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
        int i, j, k;
        double konstanta; // konstanta pembuat 0
        for (i = 0; i < m.row; i++) {
            for (j = i + 1; j < m.row; j++) {
                if (m.elmt[i][i] == 0) {
                    return 0; //Jika ada 0 pada diagonal utama, maka determinan suah pasti 0
                } else {
                    konstanta = m.elmt[j][i] / m.elmt[i][i];
                    for (k = 0; k < m.row; k++) {
                        m.elmt[j][k] -= m.elmt[i][k] * konstanta; //Melakukan eliminasi jumlah supaya habis
                    }
                }
            }
        }

        double det = 0;
        if (m.CountElmt() > 4) {
            det = 1;
            for (int x = 0; x < m.row; x++) {
                det *= m.elmt[x][x];
            }
        } else if (m.CountElmt() == 4) {
            det = (m.elmt[0][0] * m.elmt[1][1]) - (m.elmt[1][0] * m.elmt[0][1]);
        } else if (m.CountElmt() == 1) {
            det = m.elmt[0][0];
        }

        if (det == -0) {
            det = 0;
        }
        return det;
    }

    public static void Solusi(Matrix m, int metode) { //Fungsi untuk menghasilkan output solusi
        double det;
        if (metode == 2) {
            det = DeterminanCofactor(m);
        } else {
            det = DeterminanOBE(m);
        }
        System.out.println();
        String output = "";
        System.out.println("Det: " + det);
        output += ("Det: " + String.valueOf(det));
        Output.Save(output);
    }
}
