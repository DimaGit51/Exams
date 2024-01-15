import java.io.*;
import java.util.*;

public class MyArray implements Serializable {
    private int[] array;
    private Random rnd = new Random();

    public MyArray(int length) {
        array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = rnd.nextInt();
        }
    }

    public int getSize() {
        return array.length;
    }

    public int getElement(int i) {
        return array[i];
    }

    public void setElement(int i, int value) {
        array[i] = value;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] newArray) {
        array = Arrays.copyOf(newArray, newArray.length);
    }
    public static int[] Task(MyArray myArray,int k){
        int count=1;
        int[] array= myArray.getArray();
        for(int i=1;i<array.length;i++) {
            if(array[i]==array[i-1])
                count++;
            else{
                if(count>=k){
                    System.arraycopy(array,i,array,i-count,array.length-i);
                    array=Arrays.copyOf(array,array.length-count);
                    i=0;
                }
                count=1;
            }
            if(i==array.length-1&&count>=k)
            {
                array=Arrays.copyOf(array,array.length-count);
            }
        }
        return array;
    }
}
