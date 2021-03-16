public class Dean extends Man{
    private final int year_begin;
    private final int year_end;
    private final String degree;

    Dean(String _degree,String _name, String _surname, int _year_begin, int _year_end){
        super(_name,_surname);
        degree=_degree;
        year_begin=_year_begin;
        year_end=_year_end;
    }


    public String toString() {
        return degree+" "+super.toString()+", Dean of the Faculty from "+ Integer.toString(year_begin) +
                " to "+Integer.toString(year_end);
    }


    public Man compare(Man ob) {
        if(this.getClass().equals(ob.getClass())==false) return null;
        Dean d= (Dean) ob;
        if(this.year_end > d.year_end){
            return this;
        }
        else return d;
    }


    public double average() {
        System.out.print("[Average not applicable] ");
        return super.average();
    }
}
