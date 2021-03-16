import java.math.BigInteger;

public class Generate {
    int p;
    int q;
    int n;
    int fi;
    int e;
    int d;
    String Decoded="";
    BigInteger[] Encrypted;

    Generate(int p1, int q1){
        p=p1;
        q=q1;
        n=p*q;
        fi=(p-1)*(q-1);
        e =findE(fi);
        System.out.println("e="+e);
        d=extendEuclid(e,fi);
        System.out.println("d="+d);

    }

    public int Euclid(int a, int b){
        int temp=0;
        while(b!=0){
            temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    public int findE(int fi1){
        int e1=0;
        for(int i=3; i<fi1; i++){
            if(isPrime(i)){
                if(Euclid(i,fi1)==1){
                    return i;
                }
            }
        }
        return 1;
    }
    public static boolean isPrime(int a){
        if (a == 2 || a == 3) {
            return true;
        }
        if (a % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(a) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int extendEuclid(int a, int b){
        int x0=1;
        int x=0;
        int b0=b;
        int q=0;
        int temp=0;
        while(b!=0){
            q=Math.floorDiv(a,b);
            temp=x;
            x=x0-q*x;
            x0=temp;
            temp=a%b;
            a=b;
            b=temp;
        }
        if(x0<0){
            x0=x0+b0;
        }
        return x0;
    }
    public void encrypt(String s){
        int l=s.length();
        int[] a= new int[l];
        char[] b= new char[l];
        BigInteger tmp;
        s.getChars(0,l,b,0);
        Encrypted = new BigInteger[l];
        for(int i=0; i<l; i++){
            a[i]=(int)b[i];
            tmp=BigInteger.valueOf(a[i]);
            Encrypted[i]=tmp.modPow(BigInteger.valueOf(e),BigInteger.valueOf(n));
        }
    }
    public void decode(){
        int l= Encrypted.length;
        int tmp;
        for(int i=0; i<l;i++){
            tmp=(Encrypted[i].modPow(BigInteger.valueOf(d),BigInteger.valueOf(n))).intValue();
            Decoded=Decoded+String.valueOf((char)tmp);
        }
        System.out.println("Decoded: "+Decoded);
    }

}
