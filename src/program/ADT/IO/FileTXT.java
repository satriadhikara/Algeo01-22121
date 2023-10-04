package program.ADT.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import program.ADT.Matrix;

public class FileTXT {
    public static Matrix Augmented() {
        try {
            int row = 0, col = 0;
            Scanner scan = new Scanner(System.in);
            System.out.print("Masukkan nama file (.txt): ");
            String namaFile = scan.nextLine();
            File file = new File("test\\" + namaFile + ".txt");
            Scanner fileReader = new Scanner(file);
            Scanner tempfile = new Scanner(file);

            // Cari baris dan kolom
            String templines = "";
            while (tempfile.hasNextLine()) {
                templines = tempfile.nextLine();
                row++;
            }
            String[] templine = templines.split(" ");
            col = templine.length;
            tempfile.close();
            Matrix m = Matrix.createMatrix(row, col);
            int i = 0;
            while (fileReader.hasNextLine()) {
                String lines = fileReader.nextLine();
                String[] line = lines.split(" ");
                for (int j = 0; j < m.col; j++) {
                    m.elmt[i][j] = Double.parseDouble(line[j]);
                }
                i++;
            }
            fileReader.close();
            return m;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }

    public static Matrix Square() {
        try {
            int row = 0, col = 0;
            Scanner scan = new Scanner(System.in);
            System.out.print("Masukkan nama file (.txt): ");
            String namaFile = scan.nextLine();
            File file = new File("test\\" + namaFile + ".txt");
            Scanner fileReader = new Scanner(file);
            Scanner tempfile = new Scanner(file);

            // Cari baris dan kolom
            while (tempfile.hasNextLine()) {
                tempfile.nextLine();
                row++;
            }
            tempfile.close();
            col = row;
            Matrix m = Matrix.createMatrix(row, col);
            int i = 0;
            while (fileReader.hasNextLine()) {
                String lines = fileReader.nextLine();
                String[] line = lines.split(" ");
                for (int j = 0; j < m.col; j++) {
                    m.elmt[i][j] = Double.parseDouble(line[j]);
                }
                i++;
            }
            fileReader.close();
            return m;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }

    public static Matrix Interpolasi() {
        try {
            int row = 0, col = 2;
            Scanner scan = new Scanner(System.in);
            System.out.print("Masukkan nama file (.txt): ");
            String namaFile = scan.nextLine();
            File file = new File("test\\" + namaFile + ".txt");
            Scanner fileReader = new Scanner(file);
            Scanner tempfile = new Scanner(file);

            // Cari baris dan kolom
            while (tempfile.hasNextLine()) {
                tempfile.nextLine();
                row++;
            }
            tempfile.close();
            Matrix m = Matrix.createMatrix(row, col);
            int i = 0;
            while (fileReader.hasNextLine()) {
                String lines = fileReader.nextLine();
                String[] line = lines.split(" ");
                if (line.length == 1) {
                    m.elmt[i][0] = Double.parseDouble(line[0]);
                } else {
                    for (int j = 0; j < m.col; j++) {
                        m.elmt[i][j] = Double.parseDouble(line[j]);
                    }
                }
                i++;
            }
            fileReader.close();
            return m;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }
}
