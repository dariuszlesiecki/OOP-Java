

public class Main {
    public static void main(String[] args){
        Generate g= new Generate(397,103);
        System.out.println("Entered: "+args[0]);
        g.encrypt(args[0]);
        g.decode();
    }

}
