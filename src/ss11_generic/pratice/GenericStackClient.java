package ss11_generic.pratice;

public class GenericStackClient {
    private static void stackOfString() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("Side of stack after push operations: " + stack.size());
        System.out.printf("Pop element from stack: ");
        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }
        System.out.println("\nSide of stack after pop: " + stack.size());
    }

    private static void stackOfInteger() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("Side of stack after push operations: " + stack.size());
        System.out.printf("Pop element from stack: ");
        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }
        System.out.println("\nSide of stack after pop: " + stack.size());
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of Strings");
        stackOfString();
        System.out.println("2. Stack of Integer");
        stackOfInteger();
    }
}
