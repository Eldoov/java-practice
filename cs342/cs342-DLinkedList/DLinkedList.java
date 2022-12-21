package edu.bu.met.cs342;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLinkedList<T> implements Iterable<T>{
    private DNode<T> head;
    private DNode<T> tail;
    private int count;

    public void addToHead(T data) {
        // create the new node
        DNode<T> nn = new DNode<T>();
        // set the data
        nn.setData(data);

        // Special case when list is empty
        if (count == 0) {
            head = tail = nn;
            count = 1;
            return;
        }
        // make the new node point to the CURRENT head
        nn.setNext(head);
        // and the CURRENT head point back to the new node
        head.setPrev(nn);
        // now set the new node as the head
        head = nn;
        // keep an accurate count
        count++;
    }

    public void addToTail(T data) {
        DNode<T> nn = new DNode<T>();
        nn.setData(data);

        // Special case if it is the first thing added
        if (count == 0) {
            head = tail = nn;
            count = 1;
            return;
        }
        // Set the
        tail.setNext(nn);
        nn.setPrev(tail);
        tail = nn;
        count++;

    }

    public T removeFromHead() {
        // if nothing is there...
        if (count == 0) {
            return null;
        }

        // Copy the data
        T rtn = head.getData();
        // Special case if this is the last item
        if (count == 1) {
            head = tail = null;
            count = 0;
        } else {
            head = head.getNext(); // head is now removed
            // Remove reference to previous head
            head.setPrev(null);
            count--;
        }

        return rtn;
    }

    public T removeFromTail() {
        // empty case
        if (count == 0) {
            return null;
        }

        // Copy the data
        T rtn = tail.getData();
        // special case of only 1 item
        if (count == 1) {
            head = tail = null;
            count = 0;
        } else {
            tail = tail.getPrev(); // remove the tail
            tail.setNext(null); // tail next must be null
            count--; // keep count accurate
        }

        return rtn;
    }

    public boolean search(T data) {
        return (internalSearch(data) != null);
    }

    private DNode<T> internalSearch(T data) {
        DNode<T> tmp = head;
        while(tmp != null) {
            if (tmp.getData().equals(data)) {
                return tmp;
            }

            tmp = tmp.getNext();
        }

        return null;
    }

    public T delete(T target) {
        // Empty List
        if (count == 0) {
            return null;
        }

        DNode<T> targetNode = internalSearch(target);
        // Target does not exist
        if (targetNode == null) {
            return null;
        }

        T rtn = targetNode.getData();

        // Special case "Only Node"
        if (count == 1) {
            count = 0;
            head = tail = null;
            return rtn;
        }

        // Handle the head case
        if (targetNode == head) {
            head = head.getNext();
            head.setPrev(null);
            count--;
            return rtn;
        }

        // Handle tail case
        if (targetNode == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
            count--;
            return rtn;
        }

        // General case
        // Handle the previous node
        targetNode.getPrev().setNext(targetNode.getNext());

        // Handle the next node
        targetNode.getNext().setPrev(targetNode.getPrev());
        count--;
        return rtn;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        // build the forward chain

        if (count == 0) {
            return "<Empty>";
        }

        String rtn = "";
        DNode<T> tmp = head;
        rtn += "head -> ";
        while(tmp != null) {
            rtn += tmp.getData() + " -> ";
            tmp = tmp.getNext();
        }
        rtn += "null\n";

        // Here's the back chain
        tmp = tail;
        rtn += "tail -> ";
        while(tmp != null) {
            rtn += tmp.getData() + " -> ";
            tmp = tmp.getPrev();
        }
        rtn += "null\n";

        return rtn;
    }

    //////////////////////////////////////////
    /// Code to use for Iterators.
    //////////////////////////////////////////

    public class myIterator<I> implements Iterator<I> {
        // The iterator, or pointer, in the linked list
        private DNode<I> iterator = null;

        @SuppressWarnings(value = "unchecked")
        public myIterator() {
            iterator = (DNode<I>) head;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub

            if (iterator == null) {
                // empty list
                return false;
            }

            return true;

        }

        @Override
        public I next() throws NoSuchElementException {
            I result;
            // TODO Auto-generated method stub
            if (iterator == null) {
                throw new NoSuchElementException();
            } else {
                I rtn = iterator.getData();
                iterator = iterator.getNext();
                result = rtn;
            }
            return result;
        }

    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new myIterator<T>();
    }

}

