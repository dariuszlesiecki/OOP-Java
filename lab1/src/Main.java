import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        int n=Integer.parseInt(args[0]);
        double rmax=Double.parseDouble(args[1]);
        double r,x,y;
        Random random= new Random();
        try {
            FileWriter fw= new FileWriter("circle.dat");
            for (int i = 0; i < n; i++) {
                x = -rmax + random.nextDouble() * (rmax * 2);
                y = -rmax + random.nextDouble() * (rmax * 2);
                r = Math.sqrt(x * x + y * y);
                System.out.println(x + " " + y);
                fw.write(x + " " + y);
            }
        }catch (IOException e) {
            System.out.println("error");
        }
    }
}
