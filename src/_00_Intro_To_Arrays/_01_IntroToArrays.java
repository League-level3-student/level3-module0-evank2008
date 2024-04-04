package _00_Intro_To_Arrays;

import java.util.Random;

public class _01_IntroToArrays {
	
    public static void main(String[] args) {
    	Random ran = new Random();
        // 1. declare and Initialize an array 5 Strings
    	String[] enchantments = {"Sharpness","Knockback","Feather Falling","Unbreaking","Fire Aspect"};
        // 2. print the third element in the array
System.out.println("Third element is " + enchantments[2]);
        // 3. set the third element to a different value
enchantments[2]="Bane of Arthropods";
        // 4. print the third element again
System.out.println("Third element is " + enchantments[2]);
        // 5. use a for loop to set all the elements in the array to a string
        //    of your choice
System.out.println("SHARPENING");

for(int i = enchantments.length-1;i>=0;i--) {
	enchantments[i]="Sharpness ";
	for(int p = i; p>=0;p--) {
		enchantments[i]+="I";
	}
}
for(int i = 0;i<=enchantments.length-1;i++) {
	System.out.println("Enchantment " + i + ": " + enchantments[i]);
}
        // 6. use a for loop to print all the values in the array
        //    BE SURE TO USE THE ARRAY'S length VARIABLE

        // 7. make an array of 50 integers
int[] nums = new int[50];
        // 8. use a for loop to make every value of the integer array a random
        //    number
for(int i = 0;i<nums.length;i++) {
	nums[i]=ran.nextInt(100)+1;
}
        // 9. without printing the entire array, print only the smallest number
        //    on the array
int smallestnum=nums[0];
for(int i = 1; i<nums.length;i++) {
	if(smallestnum>nums[i]) {
		smallestnum=nums[i];
	}
}
System.out.println("smallest number is " + smallestnum);
        // 10 print the entire array to see if step 8 was correct
for(int i = 0; i<nums.length;i++) {
	System.out.println(nums[i]);
}
        // 11. print the largest number in the array.

        // 12. print only the last element in the array
System.out.println("last number is " + nums[nums.length-1]);
    }
}
