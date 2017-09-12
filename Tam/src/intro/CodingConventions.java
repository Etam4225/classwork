package intro;

public class CodingConventions {

	//FIELDS ARE AT THE TOP!!!
	private String name;//NOTE: DECLARE FIELDS ONLY, INSTANTIATE IN THE CONSTRUCTOR
	
	/*
	 * In other words, dont do this:
	 * private String name = "Mr. Nockles";
	 */
	private String description;
	
	/* this is a constructor, it is like a method except the "return type" is an instance of the class
	 
	    for this reason, a constructor must ALWAYS be named after the class
	 */
	public CodingConventions(String name, int descriptionIndex) {
		//instantiate variables now
		
		//there are two variables called "name" the local variable and the field
		//distinguish between the two using the reserved word "this" (field)
		this.name = name;
		//this is a static call to a constant 
		description = IntroMain.DESCRIPTIONS[descriptionIndex];
	}
	
	//normal method "void" returns nothing (is a return type)
	public void doStuff() {
		
		//static method call;
		String output = name + description; //use spaces in between operations (convention)
		System.out.println(output);
	}
	
}
