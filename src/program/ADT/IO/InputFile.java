package program.ADT.IO;

import java.io.File;
import java.util.Scanner;
import program.ADT.Matrix;

public class InputFile {
    public static Matrix InputFileTxt() {
        try {
            Matrix m;
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            String lines = scan.nextLine();
            String[] line = lines.split(" ");
            int row = Integer.parseInt(line[0]);
            int col = Integer.parseInt(line[1]);
            m = new Matrix(row, col);
            for (int i = 0; i < row; i++) {
                lines = scan.nextLine();
                line = lines.split(" ");
                for (int j = 0; j < col; j++) {
                    m.elmt[i][j] = Float.parseFloat(line[i]);
                }
            }
            scan.close();
            return m;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
