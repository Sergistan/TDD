import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBookTest {
    private static Random random = new Random();
    private static int generatedInt = random.nextInt();

    @Test
    public void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        int result = 0;
        String generatedString = randomString();

        TreeMap<String, Integer> map = new TreeMap<>();

        int countContacts = phoneBook.add(generatedString, generatedInt);

        if (!map.containsKey(generatedString)) {
            map.put(generatedString, generatedInt);
            Set<String> strings = map.keySet();
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

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put(generatedString, generatedInt);

        generatedString = phoneBook.findByNumber(generatedInt);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!entry.getValue().equals(generatedInt))
                Assertions.assertEquals(null, generatedString);
        }
    }

    @Test
    public void findByName() {
        PhoneBook phoneBook = new PhoneBook();
        String generatedString = randomString();

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put(generatedString, generatedInt);

        int generatedInt = phoneBook.findByName(generatedString);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (!entry.getKey().equals(generatedString))
                Assertions.assertEquals(0, generatedInt);
        }
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
