public class DeleteAllOccurrencesDLL {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static Node deleteAll(Node head, int value) {
        Node current = head;

        while (current != null) {
            Node next = current.next;

            if (current.data == value) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;

                if (current.next != null) current.next.prev = current.prev;
            }

            current = next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;

        head = deleteAll(head, 2);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
