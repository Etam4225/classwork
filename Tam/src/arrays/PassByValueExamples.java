package arrays;

import java.util.Arrays;

public class PassByValueExamples {

	public static void main(String[] args) {
		String s = "Hello";
		Person p = new Person("Random", "Dude", Borough.NY_BOROUGHS[0]);
		int x = 5;
		int[] arr = {1,2,3};
		test3(arr);

		System.out.println("p is now " +p+ ", x is " +x+ " arr is " +Arrays.toString(arr));
	
		//BECAUSE PRIMITIVES DONT REFERENCE OTHER DATA (THATS Y THEY ARE CALLED PRIMITIVES)
		//IT IS NOT POSSIBLE TO CHANGE THEM VIA A LOCAL VARIABLE
		//LIKE WE DID WITH OBJECTS AND ARRAYS
		
	}

	/**
	 * IT IS NOT POSSIBLE TO CHANGE AN ORIGINAL REFERENCE VIA
	 * A LOCAL VARIABLE AS IN THE EXAMPLE BELOW (NEED SETTER)
	 * @param p
	 * @param x
	 * @param arr
	 */
	private static void test1(Person p, int x, int[] arr) {
		String name = p.getFirstName();
		name = "Original";
		
		
	}
	/**
	 * you cna change an object's references via its SETTERS (methods that set fields)
	 * @param p
	 */
	private static void test2(Person p) {
		String name = "Original";
		p.setFirstName(name);
		
		
	}
	
	/**
	 * This is how you can change arrays via the local variable:
	 * through its references (i.e. indices)
	 * @param arr
	 */
	private static void test3(int[] arr) {
		arr[0] = 999;
		arr[1] = 998;
	}
	private static void changeEVERTHING(String s, int x, int[] arr) {
		s = "Goodbye";
		x = -5;
		arr = new int[2];
		arr[0] = -1;
		arr[1] = -2;
	}

}
