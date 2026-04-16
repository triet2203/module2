package ss10_dsa.excercise;

import ss10_dsa.pratice.MyLinkedList;

public class MyLinkListTest {
    public static void main(String[] args) {
        MyLinkList<String> list = new MyLinkList<>();

        list.add(0, "Hello");
        list.add(1, "World");
        list.add(2, "Welcome");

        list.remove(1);

        System.out.println(list.size());
    }
}
