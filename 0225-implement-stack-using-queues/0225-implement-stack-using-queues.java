class MyStack {
    Queue<Integer> mainQueue = new LinkedList<>();
    Queue<Integer> helperQueue = new LinkedList<>();
    public MyStack() {
       
    }
    
    public void push(int x) {
        while(!mainQueue.isEmpty()){
            helperQueue.add(mainQueue.poll());
        }
        mainQueue.add(x);
        while(!helperQueue.isEmpty()){
            mainQueue.add(helperQueue.poll());
        }
    }
    
    public int pop() {
        if(mainQueue.isEmpty())return -1;
        int val=mainQueue.poll();
        return val;
    }
    
    public int top() {
        if(mainQueue.isEmpty())return -1;
        int val=mainQueue.peek();
        return val;
    }
    
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */