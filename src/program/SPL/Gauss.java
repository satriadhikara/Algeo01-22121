package program.SPL;

import program.ADT.Matrix;
import program.ADT.IO.Output;

public class Gauss {
    public static void OBE(Matrix m) {
        for (int i = 0; i < m.row; i++) {
            if (m.elmt[i][i] != 1 && m.elmt[i][i] != 0) {
                double temp = m.elmt[i][i];
                for (int j = i; j < m.col; j++) {
                    m.elmt[i][j] /= temp;
                }
            }
            if (i != m.row - 1) {
                for (int j = i + 1; j < m.row; j++) {
                    double temp = m.elmt[j][i];
                    for (int k = i; k < m.col; k++) {
                        m.elmt[j][k] = m.elmt[j][k] - (temp * m.elmt[i][k]);
                    }
                }
            }
        }
    }

    public static void Solusi(Matrix m) {
        OBE(m);
        Output.displayMatrix(m);
        boolean solusiBanyak = true;
        for (int i = 0; i < m.col; i++) {
            if (m.elmt[m.row - 1][i] != 0) {
                solusiBanyak = false;
                break;
            }
        }
        if (!solusiBanyak) {
            if (m.elmt[m.row - 1][m.col - 2] == 0) {
                System.out.println("SPL tidak mempunyai solusi");
            } else {
                System.out.println("SPL mempunyai solusi unik/tunggal");
            }
        } else {
            System.out.println("SPL mempunyai banyak solusi");
        }
    }
}
