package program.Interpolasi;

import program.ADT.primitives.OperasiAritmatika;
import program.SPL.Invers;
import program.ADT.Matrix;

public class Bicubic {
    public static double BicubicSpline(Matrix input) {
        Matrix matrix = Matrix.createMatrix(16, 16);
        double a = input.elmt[4][0];
        double b = input.elmt[4][1];

        int idxY = 0, idxX;
        int x, y, i, j;

        while (idxY < 16) {
            for (x = 0; x < 2; x++) {
                idxX = 0;
                for (y = 0; y < 2; y++) {
                    for (i = 0; i < 4; i++) {
                        for (j = 0; j < 4; j++) {
                            if (idxY < 4) {
                                matrix.elmt[idxY][idxX] = Math.pow(x, i) * Math.pow(y, j); // Melakukan operasi
                                                                                           // matematika
                            } else if (idxY < 8) {
                                if (j == 0) {
                                    matrix.elmt[idxY][idxX] = 0;
                                } else {
                                    matrix.elmt[idxY][idxX] = j * Math.pow(x, i) * Math.pow(y, j - 1); // Melakukan
                                                                                                       // operasi
                                                                                                       // matematika
                                }
                            } else if (idxY < 12) {
                                if (i != 0) {
                                    matrix.elmt[idxY][idxX] = i * Math.pow(x, i - 1) * Math.pow(y, j); // Melakukan
                                                                                                       // operasi
                                                                                                       // matematika
                                } else {
                                    matrix.elmt[idxY][idxX] = 0;
                                }
                            } else {
                                if (i == 0 || j == 0) {
                                    matrix.elmt[idxY][idxX] = 0;
                                } else {
                                    matrix.elmt[idxY][idxX] = i * j * Math.pow(x, i - 1) * Math.pow(y, j - 1);
                                }
                            }
                            idxX++;
                        }
                    }
                    idxX = 0;
                    idxY++;
                }
            }
        }
        matrix = Invers.InversA(matrix);
        Matrix nilai = Matrix.createMatrix(16, 1); // Membuat matrix 16 x 16 untuk mencari nilai
        int idx = 0;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                nilai.elmt[idx][0] = input.elmt[i][j]; // Mengisi matrix kosong
                idx++;
            }
        }
        Matrix matrix1 = OperasiAritmatika.Perkalian(matrix, nilai);
        idx = 0;
        double hasil = 0;
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                hasil += (matrix1.elmt[idx][0] * Math.pow(a, j) * Math.pow(b, i));
                idx++;
            }
        }
        return hasil;

    }
}
