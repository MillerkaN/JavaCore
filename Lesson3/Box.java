package Lesson3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitList;

    public Box(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public float getBoxWeight() throws ArrayIndexOutOfBoundsException {
        return (float) (fruitList.size() * fruitList.get(0).getWeight());
    }

    public boolean compare(Box<?> box) {
        if (this.getBoxWeight() == box.getBoxWeight()) {
            return true;
        } else return false;
    }

    public void getInto(Box<T> box) throws ArrayStoreException {
        this.getFruitList().addAll(box.getFruitList());
        this.getFruitList().clear();
    }
}


