package program.ADT;

public class Matrix {
    public int row;
    public int col;
    public float[][] elmt;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.elmt = new float[row][col];
    }

    public static Matrix create(int row, int col) {
        return new Matrix(row, col);
    }

}