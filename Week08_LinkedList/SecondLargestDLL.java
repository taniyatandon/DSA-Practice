public class SecondLargestDLL {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static Integer secondLargest(Node head) {
        if (head == null || head.next == null) return null;

        Integer largest = null;
        Integer second = null;

        for (Node current = head; current != null; current = current.next) {
            int value = current.data;

            if (largest == null || value > largest) {
                if (largest != null && value != largest) second = largest;
                largest = value;
            } else if (value < largest && (second == null || value > second)) {
                second = value;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(40);
        head.next.prev = head;
        head.next.next = new Node(20);
        head.next.next.prev = head.next;

        System.out.println(secondLargest(head));
    }
}
