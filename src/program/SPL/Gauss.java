package program.SPL;

import program.ADT.Matrix;
import program.ADT.IO.Output;

public class Gauss {
    public static Output output = new Output();

    public static void OBE_Gauss(Matrix m) {
        for (int i = 0; i < m.row - 1; i++) {
            if (m.elmt[i][i] != 1) {
                float temp = m.elmt[i][i];
                for (int j = i; j < m.col; j++) {
                    m.elmt[i][j] /= temp;
                }
            }
            for (int j = i + 1; j < m.row; j++) {
                float temp = m.elmt[j][i];
                for (int k = i; k < m.col; k++) {
                    m.elmt[j][k] = m.elmt[j][k] - (temp * m.elmt[i][k]);
                }
            }
        }
    }
}
