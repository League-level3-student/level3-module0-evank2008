package _00_Intro_To_Arrays;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* Run the FindHiddenButton.jar to see the finished product. */

public class _03_FindTheHiddenButton implements ActionListener{
    JFrame window;
    JPanel panel;
    

    // 1. create an array of JButtons. Don't initialize it yet.
JButton[] buttons;
    // 2. create an integer variable called hiddenButton
int hiddenButton;
    public static void main(String[] args) {
        new _03_FindTheHiddenButton().start();
    }

    public void start() {
    	Random ran = new Random();
        window = new JFrame("Find the Button");
        panel = new JPanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Ask the user to enter a positive number and convert it to an int
int userNumber = Integer.valueOf(JOptionPane.showInputDialog("number?"));
        // 4. Initialize the array of JButtons to be the size of the int
        //    created in step 3
buttons = new JButton[userNumber];
        // 5. Make a for loop to iterate through the JButton array
        for(JButton b:buttons) {
        	b = new JButton();
        	b.addActionListener(this);
        	panel.add(b);
        }
        window.add(panel);
            // 6. initialize each JButton in the array
        
            // 7. add the ActionListener to each JButton
        
            // 8. add each JButton to the panel

        // 9 add the panel to the window

        // 10. call setExtendedState(JFrame.MAXIMIZED_BOTH) on your JFrame object.
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // 11. set the JFrame to visible.
        window.setVisible(true);
        // 12. Give the user the instructions for the game.
        JOptionPane.showMessageDialog(null, "button is somewhere. find!");
        // 13. initialize the hiddenButton variable to a random number less than
        //     the int created in step 3
        hiddenButton = ran.nextInt(5);
        // 14. Set the text of the JButton located at hiddenButton to read "ME"
        buttons[hiddenButton].setText("ME");
        // 15. Use Thread.sleep(100); to pause the program.
       
        // 16. Set the text of the JButton located at hiddenButton to be blank.
       // buttons[hiddenButton].setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton)e.getSource();

        // 17. if the hiddenButton is clicked, tell the user that they win.
        if(e.getSource()==buttons[hiddenButton]) {
        	System.exit(0);
        } else {
        	System.out.println("no");
        }
        // 18. else tell them to try again
    }
}
