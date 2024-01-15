package Task_68;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class MyArray implements Serializable {
    private int[] array;

    public MyArray(int size) {
        array = new int[size];
        Random r = new Random();
        Arrays.setAll(array, i -> r.nextInt(10));
    }

    public int getSize() {
        return array.length;
    }

    public void setValue(int index, int value) {
        if (0 <= index && index <= array.length) {
            array[index] = value;
        }
    }

    public int getValue(int index) {
        if (0 <= index && index <= array.length) {
            return array[index];
        }
        return -1;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] newArray) {
        array = newArray;
    }

    public static int getCount(MyArray array, int value, int count) {
        int rezalt = 0; // ответ
        int bfCount = 0; // сколько идёт подряд заданного элимента
        int lFlag = 0;// сколько элиментов можно добавлять к последовательности

        for (int i = 0; i < array.getSize(); i++) { // прозод по элиментам
            if (array.getValue(i) == value) {
                bfCount += 1;
                if (bfCount >= count) lFlag = i - count + 2;
            } else bfCount = 0;

            rezalt += lFlag;//прибавление колличества подпоследовательностей
        }
        return rezalt;
    }

    public String toString() {
        String s = "";
        for (int i :
                array) {
            s += i + " ";
        }
        return s;
    }
}
