package Lesson2;

public class Main {
    public static void main(String[] args) {

        String[][] ourTwoDimArray = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "a", "1", "1"}, {"1", "1", "1", "1"}};

        CalculateArrVal calculateArrVal = new CalculateArrVal();


        try {
            calculateArrVal.sumOfArrayValues(ourTwoDimArray);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}



//1. Написать метод, на вход которому подается двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int
// и просуммировать.
// Если в каком-то элементе преобразование не удалось
// (например, если в ячейке лежит символ или текст вместо числа),
// надо бросить исключение MyArrayDataException с детализацией, в какой ячейке неверные данные.
//3. В методе main() вызвать полученный метод,
// обработать возможные исключения MySizeArrayException и MyArrayDataException
// и вывести результат расчета.