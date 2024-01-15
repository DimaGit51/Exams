package Task_32;

import java.io.Serializable;
import java.util.Random;

public class MyMatrix implements Serializable {
    private int[][] matrix;

    public MyMatrix(int n) {
        n = Math.max(n, 0);
        matrix = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = r.nextInt(1, n * n + 1);
            }
        }
    }

    public int getLen() {
        return matrix.length;
    }

    public int getValue(int i, int j) {
        return matrix[i][j];
    }

    public void setValue(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public static boolean isMegik(MyMatrix matrix) {
        boolean flag;
        int d1 = 0;
        int d2 = 0;
        int n = matrix.getLen();
        for (int i = 0; i < n; i++) {
            d1 += matrix.getValue(i, i);
            d2 += matrix.getValue(i, n - i - 1);
        }
        flag = d1 == d2;

        for (int i = 0; i < n && flag; i++) {
            int s_h = 0;
            int s_w = 0;
            for (int j = 0; j < n; j++){
                s_h += matrix.getValue(i, j);
                s_w += matrix.getValue(j, i);
            }
            flag = (s_h == d1) && (s_w == d2);
        }
        return flag;
    }
}
