import java.io.*;
import java.util.*;
public class Matrix implements Serializable{
    private int[][] arr;
    public Matrix(int height, int width){
        Random rnd = new Random();
        arr = new int[height][width];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                arr[i][j] = rnd.nextInt();
            }
        }
    }

    public int[] getLen(){
        return new int[]{arr.length, arr[0].length};
    }

    public int getElement(int h, int w){
        return arr[h][w];
    }

    public void setElement(int h, int w, int v){
        arr[h][w] = v;
    }
    public static boolean BoolSque(Matrix mass){
        if(mass.getLen()[0] == mass.getLen()[1]){
            boolean flag = false;
            int val = 0;

            for(int i=0; i<mass.getLen()[0]; i++) {
                int ch = 0;
                for (int j = 0; j < mass.getLen()[1]; j++) {
                    ch+=mass.getElement(i, j);
                }
                if(!flag) val=ch;
                else{
                    if(val!=ch) return false;
                }
            }

            for(int j=0; j<mass.getLen()[0]; j++) {
                int ch = 0;
                for (int i = 0; i < mass.getLen()[1]; i++) {
                    ch+=mass.getElement(i, j);
                }
                if(val!=ch) return false;
            }

            int ch = 0;
            for (int i = 0; i < mass.getLen()[0]; i++) {
                ch+=mass.getElement(i, i);
            }
            if(val!=ch) return false;

            ch = 0;
            for (int i = mass.getLen()[0]-1; i >-1; i--) {
                ch+=mass.getElement(i, i);
            }
            if(val!=ch) return false;
            return true;
        }
        else{
            return false;
        }
    }
}
