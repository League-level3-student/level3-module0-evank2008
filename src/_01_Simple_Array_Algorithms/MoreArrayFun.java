package _01_Simple_Array_Algorithms;

import java.util.Random;

public class MoreArrayFun {
    //1. Create a main method to test the other methods you write.
public static void main(String[] args) {
	MoreArrayFun maf = new MoreArrayFun();
	maf.run();
}
void run() {
	Random ran = new Random();
String[] flavors = {"pumpkin", "peach", "rhubarb", "strawberry", "blueberry", "pie", "chocolate", "mayonnaise", "pizza"};

    //2. Write a method that takes an array of Strings and prints all the Strings in the array.
for(int i =0; i<flavors.length;i++) {
	//System.out.println(flavors[i]);
}


    //3. Write a method that takes an array of Strings and prints all the Strings in the array
    //   in reverse order.
for(int i =flavors.length-1; i>=0;i--) {
	//System.out.println(flavors[i]);
}


    //4. Write a method that takes an array of Strings and prints every other String in the array.
for(int i =0; i<flavors.length;i+=2) {
	//System.out.println(flavors[i]);
}

    //5. Write a method that takes an array of Strings and prints all the Strings in the array
    //   in a completely random order. Almost every run of the program should result in a different order.
while(true) {
	
	int counter = flavors.length;
	int spot = ran.nextInt(flavors.length-1);
	if(!flavors[spot].equals("x")) {
		System.out.println(flavors[spot]);
		flavors[spot]="x";
		counter--;
	}
	if(counter==0) {
		break;
	}
}
}
}
