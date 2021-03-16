import java.util.stream.Stream;

public enum Option {
    RESET('r',"Restart gry",null),
    LEFT('a',"Przesun w lewo",Direction.LEFT),
    RIGHT('d',"Przesun w prawo",Direction.RIGHT),
    UP('w',"Przesun w gore",Direction.UP),
    DOWN('s',"Przesun w dol",Direction.DOWN),
    EXIT('q',"Koniec gry",null);

    private char option;
    private String opis;
    private Direction kierunek;

    Option(char option,String opis, Direction kierunek){
        this.option=option;
        this.opis=opis;
        this.kierunek=kierunek;
    }

    public char getOption() {
        return option;
    }

    public String getOpis() {
        return opis;
    }

    public Direction getKierunek() {
        return kierunek;
    }

    @Override
    public String toString() {
        return "'" + option + "' ==> opcja " + super.toString() + ", opis: " + opis;
    }


}

