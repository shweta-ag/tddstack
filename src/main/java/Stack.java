/**
 * Created by alpha on 24/06/2015.
 */
public class Stack {

    private int size = 0;
    private int[] elements = new int[2];

    public boolean isEmpty() {
        
        return size ==0;
    }

    public void push(int i) {
       this.elements[size++] = i;
    }

    public int pop(){
      if (size == 0)
          throw new Underflow();
        return elements[--size];
    }

    public class Underflow extends RuntimeException{

    }
}
