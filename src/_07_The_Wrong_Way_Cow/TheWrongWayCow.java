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

public class TheWrongWayCow {
 //make a separate 2d array to find all instances of c DONE
//then make an array to find os next to cs             IN PROGRESS - LINE 98
//then an array to find ws next to both
//have array of all 'cow's
//find the one that is different from the rest
	
	//to store x and y of every c in the field
static int north=1;
static int east=2;
static int south = 3;
static int west = 4;
static char cowHead = 'c';
static ArrayList<int[]> headLoci = new ArrayList<int[]>();
static ArrayList<int[]> headBodyLoci = new ArrayList<int[]>();
    public static int[] findWrongWayCow(final char[][] field) {
    	
    	findTheHeads(field);
    	//headLoci now contains coords of every c in the field
    	findTheBodies(field);
        // Fill in the code to return the [col, row] coordinate position of the
        // head (letter 'c') of the wrong way cow!
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
    		//ADD CODE HERE BOI
    		
    		
    	}
    }
    
    static public char getEastNeighbor(char[][] matrix, int row, int col) {
    	if(col+1>=matrix[row].length) {
    		System.out.println("invalid");
    		return '`';
    	}
    	else {
    		return matrix[row][col+1];
    	}
    }
    
    static public char getWestNeighbor(char[][] matrix, int row, int col) {
        
    	if(col==0) {
    		System.out.println("invalid");
    		return '`';
    	}
    	else {
    		return matrix[row][col-1];
    	}
    }
    
    static public char getNorthNeighbor(char[][] matrix, int row, int col) {
    	if(row<1) {
    		System.out.println("invalid");
    		return '`';
    	}
    	if(matrix[row-1].length<col+1) {
    		System.out.println("invalid");
    		return '`';
    	}
    	else {
    		return matrix[row-1][col];
    	}
    }
    
    static public char getSouthNeighbor(char[][] matrix, int row, int col) {
    	if(row+1>=matrix.length) {
    		System.out.println("invalid");
    		return '`';
    	}
    	if(matrix[row+1].length<col+1) {
    		System.out.println("invalid");
    		return '`';
    	}
    	else {
    		return matrix[row+1][col];
    	}
    }
}
