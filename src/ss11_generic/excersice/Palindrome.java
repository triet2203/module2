package ss11_generic.excersice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String text = "Able was I ere I saw Elba";
        text = text.toLowerCase();
        text = text.replaceAll("[^a-z]", "");

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : text.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        boolean isPalindrome = true;

        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Chuỗi là Palindrome");
        } else {
            System.out.println("Chuỗi không phải là Palindrome");
        }
    }
}
