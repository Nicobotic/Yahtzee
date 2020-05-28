package Yahtzee.cont;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.*;
import Yahtzee.view.*;
import java.util.*;
import Yahtzee.over.*;

public class MiniYahtzee {
	//instance variables
    static Window bruh;
    static String[] NUMS;
    static String[] YES;
    
    //options
    static {
        MiniYahtzee.NUMS = new String[] { "0", "1", "2", "3", "4", "5" };
        MiniYahtzee.YES = new String[] { "QUIT", "CONTINUE PLAYING" };
        MiniYahtzee.bruh = new Window();
    }
    
    //main method
    public static void main(final String[] args) {
        int play = 1;
        int scorea = 0;
        int sum = 0;
        final int[] wins = new int[15];
        while (play == 1 && sum < 15) {
            sum = 0;
            final int[] aDice = new int[5];
            int roll = 0;
            int rerolla = 0;
            int rerollb = 3;
            final Dice die = new Dice();
            for (int x = 0; x < 5; ++x) {
                die.roll();
                aDice[x] = die.get();
            }
            bruh.msg("Remember your dice as you will only get to see them once");
            bruh.msg("Die 1: " + aDice[0] + "          Die 2: " + aDice[1] + "          Die 3: " + aDice[2] + "          Die 4: " + aDice[3] + "          Die 5: " + aDice[4]);
            do {
                rerolla = bruh.option(MiniYahtzee.NUMS, "How many dice do you want to reroll?");
                if (rerolla > 0) {
                    final int[] reroll = new int[rerolla];
                    for (int y = 0; y < rerolla; ++y) {
                        rerollb = bruh.option(MiniYahtzee.NUMS, "Which dice?");
                        reroll[y] = rerollb;
                    }
                    for (int w = 0; w < rerolla; ++w) {
                        if (reroll[w] == 1) {
                            die.roll();
                            aDice[0] = die.get();
                        }
                        if (reroll[w] == 2) {
                            die.roll();
                            aDice[1] = die.get();
                        }
                        if (reroll[w] == 3) {
                            die.roll();
                            aDice[2] = die.get();
                        }
                        if (reroll[w] == 4) {
                            die.roll();
                            aDice[3] = die.get();
                        }
                        if (reroll[w] == 5) {
                            die.roll();
                            aDice[4] = die.get();
                        }
                    }
                    ++roll;
                    bruh.msg("Die 1: " + aDice[0] + "          Die 2: " + aDice[1] + "          Die 3: " + aDice[2] + "          Die 4: " + aDice[3] + "          Die 5: " + aDice[4]);
                }
            } while (roll < 2 && rerolla > 0);
            final Winnings prize = new Winnings();
            prize.checkWinnings(aDice, wins);
            if (prize.choice() == 0) {
                bruh.msg("You quit Yahtzee.");
                break;
            }
            wins[prize.choice() - 1] = 1;
            for (int z = 0; z < 15; ++z) {
                sum += wins[z];
            }
            scorea += prize.score();
            bruh.msg("Your total score this game was: " + scorea);
            if (sum < 15) {
                play = bruh.option(MiniYahtzee.YES, "Do you want to continue playing?");
            }
            else {
                bruh.msg("GAME OVER!");
            }
        }
    }
    
    
    static int inputInt(final String Prompt) {
        int result = 0;
        try {
            result = Integer.parseInt(input(Prompt).trim());
        }
        catch (Exception e) {
            result = 0;
        }
        return result;
    }
    
    static String input(final String prompt) {
        String inputLine = "";
        System.out.print(prompt);
        try {
            final InputStreamReader sys = new InputStreamReader(System.in);
            final BufferedReader inBuffer = new BufferedReader(sys);
            inputLine = inBuffer.readLine();
        }
        catch (Exception e) {
            final String err = e.toString();
            System.out.print(err);
        }
        return inputLine;
    }
}
