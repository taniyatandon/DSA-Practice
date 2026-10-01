class Node {
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> mp = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (mp.containsKey(key)) {
            Node node = mp.get(key);

            delete(node);
            add(node);

            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            delete(node);
            node.val = value;
            add(node);
        } 
        else {
            if (mp.size() == capacity) {
                Node node = tail.prev;
                delete(node);
                mp.remove(node.key);
            }

            Node node = new Node(key, value);
            mp.put(key, node);
            add(node);
        }
    }

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}