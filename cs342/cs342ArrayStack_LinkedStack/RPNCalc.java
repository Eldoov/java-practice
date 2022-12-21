package edu.bu.met.cs342;
import java.util.Scanner;

public class RPNCalc {
    ArrayStack<Double> stack = new ArrayStack<Double>();

    public void doRPN() {
        //static String help_txt = "supported operands + - * / =";
        Scanner kbd = new Scanner(System.in);
        boolean done = false;
        String input;
        String input2;
        Double result;

        while(!done) {
            System.out.print("Enter command or (H for help)\n-> ");
            input = kbd.nextLine();

            input2 = input.toLowerCase();

            switch(input2) {

                case "q":
                    System.out.println("Bye...");
                    done = true;
                    break;

                case "h":
                    System.out.println("Help yourself");
                    break;

                case "=":
                    System.out.println(stack.peek());

                    break;

                case "c":
                    stack.clear();
                    break;

                case "p":
                    System.out.println(stack);
                    break;

                case "+":
                    if (stack.size() < 2) {
                        System.out.println("Insufficient Arguments");
                        break;
                    }

                    result = stack.pop() + stack.pop();
                    stack.push(result);
                    break;

                case "*":
                    if (stack.size() < 2) {
                        System.out.println("Insufficient Arguments");
                        break;
                    }

                    result = stack.pop() * stack.pop();
                    stack.push(result);
                    break;

                case "-": {
                    if (stack.size() < 2) {
                        System.out.println("Insufficient Arguments");
                        break;
                    }
                    Double arg1 = stack.pop();
                    Double arg2 = stack.pop();

                    result = arg2 - arg1;
                    stack.push(result);
                }
                break;

                case "/": {
                    if (stack.size() < 2) {
                        System.out.println("Insufficient Arguments");
                        break;
                    }
                    Double arg1 = stack.pop();
                    if (arg1.equals(0.0)) {
                        System.out.println("Division by 0 Error");
                        stack.push(arg1);
                        break;
                    }
                    Double arg2 = stack.pop();

                    result = arg2 / arg1;
                    stack.push(result);
                }
                break;


                default:
                    try {
                        Double val = Double.parseDouble(input2);
                        stack.push(val);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid command (" + input + ")");
                    }
                    break;
            }

        }
    }
}
