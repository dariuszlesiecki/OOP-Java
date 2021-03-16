public class StudentWFiIS2 implements StudentUSOS {
    private String[] przedmioty;
    private int rok;
    private Student stud;

    /* IMPLEMETACJA METOD: */
    StudentWFiIS2(String n, String s, int id, int rok1,  String p1, double o1, String p2,double o2 ,String p3,double o3){
        stud = new Student(n,s,id,o1,o2,o3);
        rok=rok1;
        String[] p =  {p1,p2,p3};
        przedmioty= p;
    }

    @Override
    public double srednia() {
        return stud.average();
    }

    @Override
    public String toString() {
        return "["+Integer.toString(rok)+"] "+stud.toString();
    }

    @Override
    public void listaPrzedmiotow() {
        for (int i = 0;i < przedmioty.length; ++i){
            System.out.println("\t"+Integer.toString(i+1)+". "+ przedmioty[i]+ ": "+Double.toString(stud.getGrade(i)));
        }
    }
}
