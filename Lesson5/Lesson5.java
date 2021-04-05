import java.io.*;

public class Lesson5 {

    static Data data = new Data();
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Lesson5.csv"))) {
            String tempString = bufferedReader.readLine();
            data.setHeader(tempString.split(";"));
                int[][] intArray = new int[2][3];
                int i = 0;
                while((tempString = bufferedReader.readLine()) != null){
                    String[] valuesArray = tempString.split(";");
                    intArray[i][0] = Integer.parseInt(valuesArray[0]);
                    intArray[i][1] = Integer.parseInt(valuesArray[1]);
                    intArray[i][2] = Integer.parseInt(valuesArray[2]);
                    i++;
            }
            data.setData(intArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter("Lesson5_new.csv")) {
            out.println(data);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println(data);
    }
}


//    Реализовать сохранение данных в csv файл;
//    Реализовать загрузку данных из csv файла. Файл читается целиком.
//    Структура csv файла:
//    Строка заголовок с набором столбцов
//    Набор строк с целочисленными значениями
//
//    Разделитель между столбцами - символ точка с запятой (;)
//    Пример:
//    Value 1;Value 2;Value 3
//            100;200;123
//            300,400,500
//
//    Для хранения данных использовать класс вида:
//    public class AppData {
//        private String[] header;
//        private int[][] data;
// ...
// }

