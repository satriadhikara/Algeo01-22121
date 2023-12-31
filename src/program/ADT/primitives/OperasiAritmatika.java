package program.ADT.primitives;

import program.ADT.Matrix;

public class OperasiAritmatika {
    public static Matrix Penjumlahan(Matrix m1, Matrix m2) {
        int i, j;
        Matrix m = Matrix.createMatrix(m1.row, m1.col);
        for (i = 0; i < m1.row; i++) {
            for (j = 0; j < m1.col; j++) {
                m.elmt[i][j] = m1.elmt[i][j] + m2.elmt[i][j];
            }
        }
        return m;
    }

    public static Matrix Pengurangan(Matrix m1, Matrix m2) {
        int i, j;
        Matrix m = Matrix.createMatrix(m1.row, m1.col);
        for (i = 0; i < m1.row; i++) {
            for (j = 0; j < m1.col; j++) {
                m.elmt[i][j] = m1.elmt[i][j] - m2.elmt[i][j];
            }
        }
        return m;
    }

    public static Matrix Perkalian(Matrix m1, Matrix m2) {
        int i, j, k;
        Matrix m = Matrix.createMatrix(m1.row, m2.col);
        for (i = 0; i < m1.row; i++) {
            for (j = 0; j < m2.col; j++) {
                m.elmt[i][j] = 0;
                for (k = 0; k < m1.col; k++) {
                    m.elmt[i][j] += m1.elmt[i][k] * m2.elmt[k][j];
                }
            }
        }
        return m;
    }

    public static Matrix Perkaliandenganmod(Matrix m1, Matrix m2, int mod) {
        int i, j, k;
        Matrix m = Matrix.createMatrix(m1.row, m2.col);
        for (i = 0; i < m1.row; i++) {
            for (j = 0; j < m2.col; j++) {
                m.elmt[i][j] = 0;
                for (k = 0; k < m1.col; k++) {
                    m.elmt[i][j] += m1.elmt[i][k] * m2.elmt[k][j];
                    m.elmt[i][j] %= mod;
                }
            }
        }
        return m;
    }

    public static Matrix Perkaliandengankonstanta(Matrix m, int kons) {
        int i, j;
        Matrix m1 = Matrix.createMatrix(m.row, m.col);
        for (i = 0; i < m.row; i++) {
            for (j = 0; j < m.col; j++) {
                m1.elmt[i][j] = m.elmt[i][j] * kons;
            }
        }
        return m;
    }

    public static double sigmaRow(Matrix m, int s, int rowReg, int colReg) {
        double countRow; // Jumlah nilai x di baris
        countRow = 0;
        int i;
        
        for (i = 0; i < s - 1; i++) {
            if (rowReg == 0) {
                countRow += m.elmt[colReg-1][i]; // Mendapatkan sigma x1i
            } else {
                countRow += m.elmt[rowReg-1][i]*m.elmt[colReg-1][i];
            }
            
        }
        return countRow;
    }


    

}
