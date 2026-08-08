package CML;

public class Matrix {
    private final int row;
    private final int col;
    private double[][] matrixData;
    private final boolean isSquare;

    //To do:
    //set value
    //multiplication methods (arith & linear)
    //division methods
    //transpose
    //rotate
    //flip
    //isInvertable

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrixData = new double[row][col];
        this.isSquare = row == col;
    }
    public Matrix(int size) {
        this.row = size;
        this.col = size;
        this.matrixData = new double[size][size];
        this.isSquare = true;
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

    public Matrix sub(Matrix b){
        Matrix nm = new Matrix(this.row, this.col);
        if (this.row != b.row || this.col != b.col){
            throw new IllegalArgumentException("Matrix dimensions are not equal");
        }
        else{
            for (int i = 0; i < this.row; i++){
                for (int j = 0; j < this.col; j++){
                    nm.matrixData[i][j] = this.matrixData[i][j] - b.matrixData[i][j];
                }
            }
        }
        return nm;
    }
    public static Matrix sub(Matrix a, Matrix b){
        Matrix nm = new Matrix(this.row, this.col);
        if (a.row != b.row || a.col != b.col){
            throw new IllegalArgumentException("Matrix dimensions are not equal");
        }
        else{
            for (int i = 0; i < a.row; i++){
                for (int j = 0; j < a.col; j++){
                    nm.matrixData[i][j] = a.matrixData[i][j] - b.matrixData[i][j];
                }
            }
        }
        return nm;
    }

    //static addition/subtraction methods for adding matrices in place, saving space and not preserving
    //original matrix
    public void staticadd(Matrix b){
        if (this.row != b.row || this.col != b.col){
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

    public void staticsub(Matrix b){
        if (this.row != b.row || this.col != b.col){
            throw new IllegalArgumentException("Matrix dimensions are not equal");
        }
        else{
            for(int i = 0; i < this.row; i++){
                for(int j = 0; j < this.col; j++){
                    this.matrixData[i][j] -= b.matrixData[i][j];
                } 
            }
        }
    }
    public static void staticsub(Matrix a, Matrix b){
        if (a.row != b.row || a.col != b.col){
            throw new IllegalArgumentException("Matrix dimensions are not equal");
        }
        else{
            for(int i = 0; i < a.row; i++){
                for(int j = 0; j < a.col; j++){
                    a.matrixData[i][j] -= b.matrixData[i][j];
                } 
            }
        }
    }

    public void set(int x, int y, int value){
        this.matrixData[x][y] = value;
    }
    public double get(int x, int y){
        return this.matrixData[x][y];
    }

    public void clear(){
        this.matrixData = new double[this.row][this.col];
    }

        //]Determinant calculator using Laplacian Expansion
        public static double determinant(Matrix m){
            //Sets base cases. Will return singular value for a matrix of size 1, and will return
            // ad-bc for matrix of size 2
            if(m.row == 1 && m.col == 1) return (double) m.matrixData[0][0];
            if(m.row == 2 && m.col == 2) return (double) (m.matrixData[0][0] * m.matrixData[1][1]) - (m.matrixData[0][1] * m.matrixData[1][0]);

            //sets total variable, which is the determinant for each submatrix
            double total = 0;
            //sign that flips with each iteration
            double sign = 1;

            //For every variable along first row of the matrix, gets the submatrix from excluding
            //that row and column, then multiplies the value at each step by the determinant
            //of its submatrix and the sign.
            //Flips sign for next iteration
            for(int i = 0; i < m.col; i++){
                Matrix sub = submatrix(m, 0, i, m.row);
                total += (sign * m.matrixData[0][i]) * determinant(sub);
                sign = -sign;
            }
            return total;
        }
        private static Matrix submatrix(Matrix m, int r, int c, int n){
            Matrix sub = new Matrix(n-1);
            int p = 0;
            for (int i = 0; i < n; i++){
                if (i == r) continue;
                int q = 0;
                for (int j = 0; j < n; j++){
                    if (j == c) continue;
                    sub.matrixData[p][q] = (m.matrixData[i][j]);
                    q++;
                }
                p++;
            }
            return sub;
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
