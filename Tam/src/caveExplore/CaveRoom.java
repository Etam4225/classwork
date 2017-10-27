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
		setDefaultContents("");
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
		directions = "";
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
		//this is how you should be thinking
		return directions[dir];
	}
	
	public void enter() {
		contents = "x";
	}
	
	public void leave() {
		contents = defaultContents;
	}
	
	/**
	 * This is how we join rooms together.
	 * It gives this room access to anotherRoom and vice-versa
	 * It also puts the door between both rooms
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
		
	}
	
	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();//update directions
		
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w', 'a', 's', 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		int direction = "wdsa".indexOf(input);
		/*
		 * convert w,a,s,d to directions 0,3,2,1
		 * NO IF STATEMENTs
		 */
		goToRoom(direction);
	}
	
	/**
	 * returns true if w,a,s, or d is the input
	 * @param input
	 * @return
	 */
	private boolean isValid(String input) {
		return "wasd".indexOf(input) > -1 && input.length() == 1;
		/*String wasd = "wasd";
		//return input.contains(wasd);
		return wasd.indexOf(input) != -1 && input.length() == 1;*/
	}
	
	/**
	 * THIS IS WHERE YOU EDIT YOUR CAVES
	 */
	public static void setUpCaves() {
		//1. Determine size of caves
		CaveExplorer.caves = new CaveRoom[5][5];
		CaveRoom[][] c = CaveExplorer.caves;//shortuct for accessing CaveExplorer.caves
		
		//2. Populate with *default* caves
		for(int row = 0; row < c.length; row++) {
			for(int col = 0; col < c[row].length; col++) {
				c[row][col] = new CaveRoom("This cave has coordinates " +row+ ", " +col);
			}
		}
		//3. Replace some default rooms with custom rooms ( SAVE FOR LATER )
		
		//4. Set starting room 
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		
		//5. Finally, set up doors.
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
	}

	public void goToRoom(int direction) {
		//make sure there is a room to go to:
		if(borderingRooms[direction] != null && doors[direction] != null && 
				doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
			
		}else {
			//print red text
			System.err.println("You can't do that!");
		}
	}

	/**
	 * returns the OPPOSITE direction
	 * ex oD(0) returns 2;
	 * @param dir
	 * @return
	 */
	public static int oppositeDirection(int dir) {
		int[] oppRooms = {2,3,0,1};
		return oppRooms[dir];
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
