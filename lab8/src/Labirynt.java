import java.lang.invoke.SwitchPoint;
import java.util.Random;
import java.util.Scanner;

public class Labirynt {
    private char[][] board;
    private int nx;
    private int ny;
    private int p;
    private int x;
    private int y;
    private CheckStep check= (char [][] board, int y, int x, Direction dir) ->{
        if( board[y-dir.getY()][x+dir.getX()] == 'X' ) return false;
        else return true;
    };

    Labirynt(int nx, int ny, double p){
        this.nx=nx;
        this.ny=ny;
        this.p= (int)(1.0/p);
        board = new char[ny][nx];

        fillBoard();
        start();
    }

    private void start(){
        System.out.println("Dostępne opcje:");
        for(Option o: Option.values()){
            System.out.println(o.toString());
        }
        print();
        char z;
        Scanner sc = new Scanner(System.in);

        boolean game=true;
        boolean won=false;
        while(game) {
            try {
                System.out.print("\nWybierz opcje: ");
                z = sc.next().charAt(0);
                boolean badOption = true;
                for (Option o : Option.values()) {
                    if (o.getOption() == z) {
                        badOption=false;
                        switch (o) {
                            case RESET:
                                System.out.println("\nRESET GRY");
                                fillBoard();
                                break;
                            case EXIT:
                                System.out.println("\nZAKONCZENIE GRY");
                                game = false;
                                break;
                            default:
                                step(o.getKierunek());
                                break;
                        }

                        if (y == 0 && x == (nx / 2)) {
                            game = false;
                            print();
                            System.out.println("\nGRATULACJE, WYGRALES!");
                        }
                    }
                }
                if(badOption) throw new OptionNotRecognizedException("Nie ma takiej opcji: "+ z +"!");
                if (game) print();
            }
            catch (OptionNotRecognizedException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }



    }

    private void step(Direction dir){
        try {
            if (check.test(board, y, x, dir)) {
                board[y - dir.getY()][x + dir.getX()] = 'o';
                board[y][x] = ' ';
                y = y - dir.getY();
                x = x + dir.getX();
            } else {
                throw new WallException("NIE UDALO SIE WYKONAC TAKIEGO RUCHU");
            }
        }
        catch(WallException e){
            System.out.println(e.getMessage());
        }
    }

    private void fillBoard(){
        for(int i=0; i<ny; ++i){
            for(int j=0; j<nx; ++j){
                board[i][j]=' ';
            }
        }
        for(int i=0; i<nx; ++i){
            board[0][i]='X';
            board[ny-1][i]='X';
        }
        for(int i=0; i<ny; ++i){
            board[i][0]='X';
            board[i][nx-1]='X';
        }
        //board[0][nx/2] = ' ';

        Random rand= new java.util.Random();
        for(int i=1; i<ny-1; ++i){
            for(int j=1; j<nx-1; ++j){
                if(rand.nextInt(p)==0){
                    board[i][j] = 'X';
                }
            }
        }
        board[ny-2][1]='o';
        x=1;
        y=ny-2;
    }
    public void print(){
        System.out.println();
        for(int i=0; i<ny; ++i){
            for(int j=0; j<nx; ++j){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
