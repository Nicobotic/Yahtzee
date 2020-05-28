package Yahtzee.view;
import javax.swing.*;

public class Window {
    
	//method that shows a message
	public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

	//method to display dialog
    public String in(String msg) {
        return JOptionPane.showInputDialog(msg);
    }
    
    //method to display a message with options
    public int option(String[] options, String msg) {
        return JOptionPane.showOptionDialog(
                null, 
                msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
    }
    
    //methods that prints a string and then skips a line
    public void println(String msg) {
        System.out.println(msg);
    }
    
    //method that prints a string
    public void print(String msg) {
        System.out.println(msg);
    }
    
    //same three methods as the others with the same name except they use objects instead of strings in the parameter
    public void msg(Object msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public String in(Object msg) {
        return JOptionPane.showInputDialog(msg);
    }

    public int option(Object[] options, Object msg) {
        return JOptionPane.showOptionDialog(
                null, 
                msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
    }
}
