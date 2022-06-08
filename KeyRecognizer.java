/*
 * This class tests for pressed and holded keys in a window. I have no idea if that makes scence or if that even works. Good luck tho.
 * 
 * Version:     0.0.1
 * 
 * Author:       dennismeide.tk
*/

import java.awt.*;
import java.awt.event.*;

class KeyRecognizer implements KeyListener 
{    
    boolean[] wasdArray = new boolean[5];
    boolean diagnosticMode = true; //make sure this is turned of before using this program
    
    public KeyRecognizer() {
        if(diagnosticMode) System.out.println("Start");
        for(int i = 0 ; i<wasdArray.length ; i++) 
        {
            wasdArray[i] = false;
        }
    }
    
    //method to see, when key is pressed
    @Override
    public void keyPressed(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_DELETE) 
        {
            if(diagnosticMode) System.out.println("You pressed 'DELETE' -> End of program");
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_W && !wasdArray[0]) 
        {
            wasdArray[0] = true;
            if(diagnosticMode) System.out.println("W: " + wasdArray[0]);
        } 
        else if(e.getKeyCode() == KeyEvent.VK_A && !wasdArray[1]) 
        {
            wasdArray[1] = true;
            if(diagnosticMode) System.out.println("A: " + wasdArray[1]);
        }
        else if(e.getKeyCode() == KeyEvent.VK_S && !wasdArray[2]) 
        {
            wasdArray[2] = true;
            if(diagnosticMode) System.out.println("S: " + wasdArray[2]);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D && !wasdArray[3]) 
        {
            wasdArray[3] = true;
            if(diagnosticMode) System.out.println("D: " + wasdArray[3]);
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE && !wasdArray[4]) 
        {
            wasdArray[4] = true;
            if(diagnosticMode) System.out.println(" : " + wasdArray[4]);
        }
    }

    //will later be implemented
    @Override
	public void keyReleased(KeyEvent e)
	{
        if(e.getKeyCode() == KeyEvent.VK_W && wasdArray[0]) 
        {
            wasdArray[0] = false;
            if(diagnosticMode) System.out.println("W: " + wasdArray[0]);
        } 
        else if(e.getKeyCode() == KeyEvent.VK_A && wasdArray[1]) 
        {
            wasdArray[1] = false;
            if(diagnosticMode) System.out.println("A: " + wasdArray[1]);
        }
        else if(e.getKeyCode() == KeyEvent.VK_S && wasdArray[2]) 
        {
            wasdArray[2] = false;
            if(diagnosticMode) System.out.println("S: " + wasdArray[2]);
        }
        else if(e.getKeyCode() == KeyEvent.VK_D && wasdArray[3]) 
        {
            wasdArray[3] = false;
            if(diagnosticMode) System.out.println("D: " + wasdArray[3]);
        }
        else if(e.getKeyCode() == KeyEvent.VK_SPACE && wasdArray[4]) 
        {
            wasdArray[4] = false;
            if(diagnosticMode) System.out.println(" : " + wasdArray[4]);
        }
    }
	@Override
	public void keyTyped(KeyEvent e)
	{}

    public boolean returnStatus(char wasdAndSpace) 
    {
        boolean ans = false;
        switch (wasdAndSpace) 
        {
            //looking for the char and checking status
            case 'w': 
                ans = wasdArray[0];
                break;
            case 'a': 
                ans = wasdArray[1];
                break;
            case 's': 
            ans = wasdArray[2];
                break;
            case 'd': 
                ans = wasdArray[3];
                break;
            case ' ': 
                ans = wasdArray[4];
                break;
                default:
                System.out.println("ERROR in KeyRecognizer.returnStatuus(char wasd)");
                System.out.println("ERROR key not found. use 'w','a','s', or 'd'");
                System.out.println("ERROR returning 'false'.");
                System.err.println("------------------------------------------------------------");
                break;
        }
        return ans;
    }

    public static void main(String[] args) 
    {
        //creating a test Frame 
        Frame frame = new Frame("Recognizer Test");
        frame.setSize(200, 200);
        frame.setVisible(true);

        //creating Recognizer and running it
        KeyRecognizer kR = new KeyRecognizer();
        frame.addKeyListener(kR);
    }
}