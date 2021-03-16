import java.util.Arrays;

public class Student extends Man {
    private final int index;
    private final double[] grades;
    private final double Average;


    Student(String _name, String _surname, int _index, double g1, double g2, double g3){
        super(_name,_surname);
        index=_index;
        grades=new double[]{g1,g2,g3};
        Average=(g1+g2+g3)/3;
    }

    public double average() {
        return Average;
    }

    public double[] getGrades() {
        return grades;
    }

    public Man compare(Man ob){
        if(this.getClass().equals(ob.getClass())==false){
            if(this.getClass().isAssignableFrom(ob.getClass())==false) return null;
        }
        Student s = (Student) ob;
        if(this.average() > s.average()) return this;
        else return s;
    }


    public String toString() {
        return super.toString()+ " id number: "+ index+ ", grades: "+ Arrays.toString(grades);
    }
}
