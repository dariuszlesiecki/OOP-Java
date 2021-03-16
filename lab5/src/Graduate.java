import java.util.Arrays;

public class Graduate extends Student {
    private final String degree;
    private final int year;

    Graduate(String _degree, String _name, String _surname, int _index,int _year, double g1, double g2, double g3){
        super(_name,_surname,_index,g1,g2,g3);
        degree=_degree;
        year=_year;
    }


    public String toString() {
        return degree+" "+super.toString()+", year of graduation: "+ Integer.toString(year);
    }


    public Man compare(Man ob) {
        return super.compare(ob);
    }

    public double average() {
        return super.average();
    }
}
