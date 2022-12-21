
public class LinkedList {

    private Node head;
    private Node tail;
    private int size;
    private LinkedList link;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int getSize(){
        return size;
    }

    public void addWord(String word) {
        if(isEmpty()) {
            Node newNode = new Node(word);
            newNode.next = head;
            head = newNode;
            newNode.copies = 0;
            size++;
            return;
        }
        Node current = head;
        boolean isCopy = true;
        while(!current.data.equals(word)){
            if(current.next == null){
                isCopy = false;
                break;
            }
            else
                current = current.next;
        }
        if(isCopy)
            current.copies += 1;
        else{
            Node newNode = new Node(word);
            newNode.next = head;
            head = newNode;
            newNode.copies = 0;
            size++;
        }
    }


    public Node get(int index){
        Node current = head;
        for(int i=0;i<index;i++)
            current = current.next;
        return current;
    }

    public Node find(String key){
        if(isEmpty())
            return null;
        Node current = head;
        while(!current.data.equals(key)){
            if(current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

}
