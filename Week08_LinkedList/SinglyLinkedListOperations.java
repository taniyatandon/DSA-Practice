public class SinglyLinkedListOperations {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node head;

    static void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    static void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    static int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    static int search(int key) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == key) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    static int middle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow == null ? -1 : slow.data;
    }

    static void reverse() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public static void main(String[] args) {
        add(10);
        add(20);
        add(30);
        add(40);

        print();
        System.out.println("Count: " + count());
        System.out.println("Search 30: " + search(30));
        System.out.println("Middle: " + middle());

        reverse();
        print();
    }
}
