public class DoublyLinkedListOperations {
    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) current = current.next;

        current.next = newNode;
        newNode.prev = current;
    }

    void insertBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;

        if (head != null) head.prev = newNode;
        head = newNode;
    }

    void delete(int data) {
        Node current = head;

        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) return;

        if (current.prev != null) current.prev.next = current.next;
        else head = current.next;

        if (current.next != null) current.next.prev = current.prev;
    }

    void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    void traverseBackward() {
        if (head == null) return;

        Node current = head;
        while (current.next != null) current = current.next;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedListOperations list = new DoublyLinkedListOperations();

        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertBeginning(5);

        list.traverseForward();
        list.traverseBackward();

        list.delete(20);
        list.traverseForward();
    }
}
