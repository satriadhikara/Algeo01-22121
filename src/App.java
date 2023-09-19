import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int n, m;
        Scanner masuk = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris: ");
        n = masuk.nextInt();
        System.out.print("Masukkan jumlah kolom: ");
        m = masuk.nextInt();
        float[][] matriks = new float[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("Masukkan matriks baris-" + (i + 1) + " kolom-" + (j + 1) + ": ");
                matriks[i][j] = masuk.nextFloat();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matriks[i][j] + " ");
            }
            System.out.println();
        }
    }
}
