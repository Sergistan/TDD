import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PhoneBookTest {
    private static Random random = new Random();
    private static int generatedInt = random.nextInt();

    @Test
    public void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        String generatedString = randomString();
        int result = 0;
        int countContacts = phoneBook.add(generatedString, generatedInt);

        if (phoneBook.map.containsKey(generatedString)) {
            phoneBook.map.put(generatedString, generatedInt);
            Set<String> strings = phoneBook.map.keySet();
            result = strings.size();
        } else {
            System.out.println("Такое имя уже есть, не можем добавить");
        }
        Assertions.assertEquals(result, countContacts);
    }

    @Test
    public void findByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        String generatedString = randomString();

        phoneBook.map.put(generatedString, generatedInt);

        generatedString = phoneBook.findByNumber(generatedInt);

        for (Map.Entry<String, Integer> entry : phoneBook.map.entrySet()) {
            if (entry.getValue().equals(generatedInt))
                Assertions.assertEquals(entry.getKey(), generatedString);
        }
    }

    @Test
    public void findByName() {
        PhoneBook phoneBook = new PhoneBook();
        String generatedString = randomString();

        phoneBook.map.put(generatedString, generatedInt);

        int generatedInt = phoneBook.findByName(generatedString);

        for (Map.Entry<String, Integer> entry : phoneBook.map.entrySet()) {
            if (entry.getKey().equals(generatedString))
                Assertions.assertEquals(entry.getValue(), generatedInt);
        }
    }

    @Test
    public void printAllNames() {
        PhoneBook phoneBook = new PhoneBook();
        String generatedString = randomString();

        phoneBook.map.put(generatedString, generatedInt);

        Set<String> allNames = phoneBook.printAllNames();

        Set<String> strings = phoneBook.map.keySet();

        Assertions.assertEquals(allNames, strings);
    }


    public static String randomString() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
