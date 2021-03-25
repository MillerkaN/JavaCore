package Lesson2;

import java.util.Arrays;

public class CalculateArrVal {


    public void sumOfArrayValues(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int SumOfRow = 0;
        int SumOfColumn = 0;
        int columnMin = 0;
        int currentMin;
        int columnMax = 0;
        int temporary = 0;
        for (int row = 0; row < array.length; row++) {
            SumOfRow = row + 1;
            for (int column = 0; column < array[row].length; column++) {
                currentMin = array[row].length;
                temporary++;
                if (temporary == 1){
                    columnMin = currentMin;
                }
                if (array[row].length > columnMax) {
                    columnMax = array[row].length;
                }
                if (currentMin < columnMin){
                    columnMin = currentMin;
                }
            }
        }
        System.out.println("Строк в массиве: " + SumOfRow + " Максимум колонок: " + columnMax + " Минимум колонок: " + columnMin);

            if (SumOfRow != 4 || columnMax != 4 || columnMin !=4 ) {
                throw new MyArraySizeException("Массив должен быть двумерным размером 4х4!");
            }
            int sumOfVal = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    sumOfVal = sumOfVal + Integer.parseInt(array[i][j]);
                }
            }
            System.out.println("Сумма значений массива равна " + sumOfVal);
        }
    }


