package program.SPL;

import program.ADT.Matrix;
import program.ADT.IO.Output;
import program.Util.Settings;

public class Gauss_Jordan {
    public static void OBE(Matrix m) {
        Gauss.OBE(m);
        for (int i = m.row - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                double temp = m.elmt[j][i];
                for (int k = i; k < m.col; k++) {
                    m.elmt[j][k] -= (temp * m.elmt[i][k]);
                }
            }
        }
    }

    public static Matrix X(Matrix m) {
        // I.S. Matrix m sudah di OBE
        Matrix mx = Matrix.createMatrix(1, m.row);
        for (int i = m.row - 1; i >= 0; i--) {
            mx.elmt[0][i] = m.elmt[i][m.col - 1];
            for (int j = m.row - 1; j > i; j--) {
                mx.elmt[0][i] -= (mx.elmt[0][j] * m.elmt[i][j]);
            }
        }
        return mx;
    }

    public static void Solusi(Matrix m) {
        Settings.clearScreen();
        System.out.println("Sistem Persamaan Linier dengan Metode Gauss-Jordan");
        Output.displayMatrix(m);
        System.out.println("|");
        System.out.println("|");
        System.out.println("v");
        OBE(m);
        Output.displayMatrix(m);
        System.out.println();
        boolean solusiBanyak = true;
        for (int i = 0; i < m.col; i++) {
            if (m.elmt[m.row - 1][i] != 0) {
                solusiBanyak = false;
                break;
            }
        }
        if (!solusiBanyak) {
            if (m.elmt[m.row - 1][m.col - 2] == 0) {
                System.out.println("SPL tersebut tidak mempunyai solusi");
            } else {
                System.out.println("SPL tersebut mempunyai solusi unik/tunggal yaitu");
                Matrix mx = X(m);
                for (int i = 0; i < mx.col; i++) {
                    if (i == mx.col - 1) {
                        System.out.print("x" + (i + 1) + ": " + mx.elmt[0][i]);
                    } else {
                        System.out.print("x" + (i + 1) + ": " + mx.elmt[0][i] + ", ");
                    }
                }
            }
        } else {
            System.out.println("SPL tersebut mempunyai banyak solusi");
        }
    }
}
