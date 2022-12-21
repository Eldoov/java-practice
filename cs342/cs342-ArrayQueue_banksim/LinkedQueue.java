package edu.bu.met.cs342;

public class LinkedQueue<T> {

    private Node<T> head;
    private Node<T> tail;
    int count;

    public LinkedQueue() {
        head = tail = null;
        count = 0;
    }

    public boolean add(T data) {

        // Allocate a new node and fill it in.
        Node<T> newNode = new Node<T>();
        newNode.setData(data);

        // Special case if list is empty
        if (count == 0) {
            head = tail = newNode;
            count = 1;
            return true;
        }

        // General case
        tail.setNext(newNode);
        tail = newNode;
        count++;

        return true;
    }

    public T remove() {

        if (isEmpty()) {
            return null;
        }

        T rtn = head.getData();

        head = head.getNext();
        count--;

        // If removing this element made the queue empty
        // we need to make sure head and tail are both null
        if (count == 0) {
            head = tail = null;

        }
        return rtn;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return false;
    }

    public T queueHead() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }

    public void clear() {
        head = tail = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public String toString() {
        if (isEmpty()) {
            return "<Empty>";
        }

        String rtn = "";
        Node<T> tmp = head;
        while(tmp != null) {
            if (tmp == head) {
                rtn += "Head -> ";
            } else {
                rtn += "        ";
            }
            rtn += tmp.getData() + "\n";
            tmp = tmp.getNext();
        }
        return rtn;
    }
}