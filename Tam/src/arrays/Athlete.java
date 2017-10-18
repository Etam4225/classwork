package arrays;

public class Athlete extends Person {

	private int money;
	
	
	public Athlete(String firstName, String lastName, Borough home, int money) {
		
		//the first line must call a super constructor
		//THINK: A person must exist before an athlete can
		super(firstName, lastName, home);
		
		this.money = money;
		
	}
	
	public String toString() {
		//TO CALL SUPERCLASS METHODS, USE SUPER.
		return super.toString() + " I also have $" +money+ "! :(";
	}

}
