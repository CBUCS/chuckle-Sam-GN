package com.chuckle.chuckle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Helper {
    //this class is a set of methods that help the main program do its job.
    //I decided to put them in a separate class for ease of use for later projects





    public static void reRoll (Dice pD1, Dice pD2, ArrayList<Integer> pSums)
    {
        //this method gets two dices and the arraylist of sums as params.
        //It makes sure the user can't input invalid characters.
        //It responses with the appropriate action to the user's input.
        // If in one of the rerolls the sum is 11, user gets a message.
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What do you want to do?\n(1: Roll Dice 1, 2: Roll Dice 2, 3: Roll Both, 4: Show Sums, 0: 0Exit)");
        int mInput=0;
        try {
            mInput = keyboard.nextInt();
        }
        catch ( Exception e)
        {
            System.out.println("invalid input");
            reRoll(pD1,pD2,pSums);
        }
        switch (mInput)
        {
            case 1: //for reroll of dice 1
                pD1.rollDice();
                System.out.println("Dice 1: "+String.valueOf(pD1.getValue())+"\nDice 2: "+String.valueOf(pD2.getValue()));
                if((pD1.getValue()+pD2.getValue())==11)
                    System.out.println("Congratulations, you have perfect score!!!");
                Helper.addSum(pSums,(pD1.getValue()+pD2.getValue()));
                reRoll(pD1,pD2,pSums);
                break;

            case 2://for reroll of dice 2
                pD2.rollDice();
                System.out.println("Dice 1: "+String.valueOf(pD1.getValue())+"\nDice 2: "+String.valueOf(pD2.getValue()));
                if((pD1.getValue()+pD2.getValue())==11)
                    System.out.println("Congratulations, you have perfect score!!!");
                Helper.addSum(pSums,(pD1.getValue()+pD2.getValue()));
                reRoll(pD1,pD2,pSums);
                break;

            case 3://for reroll of both dices
                pD1.rollDice();
                pD2.rollDice();
                System.out.println("Dice 1: "+String.valueOf(pD1.getValue())+"\nDice 2: "+String.valueOf(pD2.getValue()));
                if((pD1.getValue()+pD2.getValue())==11)
                    System.out.println("Congratulations, you have perfect score!!!");
                Helper.addSum(pSums,(pD1.getValue()+pD2.getValue()));
                reRoll(pD1,pD2,pSums);
                break;

            case 4:// for showing the sum of dices thus far
                Collections.sort(pSums);// to sort the values of sums in an ascending order
                for(Integer i :pSums )
                    //System.out.println(String.valueOf(pSums.get(i)));
                    System.out.println("Sum of " +
                            "attempt "+String.valueOf(pSums.indexOf(i)+1)+": "+i+",");
                reRoll(pD1,pD2,pSums);
                break;

            case 0://for exiting the program
                break;

            default: System.out.println("invalid input"); //every other input is considered invalid.
                reRoll(pD1,pD2,pSums);
                break;

        }
    }






    //This method receives an arraylist of sums and the sum of two dice as parameters. It first looks to see
    //if the list already has that value, if not it will add it.
    public static void addSum (ArrayList<Integer> pSums, int pSumOfDice)
    {
        if(pSums.isEmpty())
        {
            pSums.add(pSumOfDice);
        }
        else if(!pSums.contains(pSumOfDice))
        {
            pSums.add(pSumOfDice);
        }
    }
}
