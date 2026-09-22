public class InPlaceReverseDLL {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static Node reverse(Node head) {
        Node current = head;
        Node newHead = null;

        while (current != null) {
            Node next = current.next;
            current.next = current.prev;
            current.prev = next;

            newHead = current;
            current = next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        head = reverse(head);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
