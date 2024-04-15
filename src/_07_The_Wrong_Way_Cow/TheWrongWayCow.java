/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west).
 * 
 * ...w...
 * ..cow..
 * .woco..
 * .ow.c..
 * .c.....
*/

package _07_The_Wrong_Way_Cow;

import java.util.ArrayList;
//matrices have the y first
//matrix[y][x]
public class TheWrongWayCow {

	
	//HEY YOU FIGURE THIS OUT
	//WHY DO THE TESTS PASS show(field) INSTEAD OF JUST field EXPLAIN AAAAAAAAAAAAAAAA
	
static int north=1;
static int east=2;
static int south = 3;
static int west = 4;
static char cowHead = 'c';
static ArrayList<int[]> headLoci = new ArrayList<int[]>();
//contains x and y of all cow heads
static ArrayList<int[]> headBodyLoci = new ArrayList<int[]>();
static ArrayList<int[]> fullCowLoci = new ArrayList<int[]>();
static int[] wrongCowStripped = new int[2];
//contain x and y of cow heads and a variable for direction in which the rest is
    public static int[] findWrongWayCow(final char[][] field) {
  // Fill in the code to return the [col, row] coordinate position of the
        // head (letter 'c') of the wrong way cow!   	
    	findTheHeads(field);
    	//headLoci now contains coords of every c in the field
    	findTheBodies(field);
        //headBodyLoci now contains coords and direction for c+o
    	findTheTails(field);
    	//fullCowLoci now contains every cow location ad direction
    	//can i just check the directions to spot the oddster goofball
    	
    	//theWrongCowFull has 3 variables, make a new temporary int[] to remove the third 
    	wrongCowStripped[0]=theWrongCowFull()[0];
    	wrongCowStripped[1]=theWrongCowFull()[1];
       return wrongCowStripped;
    }
    static int[] theWrongCowFull() {
    	//this returns an int array of the entire row of fullCowLoci.
    	//Must strip the direction from it to submit.
    	int defaultDirection;
    	//store first direction
    	int firstDirection = fullCowLoci.get(0)[2];
    	//if second cow has same direction then that is default direction
    	int secondDirection = fullCowLoci.get(1)[2];
    	if(firstDirection==secondDirection) {
    		defaultDirection=firstDirection;
    	} else {
    		//first and second are different
    		//third is tiebreaker
    		int thirdDirection=fullCowLoci.get(2)[2];
    		if(firstDirection==thirdDirection) {
    			//second must be wrong
    			return fullCowLoci.get(1);
    		} else {
    			//first must be wrong
    			return fullCowLoci.get(0);
    		}
    	} 
    	//first 2 or 3 cows are same
    	//next cow to violate default direction is the one
    	for (int[] coords : fullCowLoci) {
    		int directionFaced = coords[2];
    		if(directionFaced!=defaultDirection) {
    			//first outlier cow
    			return coords;
    		}
    	}
    	
    	return null;
    }
    
    static void findTheHeads(char[][] field) {
    	int x=0;
        int y=0;
        for(int i = 0; i<field.length;i++) {
        	for(int j = 0; j<field[i].length;j++) {
        		if(field[i][j]==cowHead) {
        			x=i;
        			y=j;
        			headLoci.add(new int[] {x,y});
        		}
        	}
        }
    }
    
    static void findTheBodies(char[][] field) {
    	for(int[] coords : headLoci) {
    		int x = coords[0];
    		int y = coords[1];
    		if(getEastNeighbor(field,x,y)=='o') {
    			headBodyLoci.add(new int[] {x,y,east});
    		}
    		//not else bc a cow head could have multiple os coming off of it
    		if(getWestNeighbor(field,x,y)=='o') {
    			headBodyLoci.add(new int[] {x,y,west});
    		}
    		if(getNorthNeighbor(field,x,y)=='o') {
    			headBodyLoci.add(new int[] {x,y,north});
    		}
    		if(getSouthNeighbor(field,x,y)=='o') {
    			headBodyLoci.add(new int[] {x,y,south});
    		}
    		
    	}
    }
    
    static void findTheTails(char[][]field) {
    	for(int[] coords : headBodyLoci) {
    		int x = coords[0];
    		int y = coords[1];
    		switch(coords[2]) {
    		case 1:
    			//north
    			if(getNorthNeighbor(field,x,y)!='`') {
    				if(getNorthNeighbor(field,x,y-1)=='w') {
    					fullCowLoci.add(new int[] {x,y,north});
    				}
    			}
    			break;
    		case 2:
    			//east
    			if(getEastNeighbor(field,x,y)!='`') {
    				if(getEastNeighbor(field,x+1,y)=='w') {
    					fullCowLoci.add(new int[] {x,y,east});
    				}
    			}
    			break;
    		case 3:
    			//south
    			if(getSouthNeighbor(field,x,y)!='`') {
    				if(getSouthNeighbor(field,x,y+1)=='w') {
    					fullCowLoci.add(new int[] {x,y,south});
    				}
    			}
    			break;
    		case 4:
    			//west
    			if(getWestNeighbor(field,x,y)!='`') {
    				if(getWestNeighbor(field,x-1,y)=='w') {
    					fullCowLoci.add(new int[] {x,y,west});
    				}
    			}
    			break;
    		}
    	}
    }
    static public char getEastNeighbor(char[][] matrix, int x, int y) {
    	if(x+1>=matrix[y].length) {
    		System.out.println("east invalid y "+ y + " x " + x);
    		return '`';
    	}
    	else {
    		System.out.println("east valid y "+ y + " x " + x);
    		return matrix[y][x+1];
    	}
    }
    
    static public char getWestNeighbor(char[][] matrix, int x, int y) {
        
    	if(x<1) {
    		System.out.println("west invalid x "+ x + " y " + y);
    		return '`';
    	}
    	else {
    		System.out.println("west valid x "+ x + " y " + y);
    		return matrix[y][x-1];
    	}
    }
    
    static public char getNorthNeighbor(char[][] matrix, int x, int y) {
    	if(y<1) {
    		System.out.println("north invalid x"+ x + " y " + y);
    		return '`';
    	}
    	else {
    		System.out.println("north valid x "+ x + " y " + y);
    		return matrix[y-1][x];
    	}
    }
    
    static public char getSouthNeighbor(char[][] matrix, int x, int y) {
    	if(y+1>=matrix.length) {
    		System.out.println("south invalid x "+ x + " y " + y);
    		return '`';
    	}
    	else {
    		System.out.println("south valid x "+ x + " y " + y);
    		return matrix[y+1][x];
    	}
    }
}
