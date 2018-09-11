package com.chuckle.chuckle;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Main class of the program
    public static void main(String[] args) {

        //I created instances of dice
        // and an arraylist to store the sum of two dice's values

        Dice D1 = new Dice(1);
        Dice D2 = new Dice(1);
        ArrayList<Integer> sums = new ArrayList<Integer>();
        //scanner object is created and later instantiated to get an input from the keyboard
        Scanner keyboard ;


        int mInput=0;
        //in the while below I am making sure the user can only start a roll or exit the program. Every
        //other input is considered invalid

        while (mInput!=1) {
            System.out.println("Do you want to roll? (1=yes, 0=no)");
            keyboard = new Scanner(System.in);
            try {
                mInput = keyboard.nextInt();
                if(mInput==0)
                    break;
                else if(mInput!=1)
                    System.out.println("invalid input");
            }
            catch ( Exception e)
            {
                System.out.println("invalid input");
                mInput=0;
            }
        }



        //if the user decides to roll. Dices will role and the first sum of two values will be saved. If the sum is 11
        // the user get perfect score
        if (mInput==1) {
            D1.rollDice();
            D2.rollDice();

            System.out.println("Dice 1: "+String.valueOf(D1.getValue())+"\nDice 2: "+String.valueOf(D2.getValue()));

            Helper.addSum(sums,(D1.getValue()+D2.getValue()));
            if((D1.getValue()+D2.getValue())==11)
                System.out.println("Congratulations, you have perfect score!!!");


            //after the first roll, user has the choice to either continue with another roll of any or two
            //of the dices. The user can also see the sums or exit the program as well. All through the reRoll method.
            Helper.reRoll (D1,D2, sums);
        }



    }




}
