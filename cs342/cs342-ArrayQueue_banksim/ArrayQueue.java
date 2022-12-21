package edu.bu.met.cs342;

public class ArrayQueue {
    private static final int QUEUE_SIZE = 10;

    private int head;
    private int tail;
    private int count;
    private Integer []queue;

    public ArrayQueue() {
        queue = new Integer[QUEUE_SIZE];
        count = head = tail = 0;
    }

    public boolean add(Integer data) {
//		if (isFull()) {
//			// Queue is full, we can't add anything
//			return false;
//		}

        if (isFull()) {
            ensureCapacity(queue.length + QUEUE_SIZE);
        }

        queue[tail++] = data;

        // Cure any wrap that may have occurred.
        if (tail == queue.length) {
            tail = 0;
        }
        count++;
        return true;
    }

    public Integer remove() {
        if (isEmpty()) {
            // You can't remove from an empty queue
            return null;
        }

        Integer rtn = queue[head++];

        // Cure wrap.
        if (head == queue.length) {
            head = 0;
            System.out.println("Wrapped the queue");
        }
        count--;
        return rtn;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public boolean isFull() {
        return (count == queue.length);
    }

    public Integer queueHead() {
        if (isEmpty()) {
            return null;
        }
        return queue[head];
    }

    public void clear() {
        head = tail = count = 0;
    }

    public int size() {
        return count;
    }

    public int getCapacity() {
        return queue.length;
    }

    public void ensureCapacity(int max) {
        if (queue.length > max) {
            // We already have enough space.
            return;
        }

        alignCapacity(max);
    }

    private void alignCapacity(int max) {
        Integer []newQueue = new Integer[max];
        int newHead = 0;
        int newTail;
        int curHead = head;
        for (newTail = 0; newTail < count; newTail++ ) {
            newQueue[newTail] = queue[curHead++];

            if (curHead == queue.length) {
                curHead = 0;
            }
        }

        // Make the new Queue "THE" queue
        queue = newQueue;
        head = newHead;
        tail = newTail;
    }

    public void trimToSize() {
        alignCapacity(count);
    }

    public String toString() {
        if (isEmpty()) {
            return "<Empty>";
        }

        String rtn = "";

        rtn += "Head Index: " + head + "\n";
        rtn += "Tail Index: " + tail + "\n";
        rtn += "Count     : " + count + "\n";
        rtn += "Length    : " + queue.length + "\n";
        int tmp = head;
        for (int i = 0; i < count; i++) {
            if (tmp == head) {
                rtn += "Head -> ";
            } else {
                rtn += "        ";
            }
            rtn += queue[tmp] + "\n";
            tmp++;

            if (tmp == queue.length) {
                tmp = 0;
            }
        }
        return rtn;
    }


}
