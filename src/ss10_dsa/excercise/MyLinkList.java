package ss10_dsa.excercise;

public class MyLinkList<E> {
    private Node head;
    private int numNodes;

    public MyLinkList() {
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            Node newNode = new Node(element);
            newNode.next = temp.next;
            temp.next = newNode;
        }
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            E data = (E) head.getData();
            head = head.next;
            numNodes--;
            return data;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node removed = temp.next;
        temp.next = temp.next.next;

        numNodes--;

        return (E) removed.getData();
    }

    public int size() {
        return numNodes;
    }
}
