package program.SPL;

import program.ADT.Matrix;
import program.ADT.primitives.Determinan;

public class Invers{
    public static Matrix Cofactor(Matrix m){
        int i,j,k,p ;
        Matrix mtemp = Matrix.createMatrix(m.row, m.col);
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
                    mtemp.elmt[j - 1][p] = m.elmt[j][k];
                }
            }
        }

        for (i = 0; i < m.row; i++){
            for (j = 0; j < m.row; j++){
                m.elmt[i][j] = Determinan.DeterminanCofactor(mtemp) ;
            }
        }
        return m ;
    }
}
    