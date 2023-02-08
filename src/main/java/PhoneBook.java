import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    TreeMap<String, Integer> map = new TreeMap<>();

    public int add (String name, Integer phoneNumber){
        if (!map.containsKey(name)) {
            map.put(name,phoneNumber);
        } else {
            System.out.println("Такое имя уже есть, не можем добавить");
        }
        Set<String> strings = map.keySet();
        return strings.size();
    }
}
