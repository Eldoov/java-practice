package edu.bu.met.cs342;

public interface MyQueue {

    boolean add(Integer data);

    Integer remove();

    boolean isEmpty();

    boolean isFull();

    Integer queueHead();

    void clear();

    int size();

}
