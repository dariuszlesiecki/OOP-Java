import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nx;

        while(true){

            System.out.println("Podaj liczbe calkowita wieksza od 1:");
            try {
                nx = sc.nextInt();
                if(nx < 2) throw new IllegalArgumentException("BLAD: Zbyt mala wartosc nx: "+Integer.toString(nx)+"!");
                break;
            }
            catch(InputMismatchException e){
                System.out.println("BLAD: Podaj liczbe calkowita!");
                sc.nextLine();
            }
            catch (IllegalArgumentException e){
                System.out.println( e.getMessage());
                sc.nextLine();
            }
        }
        double p = 0.3;
        Labirynt l = new Labirynt(nx,nx,p);
        sc.close();
    }
}
