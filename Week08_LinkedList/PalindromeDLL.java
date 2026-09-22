public class PalindromeDLL {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static boolean isPalindrome(Node head) {
        if (head == null) return true;

        Node left = head;
        Node right = head;

        while (right.next != null) right = right.next;

        while (left != right && left.prev != right) {
            if (left.data != right.data) return false;
            left = left.next;
            right = right.prev;
        }

        return left.data == right.data;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(2);
        Node fourth = new Node(1);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        System.out.println(isPalindrome(head));
    }
}
