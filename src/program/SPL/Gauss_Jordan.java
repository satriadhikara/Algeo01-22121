package program.SPL;

import program.ADT.Matrix;
import program.ADT.IO.Output;

public class Gauss_Jordan {
    public static void OBE(Matrix m) {
        Gauss.OBE(m);
        for (int i = 0; i < m.row; i++) {
            for (int j = 0; j < i; j++) {
                for (int k = 0; k < m.col; k++) {
                    m.elmt[j][k] -= (m.elmt[j][k] * m.elmt[i][k]);
                }

            }
        }
    }

    public static void Solusi(Matrix m) {
        OBE(m);
        Output.displayMatrix(m);
    }
}
