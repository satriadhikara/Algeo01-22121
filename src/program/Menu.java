package program;

public class Menu {
    public static void MenuUtama() {
        System.out.println("---Menu Kalkulator Matrix---");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Interpolasi Bicubic Spline");
        System.out.println("6. Regresi linier berganda");
        System.out.println("7. Keluar");
    }

    public static void SubMenu(String menu) {
        switch (menu) {
            case "SPL":
                System.out.println("---Menu SPL Matrix---");
                break;
            case "Determinan":
                System.out.println("---Menu Determinan Matrix---");
                break;
            case "Balikan":
                System.out.println("---Menu Matrix Balikan---");
                break;
        }
        System.out.println("1. Metode eliminasi Gauss");
        System.out.println("2. Metode eliminasi Gauss-Jordan");
        System.out.println("3. Metode matriks balikan");
        System.out.println("4. Kaidah cramer");
        System.out.println("5. Kembali");
    }
}
