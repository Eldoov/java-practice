package edu.bu.met.cs342;

public class PalindromeChecker {
    private ArrayStack stack = new ArrayStack<Character>();

    /**
     * prepString removes all white space and special characters
     * and makes all lower case for comparision with reversed string
     * @param original the original string to prepare
     * @return the string to lower case without special characters or spaces
     */
    private String prepString(String original){
        String prepString = "";

        for (int i=0; i< original.length(); ++i){
            Character x = original.charAt(i);
            x = Character.toLowerCase(x);
            if (Character.isAlphabetic(x) || Character.isDigit(x)){
                prepString += x;
            }
        }
        return prepString;
    }

    /**
     * isPalendrome will check if the string is a palendrome.
     * @param original The original string to check
     * @return true if it is a palendrom, false otherwise.
     */
    public boolean isPalendrome(String original){
        String prepString = prepString(original);
        for(int i=0; i< prepString.length(); ++i){
            stack.push(prepString.charAt(i));
        }
        String revString = "";
        while(!stack.isEmpty()){
            revString += stack.pop();
        }
        //System.out.println(revString);
        //System.out.println(prepString);
        if(revString.equals(prepString)){
            return true;
        }
        return false;
    }

}
