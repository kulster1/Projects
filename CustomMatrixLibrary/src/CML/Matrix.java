package CML;

public class Matrix {
    private final int row;
    private final int col;
    private final double[][] matrixData;
    private final boolean isSquare;

    //To do:
    //second constructor
    //addition/subtraction methods
    //multiplication methods (arith & linear)
    //division methods
    //transpose
    //rotate
    //flip
    //determinant calculation
        //determinant calculation is recursive
        //uses helper formula to get submatrices
        //1) return base case 1x1 mat
        //2) return base case 2x2 mat
        //3) make total variable = 0
        //4) make sign variable = 1
        //5) along first row, get submatrix at each step using helper function
        //6) multiple current matrix by the sign then the determinant of 
        //   submatrix (this is where the recursion begins)
        //7) set sign equal to negative sign at each step to flip sign
        //8) return total (double)
        // In helper function:
        //9) Helper function should return matrix of size n-1, n being size of current matrix, so
        //   we initialize new matrix of size n-1
        //   *takes in inputs: current matrix, excluded row number, excluded column number, current matrix size
        //10) runs a nested loop, directly inputting values that are not in excluded row, columns
    //isInvertable

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrixData = new double[row][col];
        this.isSquare = row == col;
    }
    public Matrix(double[]... m) {
        this.row = m.length;
        int colLen = 0;
        for (int i = 0; i < m.length; i++){
            colLen = Math.max(colLen, m[i].length);
        }
        this.col = colLen;
        this.matrixData = m;
        this.isSquare = row == col;
    }

    public Matrix add(Matrix b){
        Matrix nm = new Matrix(this.row, this.col);
        if (this.row != b.row || this.col != b.col){
            throw new IllegalArgumentException("Matrix dimensions are not equal");
        }
        else{
            for (int i = 0; i < this.row; i++){
                for (int j = 0; j < this.col; j++){
                    nm.matrixData[i][j] = this.matrixData[i][j] + b.matrixData[i][j];
                }
            }
        }
        return nm;
    }
    public static Matrix add(Matrix a, Matrix b){
        Matrix nm = new Matrix(this.row, this.col);
        if (a.row != b.row || a.col != b.col){
            throw new IllegalArgumentException("Matrix dimensions are not equal");
        }
        else{
            for (int i = 0; i < a.row; i++){
                for (int j = 0; j < a.col; j++){
                    nm.matrixData[i][j] = a.matrixData[i][j] + b.matrixData[i][j];
                }
            }
        }
        return nm;
    }

    //static addition methods for adding matrices in place, saving space and not preserving
    //original matrix
    public void staticadd(Matrix b){
        if (this.row != this.row || this.col != this.col){
            throw new IllegalArgumentException("Matrix dimensions are not equal");
        }
        else{
            for(int i = 0; i < this.row; i++){
                for(int j = 0; j < this.col; j++){
                    this.matrixData[i][j] += b.matrixData[i][j];
                } 
            }
        }
    }
    public static void staticadd(Matrix a, Matrix b){
        if (a.row != b.row || a.col != b.col){
            throw new IllegalArgumentException("Matrix dimensions are not equal");
        }
        else{
            for(int i = 0; i < a.row; i++){
                for(int j = 0; j < a.col; j++){
                    a.matrixData[i][j] += b.matrixData[i][j];
                } 
            }
        }
    }

    public String toString() {
        StringBuilder b = new StringBuilder();

        for(int i = 0; i < row; i++){
            b.append("[");
            for(int j = 0; j < col; j++){
                b.append(" " + matrixData[i][j] + " ");
            }
            b.append("]");
            b.append("\n");
        }

        return b.toString();
    }
}
