
package com.chuckle.chuckle;

import java.util.Random;

  //Here is the Dice class. It hold only one attribute for holding the dice value and 2 methods for rolling and
  //getting the value.
public class Dice {


    private int value;

    public Dice(int pValue) {
       value=pValue;
    }


    // this method creates one random Integer between 0-5 so I used ++ to bound it between 1-6
    public void rollDice () {
        Random rand = new Random();
        int rnd = rand.nextInt(6);
        value = ++rnd;
    }

    public int getValue ()
    {
        return value;
    }

}
