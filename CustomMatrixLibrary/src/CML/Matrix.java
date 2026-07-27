package CML;

public class Matrix {
    private final int row;
    private final int col;
    private final double[][] matrixData;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.matrixData = new double[row][col];
    }

    public String toString() {
        StringBuilder b = new StringBuilder();

        for(int i = 0; i < matrixData.length; i++){
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
