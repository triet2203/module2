package ss11_generic.excersice.reverse;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Welcome to Java";

        Stack<String> stack = new Stack<>();
        String[] words = input.split(" ");

        for (String word : words) {
            stack.push(word);
        }

        String output = "";
        while (!stack.isEmpty()) {
            output += stack.pop() + " ";
        }
        System.out.println(output.trim());
    }
}
