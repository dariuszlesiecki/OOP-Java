public class MultiplyWithThreads extends Thread {
    private Matrix A;
    private Matrix B;
    private Matrix C;
    private int i,j;

    MultiplyWithThreads(Matrix C, Matrix A, Matrix B, int i, int j){
        this.A=A;
        this.B=B;
        this.C=C;
        this.i=i;
        this.j=j;
    }

    public void run(){
        try{
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running");

            int M= A.getM();
            int P= B.getN();

            var a=A.getMatrix();
            var b=B.getMatrix();
            var c = C.getMatrix();

                if (M != P) throw new IllegalArgumentException("wrong matrix sizes");
                double result=0;
                for(int k=0; k<M; k++){
                    result+= a[i][k]*b[k][j];
                }
                c[i][j]=result;
        }
        catch (Exception e){

        }
    }
}
