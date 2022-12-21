package edu.bu.met.cs342;

public class LinkedList {
    private Node head;
    private int count;

    public void addToHead(Integer data) {

        Node newGuy = new Node();
        newGuy.setData(data);

        newGuy.setNext(head);
        count++;

        head = newGuy;
    }

    public Integer removeFromHead() {
        // If the list is empty return null
        if (count == 0) {
            return null;
        }

        Integer tmp = head.getData();
        head = head.getNext();
        count--;

        return tmp;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void clear() {
        count = 0;
        head = null;
    }

    public int size() {
        return count;
    }

    public boolean addAfter(Integer target, Integer dataToAdd) {

        Node n = internalSearch(target);

        // if n is null, data not found
        if (n == null) {
            return false;
        }

        Node nn = new Node();
        nn.setData(dataToAdd);

        nn.setNext(n.getNext());
        n.setNext(nn);
        count++;

        return true;
    }

    public Integer deleteAfter(Integer target) {

        Node n = internalSearch(target);

        // if n is null, data not found
        if (n == null) {
            return null;
        }

        // If the next node is nonexistent, we will just return null
        if (n.getNext() == null) {
            return null;
        }

        Integer rtn = n.getNext().getData();

        n.setNext(n.getNext().getNext());
        count--;

        return rtn;
    }

    public boolean addBefore(Integer target, Integer dataToAdd) {

        Node prev = null;
        Node cur = head;
        while(cur != null) {
            if (cur.getData().equals(target)) {
                // We found it, add before this

                Node nn = new Node();
                nn.setData(dataToAdd);

                if (prev == null) {
                    // target was the head of the list
                    addToHead(dataToAdd);
                    return true;
                }

                // Otherwise add it based on prev
                nn.setNext(cur);
                prev.setNext(nn);

                count++;
                return true;
            }

            prev = cur;
            cur = cur.getNext();
        }

        return false;
    }

    public Integer delete(Integer target) {
        // Make sure the data is there.
        Node t = internalSearch(target);
        if (t == null) {
            return null;
        }

        // First find the previous Node to the target
        Node p = prevSearch(target);
        if (p == null) {
            // data is in head of list
            return removeFromHead();
        }

        Integer rtn = t.getData();
        p.setNext(t.getNext());

        return rtn;
    }

    public Integer deleteBefore(Integer target) {
        // Make sure the data is there.
        Node t = internalSearch(target);
        if (t == null) {
            return null;
        }

        // First find the previous Node to the target
        Node p = prevSearch(target);
        if (p == null) {
            // data is in head of list
            // can't delete previous
            return null;
        }

        // Now, find the previous Node to the Previous Node (pp)
        Node pp = prevSearch(p.getData());

        if (pp == null) {
            // This means that the previous to the target (p) is the head of the list
            return removeFromHead();
        }

        // Remove Node p from the list by making pp.next refer to t;
        Integer rtn = p.getData();
        pp.setNext(t);
        count--;

        return rtn;

    }

    public boolean search(Integer data) {
        return (internalSearch(data) != null);
    }

    private Node internalSearch(Integer data) {
        // Can't find data in an empty list
        if (count == 0) {
            return null;
        }

        Node tmp = head;
        while(tmp != null) {
            if (tmp.getData().equals(data)) {
                return tmp;
            }

            tmp = tmp.getNext();
        }

        return null;
    }

    public int countOccurrences(Integer target) {
        int cnt = 0;
        Node tmp = head;
        while (tmp != null) {
            if (tmp.getData().equals(target)) {
                count++;
            }

            tmp = tmp.getNext();
        }

        return cnt;
    }

    // This is predicated on the data existing in the list.
    private Node prevSearch(Integer target) {

        Node prev = null;
        Node cur = head;
        while(cur != null) {
            if (cur.getData().equals(target)) {
                return prev;
            }

            prev = cur;
            cur = cur.getNext();
        }

        // SHOULD NEVER HAPPEN
        return null;
    }

    public String toString() {
        String rtn = "";

        if (count == 0) {
            rtn = "<Empty>";
        } else {
            Node tmp = head;
            while(tmp != null) {
                rtn += "<" + tmp.getData() + "> -> ";
                tmp = tmp.getNext();
            }

            rtn += "null";
        }

        return rtn;
    }

    public LinkedList clone() {
        LinkedList newList = new LinkedList();

        newList.head = null;
        Node cloneLastNode = null;
        Node srcNode = head;
        while (srcNode != null) {
            Node nn = new Node();
            nn.setData(srcNode.getData());
            if (newList.head == null) {
                newList.head = nn;
                cloneLastNode = nn;
            } else {
                cloneLastNode.setNext(nn);
                cloneLastNode = cloneLastNode.getNext();
            }
        }
        newList.count = count;
        return newList;
    }


}
