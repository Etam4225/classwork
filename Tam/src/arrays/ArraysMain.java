package arrays;

public class ArraysMain {

	private int[] testArray;
	
	public ArraysMain() {
		//two ways to construct an array
		int[] firstWay = {0,1,2,3,4,5};
		//this way will only work with the declaration.
		//will not work:
		//firstWay = {6,7,8,9,10};
		
		int[] secondWay = new int[5];
		//you can go on, creating values at each index
		secondWay[0] = 1;
		secondWay[1] = 10;
		
		//TWO WAYS TO ITERATE THROUGH AN ARRAY
		for(int i = 0; i < secondWay.length; i++) {
			System.out.println("The #" + i + " element is " + secondWay[i]);
		}
		//For each int in secondWay
		for(int value: secondWay) {
			System.out.println("Element is " + value);
		}
	}

	public static void main(String[] args) {
		ArraysMain sample = new ArraysMain();
		/*
		 * 1. Arrays are collections of primitives and Objects
		 * SPECIAL NOTE: This is the only collection of primitives
		 * 2. Size cannot be edited
		 * 3. Elements of an array are REFERENCES to objects.
		 * In other words, changing an element of an array changes
		 * the reference, not the object.
		 */
	
		
	}

	/**
	 * returns the result after rolling n number of dice
	 * @param n
	 * @return
	 */
	public int diceRoll(int n) {
		int sum = 0;
		int myNum = 0;
		for(int i =0; i < n;i++) {
			myNum = (int) (Math.random() * 6) + 1;
			//(int) is a cast ^ trying to conserve info
			//to ignore the decimal you use a cast
			sum += myNum;
		}
		return sum;
	}
}
