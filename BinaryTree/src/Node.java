public class Node {

    Node LChild, RChild;
    Node next;
    String data;
    int copies = 0;

    public Node(String data){
        this.data = data;
        LChild = null;
        RChild = null;
    }

    public String getData(){
        return data;
    }

    public void setData(String data){
        this.data = data;
    }

    public Node getLChild(){
        return LChild;
    }

    public Node getRChild(){
        return RChild;
    }

    public void setLChild(Node LChild){
        this.LChild = LChild;
    }

    public void setRChild(Node RChild){
        this.RChild = RChild;
    }



}