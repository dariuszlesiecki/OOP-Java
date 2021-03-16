public class Lab13 {
    public static void main(String[] args) {
        try {
            int N, M, P;
            N = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
            P = Integer.parseInt(args[2]);

            Matrix A = new Matrix(N, M);
            A.fillMatrix();
            Matrix B = new Matrix(M, P);
            B.fillMatrix();

            Matrix C = Matrix.multiply(A, B);

            Matrix C2 = new Matrix(N, P);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < P; j++) {
                    MultiplyWithThreads o = new MultiplyWithThreads(C2, A, B, i, j);
                    o.start();
                    o.join();
                }
            }


            C.print();
            C2.print();

            System.out.println("Matrixes equal? : "+ C.equals(C2));
        }
        catch (IllegalThreadStateException e){
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }
    }
}
