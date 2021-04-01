import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {


    public static void main(String[] args) {
//       Задание 1
        String[] text = new String[]{"o", "чём", "о", "чём", "пою", "я", "о", "чём",
                "о", "пуддинге", "съеденном", "жадным", "котом", "а", "что", "а", "что", "я",
                "сделал", "бы", "сам", "я", "съел", "бы", "пуддинг", "с", "котом", "пополам"};
        System.out.println(Arrays.asList(text));
        HashSet<String> uniqueWordsList = new HashSet<>(Arrays.asList(text));
        System.out.println(uniqueWordsList);
        System.out.println("Кол-во уникальных слов в нашем тексте: " + uniqueWordsList.size());
        HashMap<String, Integer> uniqueWordsQuantity = new HashMap<>();
        for (int i = 0; i < text.length; i++) {
            if (!uniqueWordsQuantity.containsKey(text[i])) {
                uniqueWordsQuantity.put(text[i], 1);
            } else {
                uniqueWordsQuantity.put(text[i], uniqueWordsQuantity.get(text[i]) + 1);
            }
        }

        System.out.println("Посчитали кол-во уникальных слов: " + uniqueWordsQuantity.toString());

//        Задание 2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Пятилайнен", "+0-000");
        phoneBook.add("Шестилайнен", "+1-111");
        phoneBook.add("Семилайнен", "+2-222");
        phoneBook.add("Пукканен", "+3-333");
        phoneBook.add("Пукканен", "+4-444");
        phoneBook.add("Пукканен", "+5-555");

        System.out.println();
        System.out.println("Номера телефонов по фамилии Пятилайнен: " + phoneBook.getPhoneNumbersOf("Пятилайнен"));
        System.out.println("Номера телефонов по фамилии Пукканен: " + phoneBook.getPhoneNumbersOf("Пукканен"));
    }
}


//    1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//    Посчитать, сколько раз встречается каждое слово.
//    2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий
//    и телефонных номеров. В этот телефонный справочник с помощью метода add() можно
//    добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
//    Следует учесть, что под одной фамилией может быть несколько телефонов
//    (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
//    Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
//    взаимодействие с пользователем через консоль и т.д).
//    Консоль использовать только для вывода результатов проверки телефонного справочника.
