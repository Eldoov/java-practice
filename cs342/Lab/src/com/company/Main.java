package com.company;
/*Ivan Suriel email @surieliv@bu.edu
 *Zuowen Tang email zuowent@bu.edu
 * Zhonghao Zhao email zhaozhon@bu.edu
 * wei cheng email weich98@bu.edu
 * So the code was working before I tried to make it work for not a fixed number of the same type tellers
 * What is in here is my attempt to make it take multple different types of tellers
 */
public class Main {

    public static void main(String[] args) {
        for (int i=1; i<10; i++){
            System.out.printf("Printing out results for run %d\n", i);
            BankSim simulation=new BankSim(5, i);
        }

    }
}
