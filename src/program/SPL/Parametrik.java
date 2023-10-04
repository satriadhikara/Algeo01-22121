package program.SPL;

import java.util.Arrays;
import program.ADT.Matrix;

public class Parametrik {
    public static void Solusi(Matrix m) {
        int[] arrparam = new int[m.col];
        int satu = 0;
        Arrays.fill(arrparam, 0);
        for (int i = 0; i < m.row; i++) {
            for (int j = 0; j < m.col; j++) {
                if (m.elmt[i][j] == 1) {
                    arrparam[j] = 1;
                    satu++;
                    break;
                }
            }
        }
        String hasilpar = "";
        String[] arrhasilpar = new String[m.col - satu - 1];
        int idxarrhasilpar = 0;
        for (int i = 0; i < m.col - 1; i++) {
            if (arrparam[i] == 0) {
                hasilpar += "x" + (i + 1) + " = " + "x" + (i + 1);
                arrhasilpar[idxarrhasilpar] = hasilpar;
                idxarrhasilpar++;
                hasilpar = "";
            }
        }
        String[] arrhasil = new String[satu + 1 + arrhasilpar.length];
        int idxarrhasil = 0;
        int temp = 0;
        int cek = 0;
        String hasil = "";
        for (int i = m.row - 1; i > -1; i--) {
            for (int j = 0; j < m.col - 1; j++) {
                if (m.elmt[i][j] != 0) {
                    temp++;
                    if (temp == 1) {
                        if (m.elmt[i][j] == 1) {
                            if (m.elmt[i][m.col - 1] != 0) {
                                hasil += "x" + (j + 1) + " = " + String.valueOf(m.elmt[i][m.col - 1]);
                            } else {
                                for (int k = j + 1; k < m.col - 1; k++) {
                                    if (m.elmt[i][k] != 0) {
                                        cek += 1;
                                    }
                                }
                                if (cek != 0) {
                                    hasil += "x" + (j + 1) + " = ";
                                } else {
                                    hasil += "x" + (j + 1) + " = 0";
                                }
                            }
                        } else {
                            if (m.elmt[i][m.col - 1] != 0) {
                                hasil += m.elmt[i][j] + "x" + (j + 1) + " = " + m.elmt[i][m.col - 1];
                            } else {
                                hasil += m.elmt[i][j] + "x" + (j + 1) + " = ";
                            }
                        }
                    } else {
                        if (m.elmt[i][j] < 0) {
                            hasil += " + " + Math.abs(m.elmt[i][j]) + "x" + (j + 1);
                        } else if (m.elmt[i][j] == 1) {
                            hasil += " - " + "x" + (j + 1);
                        } else {
                            hasil += " - " + m.elmt[i][j] + "x" + (j + 1);
                        }
                    }
                }
            }
            temp = 0;
            arrhasil[idxarrhasil] = hasil;
            idxarrhasil++;
            hasil = "";
        }
        for (int i = 0; i < arrhasilpar.length; i++) {
            arrhasil[idxarrhasil] = arrhasilpar[i];
            idxarrhasil++;
        }

        for (int i = 0; i < arrhasil.length; i++) {
            System.out.println(arrhasil[i]);
        }
    }

}
