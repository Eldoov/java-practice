/**
 * Name: Zuowen Tang
 * Date: 1/30/2023
 * Course: CS-622 Spring 2023
 * Assignment 2
 * Description: This file contains a keyword searching engine for a certain file.
 *              The program will ask the user to enter a keyword and searching for it in the file.
 *              The result shows the title that contains the given keyword and information of related
 *              funds raised percent, close date, and tag line.
 */

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class assignment2 {
    public static void main(String[] args) throws IOException {
        Scanner file = null;
        try{
            file = new Scanner(new File("./file.txt")); // Read the given file.
        }catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }

        Scanner input = new Scanner(System.in);
        int inputSearchCount = 1; // The default setting of how many results are shown.
                                    // The user can change it below in the program.

        System.out.println("Enter the keyword you want to search:");
        String keyWord = input.nextLine();

        // Ask user to enter an integer for how many results they want to see.
        while (true){
            try {
                Scanner inputInt = new Scanner(System.in);
                System.out.println("How many results you want to shown?");
                inputSearchCount = inputInt.nextInt();
                break;
            }catch (InputMismatchException e){ // If user enters a non-integer, ask them to do it again.
                System.out.println("Please only enters numbers.");
            }
        }

        System.out.println();
        System.out.println("----------------------------------------");

        int totalSearch = 0; // Initiate the total number of how many times have searched.
        boolean isFound = false; // Initiate the boolean value to see if the given keyword is found in file.

        // Start searching the given keyword.
        while (file.hasNextLine()){
            final String lineFromFile = file.nextLine();

            // The program only searches the title column for given keyword.
            Matcher matcher = Pattern.compile("\"title\":\"(.*?)"+ keyWord +"(.*?)\"", Pattern.CASE_INSENSITIVE).matcher(lineFromFile);

            if(matcher.find()) { // A match has found!
                isFound = true;
                inputSearchCount--; // Keep tracking how many results user wants.
                totalSearch++;

                // Prepare to output the result, start from the title:
                String title = matcher.group(1) + keyWord + matcher.group(2);
                System.out.println("Result found:\s\s\s\s\s\s\s\s\s\s\s\s" + title);

                // Searching for the close_date, the fund_raised_percent, and the tagline in the same line.
                Matcher closeDate = Pattern.compile("\"close_date\":\"(.*?)\"", Pattern.CASE_INSENSITIVE).matcher(lineFromFile);
                Matcher funds = Pattern.compile("\"funds_raised_percent\":(.*?),", Pattern.CASE_INSENSITIVE).matcher(lineFromFile);
                Matcher tagLine = Pattern.compile("\"tagline\":\"(.*?)\",", Pattern.CASE_INSENSITIVE).matcher(lineFromFile);
                funds.find();
                closeDate.find();
                tagLine.find();

                // In case the related data is missing, initiate exceptions.
                // Add spaces so the results look better.
                try{
                    System.out.println("Funds Raised Percent:\s\s\s\s"+funds.group(1));

                }catch (IllegalStateException e){
                    System.out.println("Funds Raised Percent:\s\s\s\sData Missing.");
                }

                try{
                    System.out.println("Close Date:\s\s\s\s\s\s\s\s\s\s\s\s\s\s"+closeDate.group(1));
                }catch (IllegalStateException e){
                    System.out.println("Close Date:\s\s\s\s\s\s\s\s\s\s\s\s\s\sData Missing.");
                }

                try{
                    System.out.println("Tag Line:\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s"+tagLine.group(1));
                }catch (IllegalStateException e){
                    System.out.println("Tag Line:\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\sData Missing.");
                }

                System.out.println();

            }

            // If there has no match for the given keyword at all, output following message.
            if (!matcher.find() && !file.hasNextLine() && !isFound){
                System.out.println("No such match. Please enter a different keyword.");
            }

            // If the program outputs enough results user wants, break the loop.
            if (inputSearchCount == 0){
                break;
            }
        }

        // Output how many times the program has run.
        System.out.println("Total " +totalSearch+ " results are shown.");
        System.out.println("----------------------------------------");
    }

}
