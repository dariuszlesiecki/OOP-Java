import java.util.Arrays;

public class BigInt {
    private byte[] T;

    BigInt(){

    }

    BigInt(String s){
        int l=s.length();
        byte[] tmp = new byte[l];
        for(int i=0; i<l; i++){
            tmp[i]= (byte)Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        T=tmp;
    }
    BigInt(byte[] tab){
        T= Arrays.copyOf(tab,tab.length);
    }
    BigInt(BigInt o){
        T = Arrays.copyOf(o.getNum(),o.getNum().length);
    }

    public boolean equals(BigInt o){
        if(this.T == o.getNum()) return true;
        else return false;
    }

    public String toString(){
        String s="";
        int l= T.length;
        for(int i=0; i<l; i++){
            s+=String.valueOf(T[i]);
        }
        return s;
    }

    public byte[] getNum(){
        byte[] tmp=Arrays.copyOf(T,T.length);
        return tmp;
    }

    public static BigInt Add(BigInt o1, BigInt o2){

        byte[] t1=o1.getNum();
        byte[] t2=o2.getNum();
        var len1= o1.getNum().length -1;
        var len2= o2.getNum().length -1;
        String s="";
        int a=0;
        while(true){
            if(len1<0 && len2<0) break;
            if(len1<0 && len2>=0){
                a=t2[len2] + a;
                s=String.valueOf(a%10)+s;
                a=a/10;
            }
            else if(len1>=0 && len2<0){
                a=t1[len1] + a;
                s=String.valueOf(a%10)+s;
                a=a/10;
            }
            else{
                a=t1[len1]+ t2[len2] + a;
                s=String.valueOf(a%10)+s;
                a=a/10;

            }
            len1=len1-1;
            len2=len2-1;
        }
        if(a>0) s=a+s;

        BigInt result= new BigInt(s);
        return result;

    }


}
