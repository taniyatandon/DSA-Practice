public class CircularLinkedListOperations {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    Node head;

    void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node current = head;
        while (current.next != head) current = current.next;

        current.next = newNode;
        newNode.next = head;
    }

    void insertBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node current = head;
        while (current.next != head) current = current.next;

        newNode.next = head;
        current.next = newNode;
        head = newNode;
    }

    int countNodes() {
        if (head == null) return 0;

        int count = 0;
        Node current = head;

        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }

    boolean search(int key) {
        if (head == null) return false;

        Node current = head;
        do {
            if (current.data == key) return true;
            current = current.next;
        } while (current != head);

        return false;
    }

    void delete(int key) {
        if (head == null) return;

        Node current = head;
        Node previous = null;

        do {
            if (current.data == key) {
                if (current == head) {
                    Node last = head;
                    while (last.next != head) last = last.next;

                    if (head.next == head) {
                        head = null;
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    previous.next = current.next;
                }
                return;
            }

            previous = current;
            current = current.next;
        } while (current != head);
    }

    int max() {
        if (head == null) throw new IllegalStateException("List is empty");

        int maximum = head.data;
        Node current = head.next;

        while (current != head) {
            maximum = Math.max(maximum, current.data);
            current = current.next;
        }

        return maximum;
    }

    void reversePrint() {
        printReverse(head, head);
        System.out.println();
    }

    private void printReverse(Node current, Node stop) {
        if (current.next != stop) {
            printReverse(current.next, stop);
        }
        System.out.print(current.data + " ");
    }

    Node middle() {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Josephus: returns the survivor's value.
    int josephus(int k) {
        if (head == null || k <= 0) throw new IllegalArgumentException();

        int n = countNodes();
        int survivorIndex = 0;

        for (int i = 2; i <= n; i++) {
            survivorIndex = (survivorIndex + k) % i;
        }

        Node current = head;
        for (int i = 0; i < survivorIndex; i++) current = current.next;

        return current.data;
    }

    void print() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedListOperations list = new CircularLinkedListOperations();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertBeginning(5);

        list.print();
        System.out.println("Count: " + list.countNodes());
        System.out.println("Search 20: " + list.search(20));
        System.out.println("Maximum: " + list.max());
        System.out.println("Middle: " + list.middle().data);

        list.reversePrint();

        list.delete(20);
        list.print();

        System.out.println("Josephus survivor for k=2: " + list.josephus(2));
    }
}
