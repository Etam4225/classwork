package environment;

public class Environment {

	private int plants;
	private int growthRate;
	
	public Environment(int plants) {
		this.plants = plants;
		this.growthRate = plants/2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Environment farm = new Environment(10);
		System.out.println(farm);
		farm.growPlants();

	}

	public void growPlants() {
		plants+= growthRate;
		System.out.println("\nThere are "+plants+" plants.");
		
	}

	public boolean eatPlants() {
		if(plants > 0) {
			plants--;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "An vast field";
	}
}
