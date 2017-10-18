package arrays;

public class Person {
	public static final String[] FIRST_START = {"Chr", "Am", "L", "Far", "Tr", "B"};
	public static final String[] FIRST_MIDDLE = {"ala", "ima", "e", "od", "anna", "ola", "a"};
	public static final String[] FIRST_END = {"na", "cks", "ns", "rians", "lius", "lioun", "ned"};
	
	public static final String[] LAST_START = {"Bl", "Gr", "Phr", "Cr", "Fur", "Gr"};
	public static final String[] LAST_MIDDLE = {"aa", "im", "eds", "ast", "own", "il"};
	public static final String[] LAST_END = {"strom", "son", "rack", "lens", " the third", " the first", "ston"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	public Person(String firstName, String lastName, Borough home) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.home = home;
	}
	
	public String toString() {
		return "My name is "+ firstName + " "+ lastName+ " and I am from " +
	 home + ".";
	}
}
