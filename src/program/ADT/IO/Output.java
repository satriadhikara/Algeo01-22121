package program.ADT.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import program.ADT.Matrix;

public class Output {
    public static void displayMatrix(Matrix m) {
        int i, j;
        for (i = 0; i < m.row; i++) {
            for (j = 0; j < m.col; j++) {
                System.out.print(m.elmt[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Save(String s) {
        try {
            System.out.println();
            System.out.print("Apakah ingin disimpan pada file (y/n)? ");
            Scanner scan = new Scanner(System.in);
            String opsi = scan.nextLine();
            if (opsi.equals("y")) {
                System.out.print("Masukkan nama file: ");
                String namaFile = scan.nextLine();
                File file = new File("test\\" + namaFile + ".txt");
                while (file.exists()) {
                    System.out.println("File already exists!");
                    System.out.print("Masukkan nama file: ");
                    namaFile = scan.nextLine();
                    file = new File("test\\" + namaFile + ".txt");
                }
                FileWriter writer = new FileWriter(file);
                writer.write(s);
                writer.close();
                System.out.println("File sukses disimpan!");
            }

        } catch (IOException e) {
            System.out.println("Error ecured!");
        }
    }
}
