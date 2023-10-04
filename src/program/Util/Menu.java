package program.Util;

import java.util.Scanner;

import program.ADT.Matrix;
import program.ADT.IO.*;
import program.ADT.primitives.Determinan;
import program.Interpolasi.*;
import program.SPL.*;

public class Menu {
    public static Scanner scan = new Scanner(System.in);
    public static Terminal input = new Terminal();

    public static int Input() {
        Settings.clearScreen();
        System.out.println("-----Menu Pilihan Input-----");
        System.out.println("1. Input File (.txt)");
        System.out.println("2. Input terminal (keyboard)");
        int pilihan;
        do {
            System.out.print("Pilihan: ");
            pilihan = scan.nextInt();
        } while (pilihan < 1 && pilihan > 2);
        return pilihan;
    }

    public static void MenuUtama() {
        Settings.clearScreen();
        System.out.println("---Menu Kalkulator Matrix---");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Interpolasi Bicubic Spline");
        System.out.println("6. Regresi linier berganda");
        System.out.println("7. Keluar");
        int pilihan;
        do {
            System.out.print("Pilihan: ");
            pilihan = scan.nextInt();
            switch (pilihan) {
                case 1:
                    SubMenu("SPL");
                    break;
                case 2:
                    SubMenu("Determinan");
                    break;
                case 3:
                    SubMenu("Balikan");
                    break;
                case 4:
                    SubMenu("Interpolasi");
                    break;
                case 5:
                    SubMenu("Bicubic");
                    break;
                case 6:
                    SubMenu("Regresi");
                    break;
                case 7:
                    System.out.println("Keluar dari program...");
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihan > 7 || pilihan < 1);
    }

    public static void SubMenu(String menu) {
        int pilihan;
        Matrix m;
        Settings.clearScreen();
        switch (menu) {
            case "SPL":
                System.out.println("---Menu SPL Matrix---");
                System.out.println("1. Metode eliminasi Gauss");
                System.out.println("2. Metode eliminasi Gauss-Jordan");
                System.out.println("3. Metode matriks balikan");
                System.out.println("4. Kaidah cramer");
                System.out.println("5. Kembali");
                do {
                    System.out.print("Pilihan: ");
                    pilihan = scan.nextInt();
                    int pil;
                    switch (pilihan) {
                        case 1:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Augmented();
                            } else {
                                m = Terminal.Augmented();
                            }
                            Gauss.Solusi(m);
                            scan.nextLine();
                            Back();
                            break;
                        case 2:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Augmented();
                            } else {
                                m = Terminal.Augmented();
                            }
                            Gauss_Jordan.Solusi(m);
                            scan.nextLine();
                            Back();
                            break;
                        case 3:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Augmented();
                            } else {
                                m = Terminal.Augmented();
                            }
                            m = Invers.Solusi(m);
                            Output.displayMatrix(m);
                            scan.nextLine();
                            Back();
                            break;
                        case 4:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Augmented();
                            } else {
                                m = Terminal.Augmented();
                            }
                            Cramer.Solusi(m);
                            scan.nextLine();
                            Back();
                            break;
                        case 5:
                            System.out.println("Kembali ke Menu Utama...");
                            MenuUtama();
                            break;
                        default:
                            System.out.println("Pilihan tidak valid!");
                            break;
                    }
                } while (pilihan > 5 || pilihan < 1);
                break;
            case "Determinan":
                System.out.println("---Menu Determinan Matrix---");
                System.out.println("1. Metode OBE Perkalian diagonal");
                System.out.println("2. Metode Ekspansi Kofaktor");
                System.out.println("3. Kembali");
                do {
                    System.out.print("Pilihan: ");
                    pilihan = scan.nextInt();
                    int pil;
                    switch (pilihan) {
                        case 1:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Square();
                            } else {
                                m = Terminal.Square();
                            }
                            Settings.clearScreen();
                            System.out.println("---Determinan Matrix---");
                            Determinan.Solusi(m, 1);
                            scan.nextLine();
                            Back();
                            break;
                        case 2:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Square();
                            } else {
                                m = Terminal.Square();
                            }
                            Settings.clearScreen();
                            System.out.println("---Determinan Matrix---");
                            Determinan.Solusi(m, 2);
                            scan.nextLine();
                            Back();
                            break;
                        case 3:
                            System.out.println("Kembali ke Menu Utama...");
                            MenuUtama();
                            break;
                        default:
                            System.out.println("Pilihan tidak valid!");
                            break;
                    }
                } while (pilihan > 3 || pilihan < 1);
                break;
            case "Balikan":
                System.out.println("---Menu Matrix Balikan---");
                System.out.println("1. Metode OBE Gauss-Jordan Identitas");
                System.out.println("2. Metode 1/det * Adj");
                System.out.println("3. Kembali");
                do {
                    System.out.print("Pilihan: ");
                    pilihan = scan.nextInt();
                    int pil;
                    switch (pilihan) {
                        case 1:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Square();
                            } else {
                                m = Terminal.Square();
                            }
                            Settings.clearScreen();
                            System.out.println("---Matrix Balikan---");
                            Invers.Output(m, 1);
                            scan.nextLine();
                            Back();
                            break;
                        case 2:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Square();
                            } else {
                                m = Terminal.Square();
                            }
                            Settings.clearScreen();
                            System.out.println("---Matrix Balikan---");
                            Invers.Output(m, 2);
                            scan.nextLine();
                            Back();
                            break;
                        case 3:
                            System.out.println("Kembali ke Menu Utama...");
                            MenuUtama();
                            break;
                        default:
                            System.out.println("Pilihan tidak valid!");
                            break;
                    }
                } while (pilihan > 3 || pilihan < 1);
                break;
            case "Interpolasi":
                int pilInput = Input();
                Settings.clearScreen();
                System.out.println("---Polinom Interpolasi---");
                if (pilInput == 1) {
                    m = FileTXT.Interpolasi();
                } else {
                    m = Terminal.Interpolasi();
                }
                Polinom.Solusi(m);
                scan.nextLine();
                Back();
                break;
            case "Bicubic":
                pilInput = Input();
                Settings.clearScreen();
                System.out.println("---Bikubik Spline Interpolasi---");
                if (pilInput == 1) {
                    m = FileTXT.Bicubic();
                } else {
                    m = Terminal.Bicubic();
                }
                System.out.println();
                String output = "f(" + m.elmt[m.row - 1][0] + "," + m.elmt[m.row - 1][1] + ") = "
                        + Bicubic.bicubic(m, m.elmt[m.row - 1][0], m.elmt[m.row - 1][1]);
                System.out.println("f(" + m.elmt[m.row - 1][0] + "," + m.elmt[m.row - 1][1] + ") = "
                        + Bicubic.bicubic(m, m.elmt[m.row - 1][0], m.elmt[m.row - 1][1]));
                System.out.println();
                Output.Save(output);
                scan.nextLine();
                Back();
                break;
            case "Regresi":
                Settings.clearScreen();
                System.out.println("---Regresi Linier---");
                m = Terminal.Regresi();
                Regresi.Solusi(m);
                scan.nextLine();
                Back();
                break;
        }
    }

    public static void Back() {
        System.out.println("\n");
        System.out.println("Ketik enter untuk kembali ke menu.");
        String pil = scan.nextLine();
        System.out.println(pil);
        MenuUtama();
    }
}
