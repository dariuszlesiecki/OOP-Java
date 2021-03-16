import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Lab9 {
    public static void main(String[] args){
        try {
            if(args.length==0){
                System.out.println("Nie podano nic do obliczenia!");
                System.exit(0);
            }

            String[] split = splitArgs(args[0]);
            //System.out.println(Arrays.toString(split));

            Class<Math> c = Math.class;

            Object result;
            Object t = new double[1];


            if(split.length==2) {
                Method m = c.getMethod(split[0], double.class);
                double p1=Double.parseDouble(split[1]);
                result = m.invoke(t,p1);
                System.out.println("Wynik: " + result.toString());
            }

            else if(split.length==3) {
                Method m = c.getMethod(split[0], double.class,double.class);
                double p1=Double.parseDouble(split[1]);
                double p2=Double.parseDouble(split[2]);
                result = m.invoke(t,p1,p2);
                System.out.println("Wynik: " + result.toString());
            }
            else{
                System.out.println("Zla liczba argumentow funkcji! Podaj jedna lub dwie liczby.");
                System.exit(0);
            }
        }
        catch (NoSuchMethodException e){
            System.out.println("Nie ma takiej metody!");
        }
        catch (IllegalArgumentException e){
            System.out.println("Argumenty funkcji musza byc liczbami!");
        }
        catch (InvocationTargetException e){
            System.out.println("InvocationTargetException");
        }
        catch(IllegalAccessException e){
            System.out.println("IllegalAccessException");
        }
        catch (Exception e){
            System.out.println("error");
        }
    }
    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new);
    }
}
