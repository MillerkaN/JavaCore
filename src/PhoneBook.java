import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    public static ArrayList<Person> persons = new ArrayList<>();
    public static HashMap<String, ArrayList<Person>> phoneBook = new HashMap<>();

    public static void add(String surname, String phoneNum) {
        if (phoneBook.containsKey(surname)) {
            ArrayList<Person> persons = phoneBook.get(surname);
            persons.add(new Person(surname, phoneNum));
        } else {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person(surname, phoneNum));
            phoneBook.put(surname, persons);
        }
    }

    public ArrayList<String> getPhoneNumbersOf(String surname) {
        if (!phoneBook.containsKey(surname)) {
            return null;
        } else {
            ArrayList<Person> persons = phoneBook.get(surname);
            ArrayList<String> phoneNums = new ArrayList<>();
            for (int i = 0; i < persons.size(); i++) {
                phoneNums.add(persons.get(i).phoneNum);
            }
            return phoneNums;
        }
    }
}
