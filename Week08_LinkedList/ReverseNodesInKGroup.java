public class ReverseNodesInKGroup {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node current = head;
        int count = 0;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count < k) return head;

        Node prev = null;
        current = head;

        for (int i = 0; i < k; i++) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head.next = reverseKGroup(current, k);
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node current = head;

        for (int i = 2; i <= 5; i++) {
            current.next = new Node(i);
            current = current.next;
        }

        head = reverseKGroup(head, 2);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
