package algorithms;

public class Pokemon {
	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	Pokemon(String name, int level){
		this.level = level;
		this.name = name;
		setPoisoned(false);
		setHp(100);
	}
	
	/*public static void main(String[] args) {
		 Pokemon squirtle = new Pokemon("Squirtle",26);
		 Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		 squirtle.iChooseYou();
		 bulbasaur.iChooseYou();
	}*/
	
	public static void main(String[] args) {
		 Pokemon squirtle = new Pokemon("Squirtle",26);
		 Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		 squirtle.iChooseYou();
		 bulbasaur.iChooseYou();
		 System.out.println("Squirtle is preparing to attack with water blast");
		 squirtle.attack(bulbasaur, new Attack() {
		 
		 public void attack(Pokemon target) {
		 int hp = target.getHp();
		 target.setHp(hp/2);
		 }
		 });
		 System.out.println("Bulbasaur is preparing to attack with poison.");
		 bulbasaur.attack(squirtle, new Attack() {
		 
		 public void attack(Pokemon target) {
		 target.setPoisoned(true);
		 }
		 });
		 squirtle.lapse();
		 bulbasaur.lapse();
		 printScore(squirtle, bulbasaur);
		 System.out.println("Squirtle is attacking again");
		 squirtle.attack(bulbasaur, new Attack() {
			public void attack(Pokemon target) {
				int hp = target.getHp();
				target.setHp(hp-100);
			}
		});
		squirtle.levelUp(new Effect() {
			public void happen() {
				//code goes here
				//final if u want to modify a reference outside of this body
				System.out.println("Squirtle Leveled up!");
				squirtle.setHp(100);
			}
		}); 
	}
	
	public void levelUp(Effect e) {
		level++;
		e.happen();
	}
	
	private static void printScore(Pokemon squirtle, Pokemon bulbasaur) {
		System.out.println(squirtle.getName() + " , HP = "+ squirtle.getHp());
		System.out.println(bulbasaur.getName() + " , HP = "+ bulbasaur.getHp());
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPoisoned(boolean poisoned) {
		this.poisoned = poisoned;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	void iChooseYou() {
		System.out.print(getName() + " " + getName() + "\n");
	}
	
	void lapse() {
		if(isPoisoned()) {
			setHp(getHp() - 15);
		}
	}

	public int getHp() {
		return hp;
	}

	public boolean isPoisoned() {
		return poisoned;
	}
	
	public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9){
		 attack.attack(target);
		 System.out.println("The attack hit");
		 }else{
		 System.out.println("The attack missed");
		 }
		 }
}
