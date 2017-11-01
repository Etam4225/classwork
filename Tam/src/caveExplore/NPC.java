package caveExplore;

public class NPC {

	//fields needed to program navigation
	private CaveRoom[][] floor; //AREA WHERE NPC ROAMS
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	//These fields are about interaction with the NPC
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	//you might later add fields to make your NPC behave like a chatbot
	
	//default
	public NPC() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a person standing in the room,"
				+ " waiting to talk to you. Press 'e' to talk.";
		this.inactiveDescription = "The person you spoke to earlier is "
				+ "standing here";
		//by default, NPC does not have a position,
		//to indicate this, use coordinates -1,-1
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
		active = true;
	}

	public boolean isActive() {
		return active;
	}

	public void interact() {
		CaveExplorer.print("Let's interact! Type 'bye' to stop.");
		String s = CaveExplorer.in.nextLine();
		while(!s.equalsIgnoreCase("bye")) {
			CaveExplorer.print("Yeah... I don't do a whole lot.");
			s = CaveExplorer.in.nextLine();
		}
		CaveExplorer.print("later, friend!");
		active = false;	
	}

	public String getDescription() {
		return activeDescription;
	}

	public String getInactiveDescription() {
		return inactiveDescription;
	}

	public String getSymbol() {
		return "P"; //person
	}

	public void setPosition(int row, int col) {
		//avoid AIOOBE
		if(row >= col && row < floor.length &&  col >= 0 && col < floor[row].length
				&& floor[row][col] instanceof NPCRoom) {
			if(currentRoom != null) {
				currentRoom.leaveNPC();
			}
			
			currentRow = row;
			currentCol = col;
			//cast the CacveRoom
			currentRoom = (NPCRoom)floor[row][col];
			currentRoom.enterNPC(this);
		}
	}

	public void autoMove() {
		if(active) {
			int[] move = calculateMove();
			int newRow = currentRow + move[0];
			int newCol = currentCol + move[1];
			setPosition(newRow, newCol);
		}
	}

	private int[] calculateMove() {
		int[][] possibleMoves = {{-1,0},{0,1}, {1,0}, {0,-1}};
		
		return null;
	}

}