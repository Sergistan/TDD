public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println(phoneBook.add("Сергей",111));
        System.out.println(phoneBook.add("Илья",222));
        System.out.println(phoneBook.add("Костя",333));
        System.out.println(phoneBook.add("Сергей",444));

        System.out.println();

        System.out.println(phoneBook.findByNumber(111));
        System.out.println(phoneBook.findByNumber(555));

        System.out.println();

        System.out.println(phoneBook.findByName("Илья"));
        System.out.println(phoneBook.findByName("Макар"));

        System.out.println();

        System.out.println(phoneBook.printAllNames());
    }
}
