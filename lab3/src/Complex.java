import java.util.concurrent.CompletionException;

public class Complex {
    private double re;
    private double im;

    Complex(double re, double im){
        this.re=re;
        this.im=im;
    }
    Complex(double re){
        this.re=re;
        this.im=0;
    }
    Complex(){
        this.re=0;
        this.im=0;
    }

    public double getIm() {
        return im;
    }

    public double getRe() {
        return re;
    }

    public String toString(){
        if(getRe()==0 && getIm()==0) {
            return "0.0";
        }
        if(getRe()==0 && getIm()!=0) {
            return Double.toString(getIm())+"i";
        }
        if(getRe()!=0 && getIm()==0) {
            return Double.toString(getRe());
        }
        if(getRe()!=0 && getIm()!=0) {
            if(getIm()>0) {
                return Double.toString(getRe()) + " + " + Double.toString(getIm())+"i";
            }
            else{
                return Double.toString(getRe())+" "+ Double.toString(getIm())+"i";
            }
        }
        return "0";
    }

    public static Complex I= new Complex(0,1);
    public static Complex ZERO= new Complex();
    public static Complex ONE= new Complex(1);

    public static Complex add(Complex c1, Complex c2){
        return new Complex(c1.getRe()+c2.getRe(),c1.getIm()+c2.getIm());
    }

    public static Complex subtract(Complex c1, Complex c2){
        return new Complex(c1.getRe()-c2.getRe(),c1.getIm()-c2.getIm());
    }

    public static Complex multiply(Complex c1, Complex c2){
        double a= c1.getRe();
        double b= c1.getIm();
        double c= c2.getRe();
        double d= c2.getIm();
        return new Complex(a*c - b*d, b*c + a*d);
    }

    public static Complex multiply(Complex c1, double x){
        double a= c1.getRe();
        double b= c1.getIm();
        Complex c2= new Complex(x);
        double c= c2.getRe();
        double d= c2.getIm();
        return new Complex(a*c - b*d, b*c + a*d);
    }

    public static Complex divide(Complex c1, Complex c2){
        double a= c1.getRe();
        double b= c1.getIm();
        double c= c2.getRe();
        double d= c2.getIm();
        return new Complex((a*c + b*d)/(c*c + d*d), (b*c - a*d)/(c*c + d*d));
    }

    public double mod(){
        return Math.sqrt(re*re + im*im);
    }

    public static String sqrt(double x){
        if(x<0){
            return Double.toString(Math.sqrt(Math.abs(x)))+"i";
        }
        else{
            return Double.toString(Math.sqrt(x));
        }
    }

    public boolean equals(Complex c1){
        Complex c=  (Complex)c1;
        if (re == c.getRe() && im == c.getIm()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Object c){
        return false;
    }

    public void conjugate(){
        im=im*(-1);
    }

    public void opposite(){
        re=re*(-1);
        im=im*(-1);
    }
}
