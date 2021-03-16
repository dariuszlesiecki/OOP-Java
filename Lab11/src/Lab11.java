
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Lab11 {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        String[] t1 = new String[n];
        String[] t2 = new String[m];
        String[] t3 = new String[m];
        for(int i=0; i<n; i++){
            t1[i]=generate();
        }

        List<String> l1 = Arrays.asList(t1);
        List<Integer> l2 = new ArrayList<Integer>();
        for(int i=0; i<m; i++){
            String s= generate();
            while (l1.contains(s)){
                s=generate();
            }
            t3[i]=s;

            Random random = new Random();
            int index = random.nextInt(n);
            while(l2.contains(index)){
                index = random.nextInt(n);
            }
            l2.add(index);
            t2[i]=t1[index];
        }

        ArrayList<String> AL = new ArrayList<String>();
        LinkedList<String> LL = new LinkedList<String>();
        TreeMap<String,Integer> TM = new TreeMap<String,Integer>();
        HashMap<String,Integer> HM = new HashMap<String,Integer>();
        long Time,CurrentTime;
        System.out.println("Losowanie "+ Integer.toString(n) + " lancuchow.");
        System.out.println("Testowanie "+ Integer.toString(m) + " lancuchow.");

        System.out.print("Generate: ArrayList(");
        Time=System.nanoTime();
        for(String x: t1){
            AL.add(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), LinkedList(");
        Time=System.nanoTime();
        for(String x: t1){
            LL.add(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), TreeMap(");
        Time=System.nanoTime();
        for(String x: t1){
            TM.put(x,0);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), HashMap(");
        Time=System.nanoTime();
        for(String x: t1){
            HM.put(x,0);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms)");
        System.out.println();
        System.out.println();
        String size=Integer.toString(AL.size())+" "+Integer.toString(LL.size())+" "+Integer.toString(TM.size())+" "+Integer.toString(HM.size())+" ";
        System.out.println("Poczatek, rozmiary: "+size);
        System.out.println();


        // -----------------------------------------------------------SEARCH
        System.out.print("Search:    ArrayList(");
        Time=System.nanoTime();
        for(String x: t2){
            AL.contains(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), LinkedList(");
        Time=System.nanoTime();
        for(String x: t2){
            LL.contains(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), TreeMap(");
        Time=System.nanoTime();
        for(String x: t2){
            TM.containsKey(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), HashMap(");
        Time=System.nanoTime();
        for(String x: t2){
            HM.containsKey(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms)");
        System.out.println();
        System.out.println();

        // -----------------------------------------------------------SEARCH NOT
        System.out.print("SearchNOT:    ArrayList(");
        Time=System.nanoTime();
        for(String x: t3){
            AL.contains(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), LinkedList(");
        Time=System.nanoTime();
        for(String x: t3){
            LL.contains(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), TreeMap(");
        Time=System.nanoTime();
        for(String x: t3){
            TM.containsKey(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), HashMap(");
        Time=System.nanoTime();
        for(String x: t3){
            HM.containsKey(x);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms)");
        System.out.println();

        System.out.print("java.util.ArrayList: for(");
        Time=System.nanoTime();
        for(int i=0; i<AL.size();i++){
            AL.get(i);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), for-each(");
        Time=System.nanoTime();
        for(String x: AL){

        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), iterator(");
        Time=System.nanoTime();
        for(Iterator i= AL.iterator(); i.hasNext(); i.next()){

        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);
        System.out.print(" ms)");
        System.out.println();

        // LL
        System.out.print("java.util.LinkedList: for(");
        Time=System.nanoTime();
        for(int i=0; i<AL.size();i++){
            LL.get(i);
        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), for-each(");
        Time=System.nanoTime();
        for(String x: LL){

        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), iterator(");
        Time=System.nanoTime();
        for(Iterator i= LL.iterator(); i.hasNext(); i.next()){

        }
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);
        System.out.print(" ms)");
        System.out.println();
        System.out.println();

        //REMOVE

        System.out.print("Remove:    ArrayList(");
        Time=System.nanoTime();
        AL.clear();
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), LinkedList(");
        Time=System.nanoTime();
        LL.clear();
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), TreeMap(");
        Time=System.nanoTime();
        TM.clear();
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);

        System.out.print(" ms), HashMap(");
        Time=System.nanoTime();
        HM.clear();
        CurrentTime=System.nanoTime();
        //System.out.print(TimeUnit.NANOSECONDS.toMillis((double)(CurrentTime-Time)/1000000));
        System.out.print((double)(CurrentTime-Time)/1000000);
        System.out.print(" ms)\n");

        size=Integer.toString(AL.size())+" "+Integer.toString(LL.size())+" "+Integer.toString(TM.size())+" "+Integer.toString(HM.size())+" ";
        System.out.println("Koniec, rozmiary: "+size);
        System.out.println();
    }



    public static String generate(){
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphaNumeric = upperAlphabet + lowerAlphabet;

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int length = random.nextInt(15) + 5;

        for(int j = 0; j < length; j++) {
            int index = random.nextInt(alphaNumeric.length());
            char randomChar = alphaNumeric.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}


