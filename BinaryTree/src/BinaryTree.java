import jdk.incubator.vector.VectorOperators;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BinaryTree {
    private Node root;
    private int TotalCount = 0;

    public BinaryTree(String fileName) throws Exception {
        readFile(fileName);
    }

    public void readFile(String fileName) throws Exception{ // read files
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        Scanner scan = new Scanner(file);

        while(scan.hasNext()) {
            String originLine = scan.nextLine();
            String line = originLine.toLowerCase().replaceAll("[^a-zA-Z0-9 ]","");
            if(!line.equals("")) {
                String array[] = line.split("\\s+"); // create array based on space
                for(int i = 0; i < array.length; i++) {
                    // add word to Binary Tree
                    add(array[i]);
                }
            }
        }

        System.out.println("all good");

    }

    public void add(String word){
        if(root == null){ // if root is empty
            root.setData(word);
            TotalCount++;
        }else{
            recursiveAdd(root, word);
        }
    }

    public void recursiveAdd(Node n, String word){
        if(n.getData().compareToIgnoreCase(word) < 0){ // alphabetically ordered
            if(n.LChild == null){
                n = new Node(word); // set data if n is null
            }else{
                recursiveAdd(n.getLChild(), word); // if n is not null, start a recursion
            }
        }

        if(n.getData().compareToIgnoreCase(word) > 0){ // alphabetically ordered
            if(n.RChild == null){
                n = new Node(word);
            }else{
                recursiveAdd(n.getRChild(),word);
            }
        }

        if(n.getData().compareToIgnoreCase(word) == 0){ // found duplicates
            n.copies++;
        }
        TotalCount++; // count total words
    }

    public int BinarySearch(Node n, String target){
        if(n == null){ // if node is null
            return 0;
        }
        if(n.getData() == target){
            return n.copies;
        }
        // recur on left subtree
        int leftsub = BinarySearch(n.LChild, target);
        if(leftsub != 0){
            return leftsub;
        }

        // recur on right subtree
        int rightsub = BinarySearch(n.RChild, target);
        if(rightsub != 0){
            return rightsub;
        }

        return 0;
    }


    public int countNode(Node n){
        if(n == null){ // if root is null, return 0
            return 0;
        }
        return 1 + countNode(n.RChild) + countNode(n.LChild); // recur to count total num of nodes
    }


}
