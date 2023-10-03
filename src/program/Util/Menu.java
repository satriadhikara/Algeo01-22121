package program.Util;

import java.util.Scanner;

import program.ADT.Matrix;
import program.ADT.IO.*;
import program.ADT.primitives.Determinan;
import program.ADT.primitives.OperasiIdentitas;
import program.Interpolasi.Bicubic;
import program.Interpolasi.Polinom;
import program.Interpolasi.Regresi;
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
                    Menu.SubMenu("SPL");
                    break;
                case 2:
                    SubMenu("Determinan");
                    break;
                case 3:
                    Menu.SubMenu("Balikan");
                    break;
                case 4:
                    Menu.SubMenu("Interpolasi");
                    break;
                case 5:
                    Menu.SubMenu("Bicubic");
                    break;
                case 6:
                    Matrix m = InputTerminal.Regresi() ;
                    Regresi.Solusi(m) ;
                    break;
                case 7:
                    System.out.println("Keluar dari program...");
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
                            break;
                        case 2:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Augmented();
                            } else {
                                m = Terminal.Augmented();
                            }
                            Gauss_Jordan.Solusi(m);
                            break;
                        case 3:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Augmented();
                            } else {
                                m = Terminal.Augmented();
                            }
                            m = Invers.Solusi(m);
                            break;
                        case 4:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Augmented();
                            } else {
                                m = Terminal.Augmented();
                            }
                            Cramer.Solusi(m);
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
                            System.out.println(Determinan.DeterminanOBE(m));
                            break;
                        case 2:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Square();
                            } else {
                                m = Terminal.Square();
                            }
                            System.out.println(Determinan.DeterminanCofactor(m));
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
                            break;
                        case 2:
                            pil = Input();
                            if (pil == 1) {
                                m = FileTXT.Square();
                            } else {
                                m = Terminal.Square();
                            }
                            m = Invers.InversB(m);
                            Output.displayMatrix(m);
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
                break;
            case "Bicubic":
                Settings.clearScreen();
                System.out.println("---Bikubik Spline Interpolasi---");
                m = Terminal.Interpolasi();
                Bicubic.Solusi(m);
                break;
                
            

        }
    }
}
