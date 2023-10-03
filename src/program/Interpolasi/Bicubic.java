package program.Interpolasi;

public class Bicubic {
    //
    public static double bicubic(double[][] p, double x, double y) {

        double[] arr = new double[4];

        // Proses hitung interpolasi kubik pada setiap baris
        for (int i = 0; i < 4; i++) {

            arr[i] = p[i][1] + 0.5 * x * (p[i][2] - p[i][0] + x * (2.0 * p[i][0] - 5.0 * p[i][1] + 4.0 * p[i][2]
                    - p[i][3] + x * (3.0 * (p[i][1] - p[i][2]) + p[i][3] - p[i][0])));
        }
        return arr[1] + 0.5 * y * (arr[2] - arr[0] + y * (2.0 * arr[0] - 5.0 * arr[1] + 4.0 * arr[2] - arr[3]
                + y * (3.0 * (arr[1] - arr[2]) + arr[3] - arr[0])));

    }
}
