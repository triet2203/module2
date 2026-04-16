package ss10_dsa.excercise;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        list.add("Triet");
        list.add("Hello");
        list.add("World");

        list.add(1, "ABC");

        list.remove(3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list.indexOf("Triet"));

    }
}
