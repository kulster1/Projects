package CML;

public class Matrix {
    private final int row;
    private final int col;
    private final double[][] matrixData;
    private final boolean isSquare;

    //To do:
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
