package program.Interpolasi;

import program.ADT.Matrix;
import program.ADT.IO.Output;
import program.ADT.primitives.OperasiAritmatika;
import program.ADT.primitives.OperasiIdentitas;
import program.SPL.Gauss;

public class Regresi {

    public static Matrix Fungsi(Matrix m) {
        int i, j;
        Matrix m1 = OperasiIdentitas.Transpose(m);
        Matrix mfuc = Matrix.createMatrix(m.col, m.col + 1);
        for (i = 0; i < mfuc.row; i++) {
            for (j = 0; j < mfuc.col; j++) {
                if (i == 0) {
                    if (j == 0) {
                        mfuc.elmt[i][j] = m.row - 1;
                    } else {
                        mfuc.elmt[i][j] = OperasiAritmatika.sigmaRow(m1, m.row, i, j);
                    }

                } else {
                    if (j == 0) {
                        mfuc.elmt[i][j] = mfuc.elmt[j][i];
                    } else {
                        mfuc.elmt[i][j] = OperasiAritmatika.sigmaRow(m1, m.row, i, j);
                    }
                }
            }
        }
        Output.displayMatrix(mfuc);
        return mfuc;
    }

    public static void Solusi(Matrix m) {
        Matrix mb = Fungsi(m);
        Gauss.OBE(mb);
        mb = Gauss.X(mb);
        String output = "f(x) = ";
        System.out.print("f(x) = ");
        for (int i = 0; i <= mb.col - 1; i++) {
            if (i == mb.col - 1) {
                output += String.format("%.4f", mb.elmt[0][i]) + "x" + i + ", ";
                System.out.print(String.format("%.4f", mb.elmt[0][i]) + "x" + i + ", ");
            } else if (i != 0) {
                output += String.format("%.4f", mb.elmt[0][i]) + "x" + i + " + ";
                System.out.print(String.format("%.4f", mb.elmt[0][i]) + "x" + i + " + ");
            } else {
                output += String.format("%.4f", mb.elmt[0][i]) + " + ";
                System.out.print(String.format("%.4f", mb.elmt[0][i]) + " + ");
            }
        }
        double sum = 0;
        int j;
        for (j = 0; j < m.col - 1; j++) {
            if (j == 0) {
                sum += mb.elmt[0][j];
            } else {
                sum += mb.elmt[0][j] * m.elmt[m.row - 1][j];
            }
        }
        int l;
        output += " f(";
        System.out.print(" f(");
        for (l = 0; l < m.col - 1; l++) {
            if (l != m.col - 2) {
                output += m.elmt[m.row - 1][l] + ",";
                System.out.print(m.elmt[m.row -1][l] + ",");
            } else {
                output += m.elmt[m.row - 1][l];
                System.out.print(m.elmt[m.row -1][l]);
            }
        }
        output += ") = " + String.format("%.4f", sum);
        System.out.print(") = ");
        System.out.print(String.format("%.4f", sum));
        System.out.println();
        Output.Save(output);
    }

}
