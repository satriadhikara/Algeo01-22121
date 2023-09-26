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

    public boolean IsSquare() {
        return (this.row == this.col);
    }

    public boolean IsSymetric() {
        if (this.row != this.col) {
            return false;
        }
        int i, j;
        for (i = 0; i < this.row; i++) {
            for (j = 0; j < this.col; j++) {
                if (this.elmt[i][j] != this.elmt[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean IsIdentity() {
        if (this.row != this.col) {
            return false;
        }
        int i, j;
        for (i = 0; i < this.row; i++) {
            for (j = 0; j < this.col; j++) {
                if (i == j) {
                    if (this.elmt[i][j] != 1) {
                        return false;
                    }
                } else {
                    if (this.elmt[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}