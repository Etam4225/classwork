package caveExplore;

import java.util.Scanner;

public class CaveExplorer {
	public static CaveRoom[][] caves;
	public static Scanner in;//for user input
	public static CaveRoom currentRoom; //changes as user moves
	public static Inventory inventory;
	public static boolean playing = true;
	public static NPC[] npcs;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();//creates caves and starting room
		inventory = new Inventory();
		startExploring();
		

	}
	public static void print(String s) {
		System.out.println(s);
		//LATER consider replacing with more sophisticate multiline print
	}

	private static void startExploring() {
		while(playing) {
			moveNPCs();
			
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print(currentRoom.getDirections());
			print("What would you like to do?");
			currentRoom.interpretInput(in.nextLine());
			//lets program wait while typing etc
			//nextline waiting for line to be printed
		}
	}
	private static void moveNPCs() {
		for(NPC n: npcs) {
			n.autoMove();
		}
		inventory.updateMap();
		
	}

}
