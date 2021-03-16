import java.util.Objects;
import java.util.Random;

public class Matrix {
    private final int N;
    private final int M;
    private final double[][] matrix;

    Matrix(int N, int M){
        this.N=N;
        this.M=M;
        this.matrix=new double[N][M];
    }

    public void fillMatrix(){
        Random r = new Random();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                matrix[i][j] = 10 * r.nextDouble();
            }
        }
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void print(){
        System.out.println();
        for(int i=0;i<N;i++){
            System.out.print("[ ");
            for(int j=0;j<M;j++){
                System.out.print(Double.toString(matrix[i][j])+" ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public static Matrix multiply(Matrix A, Matrix B){
        int N = A.getN();
        int M= A.getM();
        int P= B.getN();
        int Q= B.getM();

        var a=A.getMatrix();
        var b=B.getMatrix();

        Matrix C = new Matrix(N,Q);
        var c = C.getMatrix();

        try {
            if (M != P) throw new IllegalArgumentException("wrong matrix sizes");

            for(int i=0; i<N; i++){
                for(int j=0; j<Q; j++){
                    double result=0;
                    for(int k=0; k<M; k++){
                        result+= a[i][k]*b[k][j];
                    }
                    c[i][j]=result;
                }
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return C;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;

        if(matrix.getN() != N || matrix.getM()!= M) return false;

        var m = matrix.getMatrix();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(this.matrix[i][j] != m[i][j]) return false;
            }
        }
        return true;
    }


}


