package edu.bu.met.cs342;

public class ArrayStack<T> {
    private Object[] stack;
    private int top;

    private static final int STACK_SIZE = 10;
    //private static final int STACK_GROWTH = 10;

    public ArrayStack(){
        stack = new Object[STACK_SIZE];
        top = 0;
    }

    public void clear(){
        stack = null;
        top = 0;
    }

    public int size(){
        return top;
    }
    public boolean isEmpty(){
        return (0 == top);
    }
    public boolean isFull(){
        if (top == stack.length) return true;
        else return false;
    }

    public int getCapacity(){
        return stack.length;
    }

    public void ensureCapacity(int minCapacity){
        Object[] biggerStack;
        if(stack.length < minCapacity){
            biggerStack = new Object[minCapacity];
            for(int i = 0; i< size(); ++i){
                biggerStack[i] = stack[i];
            }
            //System.arraycopy(stack, biggerStack,0, size());
            stack = biggerStack;
        }
    }
    public void push(T data){
        if (isFull()){
            ensureCapacity(top*2 + 1);
        }
        // stack[top++] = data; // one line but can be confusing and prone to error if edited to ++top
        stack[top] = data;
        //System.out.println("Top " + top);
        ++top;
    }

    public T peek(){
        if (0 == top){
            return null;
        }
        return (T)stack[top-1]; // zero index, top is next place to push
    }

    public T pop(){
        T item;
        if (isEmpty()){
            return null;
        }
        --top; // top is next push location, point to item about to be removed
        item = (T)stack[top];
        stack[top] = null;
        return item;

    }
    public String toString(){
        if(isEmpty()){
            return "<Empty>";
        }
        String rtn = "";
        for (int i = top-1; i >= 0; --i){
            if (i == top-1){
                rtn += "top -. ";
            } else {
                rtn += "       ";
            }
            rtn += stack[i] + "\n";
        }
        return rtn;
    }
}
