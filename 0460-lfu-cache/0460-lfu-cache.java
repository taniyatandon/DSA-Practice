class Node{
    Node prev;
    Node next;
    int val;
    int freq;
    int key;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        this.freq=1;
    }

}
class DoublyLinkedList{
    Node head;
    Node tail;
    int size=0;
    public DoublyLinkedList(){
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        size=0;
    }
    public void add(Node node){
        head.next.prev=node;
        node.next=head.next;
        node.prev=head;
        head.next=node;
        size++;
    }
    public void delete(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
        size--;
    }
    public Node removeLast(){
        if(size==0) return null;

        Node node=tail.prev;
        delete(node);

        return node;
    }
}
class LFUCache {
    HashMap<Integer,DoublyLinkedList> freqMap=new HashMap<>();
    HashMap<Integer, Node> mp=new HashMap<>();
    int capacity;
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            int oldFreq=node.freq;
            DoublyLinkedList list=freqMap.get(oldFreq);
            list.delete(node);
            if(list.size==0){
                freqMap.remove(oldFreq);
                if(minFreq==oldFreq){
                    minFreq++;
                }
            }
            node.freq++;
            freqMap.putIfAbsent(node.freq,new DoublyLinkedList());
            freqMap.get(node.freq).add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity==0)return;
        if(mp.containsKey(key)){
            Node node=mp.get(key);
            node.val=value;
            int oldFreq=node.freq;
            DoublyLinkedList list=freqMap.get(oldFreq);
            list.delete(node);
            if(list.size==0){
                freqMap.remove(oldFreq);
                if(minFreq==oldFreq){
                    minFreq++;
                }
            }
            node.freq++;
            
            freqMap.putIfAbsent(node.freq,new DoublyLinkedList());
            freqMap.get(node.freq).add(node);
        }
        else{
            if(mp.size()==capacity){
                DoublyLinkedList list=freqMap.get(minFreq);
                Node node=list.removeLast();
                mp.remove(node.key);
                if(list.size==0){
                    freqMap.remove(minFreq);
                }
            }
            Node node=new Node(key,value);
            mp.put(key,node);
            freqMap.putIfAbsent(1,new DoublyLinkedList());
            freqMap.get(1).add(node);
            minFreq=1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */