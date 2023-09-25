package program.ADT;

public class Matrix {
    // Konstruktor Matrix
    public int row;
    public int col;
    public double[][] elmt;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.elmt = new double[row][col];
    }

    public static Matrix createMatrix(int row, int col) {
        return new Matrix(row, col);
    }

    public int CountElmt() {
        return (this.row * this.col);
    }
}