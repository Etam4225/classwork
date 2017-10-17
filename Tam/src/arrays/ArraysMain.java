package arrays;

import java.util.Arrays;

public class ArraysMain {

	private String[] suits;
	private String[] values;
	
	public ArraysMain() {
		tuesdayMethods();
		//System.out.println(Arrays.toString(testArray));
	}
	
	private void tuesdayMethods() {
		int[] orderTest = {1,2,3,4,5,6,7,8,9,3,7,8,11,10,1,2,3,4,5,6,7,8,9,10,11};
		//cycleThrough(orderTest, 5);
		int thing = longestConsecSequence(orderTest);
		System.out.println(thing);
		System.out.println(Arrays.toString((orderTest)));
	}
	
	/**
	 * return length of the longest cons. seqence in the array
	 * EX: lCS({1,2,3,2,3,4,5,2,3,4}) -> 4
	 * LCS({16,17,18,19,2,5,6,7,8,9,10}) -> 6
	 */
	private int longestConsecSequence(int[] arr) {
		int myCount = 1;
		int tempCount = 1;
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i]+1 == arr[i+1]){
				tempCount++;
			}else {
				tempCount = 1;
			}
			if(tempCount > myCount) {
				myCount = tempCount;
			}
		}
		return myCount; 
		/* for(int i = 0; i < arr.length; i++) {
				while(i + tempCount < arr.length && isConsecutive(arr, i, i + tempCount)) {
					tempCount++;
				}
				if(tempCount > myCount) {
					myCount = tempCount;				
				}
				i  = i + tempCount - 1; //saves time
				tempCount = 1;
		 }
		 return myCount; NOCKLES WAY*/
				
	}
	
	//private void resetCount
	/** 
	 * returns true if all elements start to end are increasing by 1
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private boolean isConsecutive(int[] arr, int start, int end) {
		for(int i = start; i < end; i++) {
			if(arr[i]+1 != arr[i+1]) {
				return false;
			}
		}
		return true;
		
	}
	/**
	 * The element at index 0 moves to the last position in the array as all
	 * other elements move forward. This must happen n times
	 * @param orderTest
	 */
	private void cycleThrough(int[] arr, int n) {
		int i = 0;
		while(i < n) {
			frontToBack(arr);
			i++;
		}
	}

	/**
	 * removes the element at index 0, pushes all other elements forward
	 * 1 goes to 0, 2 goes to 1, ...
	 * puts the element @ idx 0 at the end;
	 * @param arr
	 * @return
	 */
	private void frontToBack(int[] arr) {	
		int tempfirstElement = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1]; 
		}
		arr[arr.length-1] = tempfirstElement;
		
	}

	public void reverseOrder(int[] arr) {
		for(int i = 0; i < arr.length/2; i++) {
			swap(arr, i , arr.length-1-i);
		}
	}
	
	
	private void warmUpMethods() {
		int[] orderTest = {1,2,3,4,5,6,7,8,9,10};
		reverseOrder(orderTest);
		System.out.println(Arrays.toString(orderTest));
		System.out.println(Arrays.toString(subArray(orderTest,3,4)));
	}
	private int[] subArray(int[] arr, int start, int length) {
		int[] myArray = new int[length];
		for(int i = 0; i < length; i++) {
			myArray[i] = arr[i+start];
		}
		return myArray;
	}

	public void cardMethods() {
		suits = new String[4];
		suits[0] = "Clubs";
		suits[1] = "Hearts";
		suits[2] = "Diamonds";
		suits[3] = "Spades";
		values = new String[13];
		for(int i = 0; i < values.length; i++) {
			values[i] = ""+(i+1);
		}
		values[0]="Ace";
		values[12] = "King";
		values[11] = "Queen";
		values[10] = "Jack";
		printDeck();
		
	}
	private String[] printDeck() {
		String[] deck = new String[52];
		int index = 0;
		/*for(int i = 0; i < suits.length; i++) {
			for(int f = 0; f < values.length; f++) {
				System.out.println(values[f] + " of " + suits[i]);
			}
		}*/
		for(String suit: suits) {
			for(String value: values) {
				deck[index] = value + " of " + suit;
				index++;
			}
		}
		return deck;
	}
	private void shuffle(int[] arr) {
		int myNum1 = 0;
		for(int i = 0; i < arr.length; i++) {
			myNum1 = (int) (Math.random() * arr.length);
			swap(arr, i, myNum1);
		}
		
	}
	/**
	 * Swaps elements at i and j
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	/**
	 * Populate arr with numbers from 1 to arr.length, in order
	 * @param testArray2
	 */
	private void populate1ToN(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i+1);
		}
	}

	private void countOccurences(int[] arr, int start, int end) {
		//why create an array with this length
		int[] counter = new int[end - start + 1];
		
		for(int value: arr) {
			//why value - start?
			counter[value - start]++;
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("The value " + (i+start) + " was rolled "+ counter[i] + " times.");
		}
	}

	/**
	 * This method populates arr with results from rolling 2 dice
	 * @param arr
	 */
	private void populate(int[] arr) {
		//does nothing (incorrect)
		/*for(int value: arr) {
			arr[value] = diceRoll(2);
		}*/
		//correct way
		for(int i = 0; i < arr.length; i++) {
			arr[i] = diceRoll(3);
		}
		
	}


	public void arrayNotes() {
		//two ways to construct an array
		int[] firstWay = {0,1,2,3,4,5};
		//this way will only work with the declaration.
		//will not work:
		//firstWay = {6,7,8,9,10};
			
		String[] secondWay = new String[5];
		//you can go on, creating values at each index
		//secondWay[0] = 1;
		//secondWay[1] = 10;
				
		//TWO WAYS TO ITERATE THROUGH AN ARRAY
		for(int i = 0; i < secondWay.length; i++) {
			System.out.println("The #" + i + " element is " + secondWay[i]);
		}
		//For each int in secondWay
		for(String value: secondWay) {
			System.out.println("Element is " + value);
		}
		//NOTE: primitive arrays are auto populated with 0
		//OBJECT arrays are not populated (null)
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
