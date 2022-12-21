package edu.bu.met.cs342;

public class Main {

    public static void main(String[] args) {
	// write your code here
        test_stack();
        //check_palindromes();
        //test_rpn();
    }

    static void test_stack(){
        ArrayStack stack = new ArrayStack<Integer>();
        for(int i = 10; i < 200; i += 10){
            System.out.println(i);
            stack.push(i);
        }
        System.out.println(stack);
    }
    static void test_palindrome(String potenialPal){
        PalindromeChecker palTester = new PalindromeChecker();
        System.out.println(potenialPal);
        if(palTester.isPalendrome(potenialPal)) {
            System.out.println("Is a palindrome");
        } else {
            System.out.println("Is not a palindrome");
        }
    }

    static void check_palindromes(){
        String p1 = "A man, a plan, a canal, Panama.";
        test_palindrome(p1);
        p1 = "Are we not pure? No, sir! Panama's moody Noriega brags. It is garbage! Irony dooms a man a prisoner up to new era.";
        test_palindrome(p1);
    }

    static void test_rpn(){
        RPNCalc rpnCalc = new RPNCalc();

        rpnCalc.doRPN();
    }
}
