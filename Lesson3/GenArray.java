package Lesson3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class GenArray<T> {
    private T[] strings;

    public GenArray(T... strings) {
        this.strings = strings;
    }

    public T[] getStrings() {
        return strings;
    }

    public void setStrings(T[] strings) {
        this.strings = strings;
    }

    public static <T> void swiftElements(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        GenArray<String> strings1 = new GenArray<>("один", "два");
        swiftElements(strings1.getStrings(), 0, 1);
        for (int i = 0; i < strings1.getStrings().length; i++){
            System.out.println(strings1.getStrings()[i]);
        }

    }
}
