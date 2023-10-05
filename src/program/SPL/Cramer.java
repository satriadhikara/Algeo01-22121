package program.SPL;

import java.text.DecimalFormat;

import program.ADT.Matrix;
import program.ADT.IO.Output;
import program.ADT.primitives.Determinan;
import program.Util.Settings;

public class Cramer {
    public static Matrix Perhitungan(Matrix m) {
        int i, j;
        Matrix cramer = Matrix.createMatrix(m.row, 1);
        double D = Determinan.DeterminanCofactor(m);
        for (i = 0; i < m.row; i++) {
            Matrix temp = Matrix.createMatrix(m.row, m.row);
            for (j = 0; j < m.row; j++) {
                for (int k = 0; k < m.row; k++) {
                    temp.elmt[j][k] = m.elmt[j][k];
                }
            }
            for (j = 0; j < m.row; j++) {
                temp.elmt[j][i] = m.elmt[j][m.col - 1];
            }
            cramer.elmt[i][0] = Determinan.DeterminanCofactor(temp) / D;
        }
        return cramer;
    }

    public static void Solusi(Matrix m) {
        Settings.clearScreen();
        DecimalFormat df = new DecimalFormat("#.####");
        System.out.println("---Sistem Persamaan Linier dengan Kaidah Cramer---");
        System.out.println();
        String output = "";
        if (m.row != m.col - 1) {
            output += "Jumlah persamaan harus sama dengan jumlah variabel!";
            System.out.println("Jumlah persamaan harus sama dengan jumlah variabel!");
            Output.Save(output);
        }
        else {
            double D = Determinan.DeterminanCofactor(m);
            if (D == 0){
                output += "SPL tidak mempunyai solusi";
                System.out.println("SPL tidak mempunyai solusi");
                System.out.println();
                Output.Save(output);
            }
            else{
                m = Perhitungan(m);
            
                int i;
                for (i = 0; i < m.row; i++) {
                    if (i == m.row - 1) {
                        output += "x" + (i + 1) + ": " + df.format(m.elmt[i][0]);
                        System.out.print("x" + (i + 1) + ": " + df.format(m.elmt[i][0]));
                    } else {
                        output += "x" + (i + 1) + ": " + df.format(m.elmt[i][0]) + ", ";
                        System.out.print("x" + (i + 1) + ": " + df.format(m.elmt[i][0]) + ", ");
                    }
                }
                System.out.println();
                Output.Save(output);
            }
        }
        
        
    }

}
