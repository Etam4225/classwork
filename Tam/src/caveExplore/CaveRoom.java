package caveExplore;

public class CaveRoom {
	
	private String description;
	private String directions;//tells u which door can be used
	private String contents; //symbol showing you what is in the room("x" when you are in the room)
	private String defaultContents;//what is in the room when you arent in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//CONSTANTS
	private static final int NORTH = 0;
	private static final int EAST = 1;
	private static final int SOUTH = 2;
	private static final int WEST = 3;

	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents("SAME");
		contents = defaultContents;
		//NOTE: ARRAYS ARE INSTANTIATED WITH NULL VALUES
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	/**
	 * for every Door in doors[] that is not null,
	 * this method appends a String to "directions" describing the door
	 * and where it is. Ex there is a (passage) to (the North)
	 * There is a (passage) to (the East)
	 * If there are no doors that are not null, this sets
	 * directions to "there is no way out. you are trapped in this room"
	 * 
	 */
	public void setDirections() {
		String directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a " +doors[i].getDescription() + " to " +
				toDirection(i)+ ". " + doors[i].getDetails() + "\n";
			}
		}
		if(!doorFound) {
			directions = "No way out. you are trapped.";
		}
		//hint: to check if a door is null, use:
		//doors[0] == null OR doors[0] != null
		System.out.println(directions);
	}
	/** converts an int to a direction
	 * 0 -> "the North"
	 * 1 -> "the East"
	 * hint complete without using if statement
	 * 
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] directions = {"the North","the East", "the South", "the West"};
		//NOTE: When i say "no long if-else" statements,
		//this is how ytou should be thinking
		return directions[dir];
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
