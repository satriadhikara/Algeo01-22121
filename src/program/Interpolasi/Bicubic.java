package program.Interpolasi;

import program.ADT.Matrix;

public class Bicubic {
        //
        public static double bicubic(Matrix p, double x, double y) {

                Matrix arr = Matrix.createMatrix(1, 4);

                // Proses hitung interpolasi kubik pada setiap baris
                for (int i = 0; i < 4; i++) {

                        arr.elmt[0][i] = p.elmt[i][1]
                                        + 0.5 * x
                                                        * (p.elmt[i][2] - p.elmt[i][0]
                                                                        + x * (2.0 * p.elmt[i][0] - 5.0 * p.elmt[i][1]
                                                                                        + 4.0 * p.elmt[i][2]
                                                                                        - p.elmt[i][3]
                                                                                        + x * (3.0 * (p.elmt[i][1]
                                                                                                        - p.elmt[i][2])
                                                                                                        + p.elmt[i][3]
                                                                                                        - p.elmt[i][0])));
                }
                return arr.elmt[0][1]
                                + 0.5 * y
                                                * (arr.elmt[0][2] - arr.elmt[0][0]
                                                                + y * (2.0 * arr.elmt[0][0] - 5.0 * arr.elmt[0][1]
                                                                                + 4.0 * arr.elmt[0][2]
                                                                                - arr.elmt[0][3]
                                                                                + y * (3.0 * (arr.elmt[0][1]
                                                                                                - arr.elmt[0][2])
                                                                                                + arr.elmt[0][3]
                                                                                                - arr.elmt[0][0])));

        }
}
