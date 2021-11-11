package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>(0);
        Random ran = new Random();
        Scanner cin = new Scanner(System.in);

        int guesses = 10;
        int upper = 1000;
        int result = ran.nextInt(upper);
        int flag = 0;

        System.out.println("You have " + guesses + " guesses!");

        while (guesses > 0) {
            System.out.print("Please select a value between 1 and " + upper + ": ");
            Integer guess = new Integer(cin.nextInt());
            list.add(guess);
            if (guess < result) {
                System.out.println("Aim higher!");
                guesses--;
            } else if (guess > result) {
                System.out.println("Aim lower!");
                guesses--;
            } else {
                flag = 1;
                break;
            }
        }
        printGuesses(list);

        if (flag == 0)
            System.out.println("Try harder next time!");
        else System.out.println("Good job!");
    }

    public static void printGuesses(ArrayList<Integer> list) {
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i).toString() + " ";
        }
        System.out.println("Your guesses were: " + res);
    }
}
