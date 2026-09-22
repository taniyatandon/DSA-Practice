public class InsertAfterKeyDLL {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static Node insertAfter(Node head, int key, int value) {
        Node current = head;

        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) return head;

        Node newNode = new Node(value);
        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) current.next.prev = newNode;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;

        head = insertAfter(head, 10, 15);

        for (Node p = head; p != null; p = p.next) {
            System.out.print(p.data + " ");
        }
    }
}
