package stack;

import java.util.Stack;

public class GetMinStack {
	
	Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> temp = new Stack<Integer>();
    
    public void push(int node) {
		data.push(node);
        if(temp.empty()){
            temp.push(node);
        }else{
            if(temp.peek()>=node){
                temp.push(node);
            }
        }
    }
    
    public void pop() {
        int out = data.pop();
        if(temp.peek()==out){
            temp.pop();
        }
    }
    
    public int top() {
        if(data.empty()){
            return -1;
        }else{
            return data.pop();
        }
    }
    
    public int min() {
        if(temp.empty()){
            return -1;
        }else{
            return temp.peek();
        }
    }

	public static void main(String[] args) {
		GetMinStack test = new GetMinStack();
		test.push(3);
		System.out.println(test.min()); 
		test.push(4);
		System.out.println(test.min()); 
		test.push(2);
		System.out.println(test.min()); 
		test.push(3);
		System.out.println(test.min()); 
		test.pop();
		System.out.println(test.min()); 
		test.pop();
		System.out.println(test.min()); 
	}

}
