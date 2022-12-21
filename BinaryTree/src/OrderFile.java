import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class OrderFile {
    private int size = 10000;
    private String index[] = new String[size];
    private int count;

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

    }

    public void add(String word){
        if(isFull()){ // Resize array when it's too small
            String tmp[] = new String[size*2];
            for(int i = 0; i < index.length; i++){
                tmp[i] = index[i];
            }
            index = tmp;
        }





    }

    public boolean isFull(){
        if(count == index.length){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(count == 0){
            return true;
        }
        return false;
    }

}
