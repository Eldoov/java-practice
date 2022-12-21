package edu.bu.met.cs342;

public class LinkedStack <T>{

    private Node<T> stack;
    private int count;

    public int getCapacity() {
        // TODO Auto-generated method stub
        return Integer.MAX_VALUE;
    }

    public boolean push(T data) {
        // No overflow in a Linked List based stack

        Node<T> n = new Node<T>();
        n.setData(data);

        n.setNext(stack);
        stack = n;
        count++;

        return true;
    }

    public T pop() {
        // Check underflow
        if (isEmpty()) {
            return null;
        }

        T rtn = stack.getData();
        stack = stack.getNext();
        count--;

        return rtn;
    }

    public boolean isFull() {
        // Linked Stacks are never full
        return false;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.getData();
    }

    public int size() {
        // TODO Auto-generated method stub
        return count;
    }

    public void clear() {
        stack = null;
        count = 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "<Empty>";
        }

        String rtn = "";
        Node<T> tmp = stack;
        while(tmp != null) {
            if (tmp == stack) {
                rtn += "top -> ";
            } else {
                rtn += "       ";
            }

            rtn += tmp.getData() + "\n";
            tmp = tmp.getNext();
        }

        return rtn;
    }

}
