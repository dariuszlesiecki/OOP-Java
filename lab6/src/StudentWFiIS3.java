public class StudentWFiIS3 extends Student {
    private StudentUSOS stud;

    /* IMPLEMETACJA METOD: */

    StudentWFiIS3(String n, String s, int id, int rok1,  String p1, double o1, String p2,double o2 ,String p3,double o3){
        super(n,s,id,o1,o2,o3);
        String[] przedmioty={p1,p2,p3};
        int rok=rok1;
        stud = new StudentUSOS() {
            @Override
            public double srednia() {
                return StudentWFiIS3.super.average();
            }

            @Override
            public void listaPrzedmiotow() {
                for (int i = 0;i < przedmioty.length; ++i){
                    System.out.println("\t"+Integer.toString(i+1)+". "+ przedmioty[i]+ ": "+Double.toString(StudentWFiIS3.super.getGrade(i)));
                }
            }

            @Override
            public String toString() {
                return "["+Integer.toString(rok)+"] "+StudentWFiIS3.super.toString();
            }
        };
    }

    @Override
    public String toString() {
        return stud.toString();
    }

    public double srednia(){
        return stud.srednia();
    }
    public void listaPrzedmiotow(){
        stud.listaPrzedmiotow();
    }
}