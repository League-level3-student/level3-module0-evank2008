package _00_Intro_To_Arrays;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
    // 1. make a main method
public static void main(String[] args) {
	Random ran = new Random();

        // 2. create an array of 5 robots.
Robot[] database = new Robot[5];
        // 3. use a for loop to initialize the robots.
for(int i = 0; i<database.length;i++) {
	database[i]=new Robot();
	database[i].setX(500);
	database[i].setY(500);
	database[i].setSpeed(25);
	database[i].setAngle(270);
}
boolean breakTime = false;
        // 4. make each robot start at the bottom of the screen, side by side, facing up
while(true) {
    for(Robot rob : database) {
    	rob.move(ran.nextInt(50));
    	rob.turn(5);
    	if(rob.getY()>490&&rob.getX()>500) {
    		rob.turn(720);
    		breakTime = true;
    		break;
    	}
    }
    if(breakTime) {
    	break;
    }
}
        // 5. use another for loop to iterate through the array and make each robot move
        // a random amount less than 50.
    
        // 6. use a while loop to repeat step 5 until a robot has reached the top of the
        // screen.
    
        // 7. declare that robot the winner and throw it a party!
    
        // 8. try different races with different amounts of robots.
    
        // 9. make the robots race around a circular track.
}
}
