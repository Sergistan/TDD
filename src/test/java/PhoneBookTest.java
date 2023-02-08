import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBookTest {
    private static Random random = new Random();

    @Test
    public void testAdd() {
        PhoneBook phoneBook = new PhoneBook();
        int result = 0;

        byte[] array = new byte[7];
        random.nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        int generatedInt = random.nextInt();

        TreeMap<String, Integer> map = new TreeMap<>();

        int countContacts = phoneBook.add(generatedString, generatedInt);

        if (!map.containsKey(generatedString)) {
            map.put(generatedString,generatedInt);
            Set<String> strings = map.keySet();
            result = strings.size();
        } else {
            System.out.println("Такое имя уже есть, не можем добавить");
        }
        Assertions.assertEquals(countContacts, result);
    }
}
