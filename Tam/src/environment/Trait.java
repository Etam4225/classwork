package environment;

public class Trait {
	public static final String[] traits = {"striped", "long-tailed", "furry", "short-eared",
			"spotted", "short-tailed", "hairless", "white", "long-eared"};
	private String description;
	private int index;
	
	public static final void main(String[] args) {
		Trait longTailed = new Trait(1);
		Trait shortTailed = new Trait(6);
		System.out.println(longTailed+ " and " +shortTailed+ " are the same trait: " + longTailed.equals(shortTailed));
	}
	
	
	
	public Trait() {
		index = (int)(Math.random()*traits.length);
	}



	public Trait(int index) {
		this.index = index;
		description = traits[index];
	}

	@Override
	public String toString() {
		return "Trait []";
	}



	public int getIndex() {
		return index;
	}

	public boolean equals(Object o) {
		return (o instanceof Trait) && (this.getIndex() - ((Trait)o).getIndex()) % (traits.length/2) == 0;
	}
	
	public static Trait getDominantTrait(Trait t1, Trait t2) {
		if(t1.equals(t2) && t1.getIndex() < t2.getIndex()) return t1;
		else if(t1.equals(t2) && t2.getIndex() <t1.getIndex())return t2;
		else if(Math.random() <.5)return t1;
		return t2;
	}
}
