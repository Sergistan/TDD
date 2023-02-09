import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    TreeMap<String, Integer> map = new TreeMap<>();

    public int add(String name, int phoneNumber) {
        if (!map.containsKey(name)) {
            map.put(name, phoneNumber);
        } else {
            System.out.println("Такое имя уже есть, не можем добавить");
        }
        Set<String> strings = map.keySet();
        return strings.size();
    }

    public String findByNumber(int phoneNumber) {
        String name = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                name = entry.getKey();
            }
        }
        return name;
    }

    public int findByName(String name) {
        return 0;
    }
}
