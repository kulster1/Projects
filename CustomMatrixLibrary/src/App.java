import CML.*;

class main {
public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Matrix a = new Matrix(4, 4);
        double[][] e = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        double[][] f = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        double[][] g = {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        Matrix b = new Matrix(e);
        Matrix c = new Matrix(f);
        Matrix d = new Matrix(g);

        System.out.println(a);   
        System.out.println(b); 
        System.out.println(c);
        System.out.println(d);

        System.out.println(b.add(c));

        c.staticadd(d);

        System.out.println(c);

        System.out.println(d);

        System.out.println(Matrix.determinant(d));
    }
}

