public class LC707_DesignLinkedList {
    static class MyLinkedList {
        private static class Node {
            int val;
            Node next;
            Node(int val) { this.val = val; }
        }

        private Node head;
        private int size;

        public MyLinkedList() {}

        public int get(int index) {
            if (index < 0 || index >= size) return -1;

            Node current = head;
            for (int i = 0; i < index; i++) current = current.next;

            return current.val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);

            if (head == null) {
                head = node;
            } else {
                Node current = head;
                while (current.next != null) current = current.next;
                current.next = node;
            }

            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) return;

            if (index == 0) {
                addAtHead(val);
                return;
            }

            Node current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;

            Node node = new Node(val);
            node.next = current.next;
            current.next = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;

            if (index == 0) {
                head = head.next;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) current = current.next;
                current.next = current.next.next;
            }

            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);

        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));
    }
}
