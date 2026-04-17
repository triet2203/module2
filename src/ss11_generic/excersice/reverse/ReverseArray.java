package ss11_generic.excersice.reverse;

import java.util.Stack;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }

    }
}
