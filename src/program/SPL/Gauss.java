package program.SPL;

import java.text.DecimalFormat;

import program.ADT.Matrix;
import program.ADT.IO.Output;
import program.ADT.primitives.OperasiIdentitas;
import program.Util.Settings;

public class Gauss {
    public static void OBE(Matrix m) {
        int pivot = 0;
        for (int i = 0; i < m.row; i++) {
            if (pivot == m.col - 1) {
                break;
            }
            if (OperasiIdentitas.IsNol(m, i) && i != m.row - 1) {
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
            pivot++;
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
        DecimalFormat df = new DecimalFormat("#.####");
        Settings.clearScreen();
        System.out.println("---Sistem Persamaan Linier dengan Metode Gauss---");
        OBE(m);
        Output.displayMatrix(m);
        System.out.println();
        String output = "";
        boolean solusiBanyak = false, tidakSolusi = true;
        for (int i = 0; i < m.col - 1; i++) {
            if (m.elmt[m.row - 1][i] != 0) {
                tidakSolusi = false;
                break;
            }
        }
        if (m.elmt[m.row - 1][m.col - 1] == 0) {
            tidakSolusi = false;
        }
        for (int i = 0; i < m.row; i++) {
            if (m.elmt[i][i] != 1) {
                solusiBanyak = true;
                break;
            }
        }
        if (m.row != m.col - 1) {
            solusiBanyak = true;
        }
        if (tidakSolusi) {
            output += "SPL tidak mempunyai solusi";
            System.out.println("SPL tidak mempunyai solusi");
            System.out.println();
            Output.Save(output);
        } else if (!solusiBanyak) {
            Matrix mx = X(m);
            for (int i = 0; i < mx.col; i++) {
                if (i == mx.col - 1) {
                    output += "x" + (i + 1) + ": " + df.format(mx.elmt[0][i]);
                    System.out.print("x" + (i + 1) + ": " + df.format(mx.elmt[0][i]));
                } else {
                    output += "x" + (i + 1) + ": " + df.format(mx.elmt[0][i]) + ", ";
                    System.out.print("x" + (i + 1) + ": " + df.format(mx.elmt[0][i]) + ", ");
                }

            }
            System.out.println();
            Output.Save(output);
        } else {
            Parametrik.Solusi(m);
        }

    }
}
