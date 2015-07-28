class MinStack {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer[]> s2 = new Stack<Integer[]>();
    
    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek()[0] > x) {
            s2.push(new Integer[]{x, 1});
        } else if (s2.peek()[0] == x){
            s2.peek()[1]++;
        }
    }
    
    public void pop() {
        if (s1.peek().equals(s2.peek()[0])) {
            if (s2.peek()[1] > 1) {
                s2.peek()[1]--;
            } else {
                s2.pop();
            }
        }
        s1.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek()[0];
    }
    
}