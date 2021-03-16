public class Lab10 {
    public static void main(String[] args){
        try {
            System.out.println(args[0]);
            String[] ar= args[0].split("");
            Stack<String> s = new Stack<String>(ar.length*2);
            int i=0;
            String a,b,w;
            for(var el: ar){
                //System.out.println(el);
                if(el.equals("/") || el.equals("*") || el.equals("+") || el.equals("-")){
                    b=s.pop();
                    a=s.pop();
                    w="("+a+el+b+")";
                    s.push(w);
                }
                else{
                    s.push(el);
                }
            }
            if(s.getN()==2){
                b=s.pop();
                a=s.pop();
                throw new IllegalArgumentException("BLAD DANYCH WEJSCIOWYCH! Koniec algorytmu, a stos nie jest pusty: "+a+", "+b);
            }
            System.out.println("Wynik: "+s.pop());
        }
        catch (StackOverflowException e){
            System.out.println(e.getMessage());
        }
        catch (StackUnderflowException e){
            System.out.println("BLAD DANYCH WEJSCIOWYCH! Na stosie jest za malo elementow, zeby wykonac operacje!");
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
