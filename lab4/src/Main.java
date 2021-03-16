import java.util.Random;

class Main {
    public static void main(String[] args) {
        /*byte[] tab={1,0,0,1};
        BigInt b= new BigInt(tab);
        System.out.println(b);
        tab[2]=1;
        System.out.println(b);
        BigInt a= new BigInt(b);
        System.out.println(a);*/

        test();
    }


    public static void test() {
        BigInt a, b;
        long x,y;
        double check=0;
        int n=1000;
        long max=(long)Math.pow(2,64)-1;
        for(int i =0; i< n; i++){
            x= (long)Math.random()*max;
            y= (long)Math.random()*max;
            x=Math.abs(x);
            y=Math.abs(y);
            a= new BigInt(String.valueOf(x));
            b= new BigInt(String.valueOf(y));
            if(String.valueOf(x+y).equals(BigInt.Add(a,b).toString())) check+=1;
            else {
                System.out.println("Test "+i+": ZLE");
            }
        }
        check=100*check/n;
        System.out.println("Test 1-1000: "+check+"% poprawnosci");

        //TEST 1001
        x=1L;
        y=999999999999999999L;
        a= new BigInt(String.valueOf(x));
        b= new BigInt(String.valueOf(y));
        //System.out.println(b);
        if(String.valueOf(x+y).equals(BigInt.Add(a,b).toString())){
            System.out.println("Test 1001: OK");
        }
        else{
            System.out.println("Test 1001: ZLE");
        }
        System.out.println("suma BigInt:"+BigInt.Add(a,b)+", long:"+(x+y));

        //TEST 1002
        x=999999999999999999L;
        y=1L;
        a= new BigInt(String.valueOf(x));
        b= new BigInt(String.valueOf(y));
        if(String.valueOf(x+y).equals(BigInt.Add(a,b).toString())){
            System.out.println("Test 1002: OK");
        }
        else{
            System.out.println("Test 1002: ZLE");
        }
        System.out.println("suma BigInt:"+BigInt.Add(a,b)+", long:"+(x+y));
    }
}