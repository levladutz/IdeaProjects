package com.company;
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        Scanner fin = new Scanner(new File("words.txt"));
        Vector<String> words = new Vector<String>();

        while (fin.hasNext()) {
            words.add(fin.next());
        }
        String word = randomWord(words);
        String display ="";
        for(int i=0 ;i<word.length();i++)
            display +="_";
        System.out.println(display);
        int lives=5;
        while(lives > 0)
        {
            String letter = cin.next();
            letter = letter.substring(0,0);

            if(word.contains(letter)) {
                String newDisplay="";

                for(int i=0;i<word.length();i++)
                if(word.charAt(i)==letter.charAt(0))
                    newDisplay+=letter;
                else newDisplay+=display.charAt(i);

                display=newDisplay;
            }
            else
                lives--;

            System.out.println(display);
        }
    }
    static private String randomWord(  Vector<String> a){
        String word = "";
        Random random = new Random();
        int randomIndex = random.nextInt(a.size());
        word = a.get(randomIndex);
        return word;
    }


    }

