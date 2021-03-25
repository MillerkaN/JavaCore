package Lesson2;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    public MyArraySizeException (String message) {
        super(message);
    }
}
