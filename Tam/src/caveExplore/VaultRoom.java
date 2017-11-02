package caveExplore;

public class VaultRoom extends NPCRoom{
	public VaultRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
	public int addMoney() {
		CaveRoom[][] c = CaveExplorer.caves;
		if(CaveExplorer.currentRoom == c[1][3]) {
		//	Inventory.setMoney(Inventory.getMoney() + 50);
		}
		return 100;
	}
	
}
