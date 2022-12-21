/*
 * Text Parser
 * By: Zuowen Tang
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TextParser {

    public static void getFile(String fileName) throws Exception {
        BufferedReader file = new BufferedReader(new FileReader(fileName)); // read file
        Scanner scan = new Scanner(file);
        LinkedList list = new LinkedList();

        // map all words to lower case and remove punctuation
        while(scan.hasNext()) {
            String originLine = scan.nextLine();
            String line = originLine.toLowerCase().replaceAll("[^a-zA-Z0-9 ]","");
            if(!line.equals("")) {
                String array[] = line.split("\\s+"); // create array based on space
                for(int i = 0; i < array.length; i++) {
                    list.addWord(array[i]); // add word to linkedlist
                }
            }
        }


    }

}
