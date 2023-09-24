package program.ADT.primitives;

import program.ADT.Matrix;


public class OperasiIdentitas {
    public static boolean IsSquare(Matrix m) {
        if (m.row == m.col){
            return true;
        }else {
            return false ;
        }
    }

    public static boolean IsSymetric(Matrix m) {
        if (m.row != m.col){
            return false;
        }
        int i, j;
        for (i = 0; i < m.row; i++)
        {
            for (j = 0; j < m.col; j++)
            {
                if (m.elmt[i][j] != m.elmt[j][i])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean IsIdentity(Matrix m) {
        if (m.row != m.col){
            return false;
        }
        int i, j;
        for (i = 0; i < m.row; i++)
        {
            for (j = 0; j < m.col; j++)
            {
                if (i == j)
                {
                    if (m.elmt[i][j] != 1)
                    {
                        return false;
                    }
                }
                else
                {
                    if (m.elmt[i][j] != 0)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }


}
