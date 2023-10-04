package program.SPL;

import program.ADT.Matrix;
import program.ADT.IO.Output;
import program.ADT.primitives.OperasiIdentitas;
import program.Util.Settings;

public class Gauss {
    public static boolean IsNol(Matrix m, int idx) {
        for (int i = 0; i < m.col; i++) {
            if (m.elmt[idx][i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void OBE(Matrix m) {
        int pivot = 0;
        for (int i = 0; i < m.row; i++) {
            if (pivot == m.col - 1) {
                break;
            }
            if (IsNol(m, i) && i != m.row - 1) {
                OperasiIdentitas.TukerRow(m, i, i + 1);
            } else if (m.elmt[i][pivot] == 0 && i != m.row - 1) {
                int temprow = i + 1;
                while (temprow < m.row) {
                    if (m.elmt[temprow][pivot] != 0) {
                        OperasiIdentitas.TukerRow(m, i, temprow);
                        break;
                    }
                    temprow++;
                }
            }
            while (m.elmt[i][pivot] == 0 && pivot < m.col - 1) {
                pivot++;
            }
            if (m.elmt[i][pivot] != 1 && m.elmt[i][pivot] != 0) {
                double temp = m.elmt[i][pivot];
                for (int j = pivot; j < m.col; j++) {
                    m.elmt[i][j] /= temp;
                }
            }
            if (i != m.row - 1) {
                for (int j = i + 1; j < m.row; j++) {
                    double temp = m.elmt[j][pivot];
                    for (int k = pivot; k < m.col; k++) {
                        m.elmt[j][k] = m.elmt[j][k] - (temp * m.elmt[i][k]);
                    }
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
        System.out.println("---Sistem Persamaan Linier dengan Metode Gauss---");
        OBE(m);
        System.out.println();
        String output = "";
        boolean solusiBanyak = true;
        for (int i = 0; i < m.col; i++) {
            if (m.elmt[m.row - 1][i] != 0) {
                solusiBanyak = false;
                break;
            }
        }
        if (!solusiBanyak) {
            if (m.elmt[m.row - 1][m.col - 2] == 0) {
                output += "SPL tidak mempunyai solusi";
                System.out.println("SPL tidak mempunyai solusi");
            } else {
                Matrix mx = X(m);
                for (int i = 0; i < mx.col; i++) {
                    if (i == mx.col - 1) {
                        output += "x" + (i + 1) + ": " + String.format("%.4f", mx.elmt[0][i]);
                        System.out.print("x" + (i + 1) + ": " + String.format("%.4f", mx.elmt[0][i]));
                    } else {
                        output += "x" + (i + 1) + ": " + String.format("%.4f", mx.elmt[0][i]) + ", ";
                        System.out.print("x" + (i + 1) + ": " + String.format("%.4f", mx.elmt[0][i]) + ", ");
                    }
                }
            }
        } else {
            output += "SPL mempunyai banyak solusi";
            System.out.println("SPL mempunyai banyak solusi");

        }
        System.out.println();
        Output.Save(output);
    }
}
