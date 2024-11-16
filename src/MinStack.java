import java.util.ArrayList;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    ArrayList<Integer> list;
    private int index = -1;
    public MinStack() {
        this.stack = new Stack<>();
        this.list = new ArrayList<>();
    }

    public void push(int val) {
        this.stack.push(val);
        index++;
        if (list.isEmpty()) {
            list.add(index);
        }
        else if (val < stack.get(list.getLast())) {
            list.add(index);
        }
    }

    public void pop() {
        this.stack.pop();
        index--;
        if(list.getLast()>index){
            list.removeLast();
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return stack.get(list.getLast());
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
