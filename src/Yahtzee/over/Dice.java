package Yahtzee.over;

import java.util.*;

public class Dice {
	//instance variables
	private int value;
	  private Random rand;
	
	  //constructor
	  public Dice() {
	    value = 0;
	    rand = new Random();
	  }
	 
	  //method that rolls the dice
	  public void roll() {
	    value = 1 + rand.nextInt(6);
	  }
	 
	  //method that gets the roll
	  public int get() {
	    return (value);
	  }
}
