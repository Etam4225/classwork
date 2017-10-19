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
	private Hobby hobby;
	private Person[] friends;
	public Person(String firstName, String lastName, Borough home) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.home = home;
		friends = new Person[3];
		hobby = Hobby.randomHobby();
	}
	
	public void stateYourFriends() {
		String friendsList = "My friend(s) is/are ";
		for(int i = 0; i < friends.length-1; i++ ) {
			friendsList += friends[i].firstName + ", ";
		}
		friendsList += "and " +friends[friends.length-1].firstName+ ".";
		System.out.println(friendsList);
	}
	
	public void mingle(Person[] peers) {
		for(Person p: peers) {
			//can't friend yourself
			if(p != this) {
				setInFirstPlace(p);
			}
		}
	}
	
	public void setInFirstPlace(Person f) {
		//go backward through an array
		for(int i = friends.length - 1; i > 0; i--) {
			//move the friend from in front, back
			friends[i] = friends[i-1]; //Check: wont go out of bounds
		}
		friends[0] = f;
	}
	
	public String toString() {
		return "My name is "+ firstName + " "+ lastName+ " and I am from " +
	 home + ".";
	}
}
