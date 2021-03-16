public class Lab7 {
    public static void main(String[] args) {
        int nx=Integer.parseInt(args[0]);
        int ny=Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);
        Labirynt l = new Labirynt(nx,ny,p);
    }
}
