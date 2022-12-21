import java.util.Scanner;
public class HashTableHW {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decision,key;
        String data;
        HashArray HashTable = new HashArray(24);

        System.out.println("Welcome to Hash Table. Please enter integer to decide what to do.");
        while(true){
            System.out.println("1.Put Data 2.Delete Data 3.Get Data 4.Does Contain 5.Print Hash Table 6.Quit");
            decision = scan.nextInt();

            switch (decision){
                case 1:
                    System.out.println("Please enter key:");
                    key = scan.nextInt();
                    System.out.println("Please enter data:");
                    data = scan.next();
                    HashTable.put(key,data);
                    System.out.println("Your data has been saved.\n");
                    break;
                case 2:
                    System.out.println("Please enter the key of the data you want to delete:");
                    key = scan.nextInt();
                    System.out.println(HashTable.delete(key) + "\n");
                    break;
                case 3:
                    System.out.println("Please enter the key of the data you want to get:");
                    key = scan.nextInt();
                    System.out.println("Data at key " + key + "is :" + HashTable.get(key) + "\n");
                    break;
                case 4:
                    System.out.println("Please enter key:");
                    key = scan.nextInt();
                    System.out.println(HashTable.contains(key) + "\n");
                    break;
                case 5:
                    HashTable.printHash();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Wrong number, please retry!\n");
                    break;
            }
        }

    }


}
