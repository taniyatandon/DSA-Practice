class MyCircularDeque {
    int[] arr;
    int k;
    int front;
    int rear;
    int size;
    public MyCircularDeque(int k) {
        this.k=k;
        this.arr=new int[k];
        this.front=-1;
        this.rear=-1;
        this.size=0;
    }
    
    public boolean insertFront(int value) {
        if(isFull())return false;
        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + k) % k;
        }
        size++;
        arr[front]=value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull())return false;
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % k;
        }
        size++;
        arr[rear]=value;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty())return false;
        if (size == 1) {
            front = rear = -1;
        } else {
            front = (front + 1) % k;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty())return false;
        if (size == 1) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + k) % k;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty())return -1;
        return arr[front];
    }
    
    public int getRear() {
        if(isEmpty())return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */