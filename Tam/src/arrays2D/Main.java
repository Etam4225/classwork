package arrays2D;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] arr = {4,3,2,1,0};
		changeNeighbors(arr, 0);
		
		System.out.println(Arrays.toString(arr));

	}
	/**
	 * PRECONDITION: i >= 0 and i < arr.length
	 * increase the element at i by 1
	 * decreases the elements at i -1 and i + 1 if they exist
	 * AVOIDS ArrayIndexOutOfBoundsException
	 * HEAVILY TESTS CONCEPT
	 * ALWAYS BE IN THE HABIT OF CHECKING FOR EXCEPTION
	 * dont be "that guy" who lost a bazillion points
	 * @param arr
	 * @param i
	 */
	private static void changeNeighbors(int[] arr, int i) {
		arr[i] = arr[i]  + 1;
		if(i >= 1) {
			arr[i-1] = arr[i-1] - 1;
		}
		if(i < arr.length - 1) {
			arr[i+1] = arr[i-1] - 1;
		}
	}
}	
