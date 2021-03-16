import java.util.Objects;

public class Stack<T> {
    private T[] A;
    private int n=0;
    private int max;

    Stack(int max){
        this.max=max;
        @SuppressWarnings("unchecked")
        final T[] A=(T[]) new Object[max];
        this.A=A;
    }

    public boolean isEmpty(){
        if (n==0) return true;
        else return false;
    }

    public boolean isFull(){
        if (n==max) return true;
        else return false;
    }

    public void push(T x) throws StackOverflowException{
        if(isFull()) throw new StackOverflowException("Stos pełny!");
        A[n]=x;
        n+=1;
    }

    public T pop() throws StackUnderflowException{
        if(isEmpty()) throw new StackUnderflowException("Stos pusty!");

        n-=1;
        return A[n];
    }
    public int getN(){
        return n;
    }

    @Override
    public String toString() {
        String s="";
        if(isEmpty()) return "";
        for(int i=0; i<n; i++){
            s+=A[i].toString()+" ";
        }
        return s;
    }
}
