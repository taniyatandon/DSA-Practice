class MyQueue {
    Stack<Integer> mainSt=new Stack<>();
    Stack<Integer> helperSt=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!mainSt.isEmpty()){
            helperSt.push(mainSt.pop());
        }
        mainSt.push(x);
        while(!helperSt.isEmpty()){
            mainSt.push(helperSt.pop());
        }
    }
    
    public int pop() {
        if(mainSt.isEmpty())return -1;
        return mainSt.pop();
    }
    
    public int peek() {
        if(mainSt.isEmpty())return -1;
        return mainSt.peek();
    }
    
    public boolean empty() {
        return mainSt.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */