package arrays;


public class ObjectMain {

	public ObjectMain() {
		Person[] people = new Person[34];
		populate(people);
		//people[0] = new Thing("toaster oven");
		//Person[] group = selectGroup(people, 34);
		//analyzeCommonalities(people, group);
		/*for(Object p: group) {
			System.out.println((p));
		}*/
		for(Person p: people) {
			p.mingle(people);
			System.out.println(p);
			p.stateYourFriends();
		}
	}
	private void analyzeCommonalities(Person[] people, Person[] group) {
		double averageCommonality = 0;
		int totalCounter = 0;
		double trials = 500;
		for(int i = 0; i < trials; i++) {
			group = selectGroup(people, people.length);
			int counter = countCommonalities(people, group);
			totalCounter += counter;
		}
		averageCommonality = totalCounter / trials;
		System.out.println("After " + trials + " trials, shuffling " +
		people.length+ " people, on average, " +averageCommonality+
		" people end up in the same position where they started.");
		
	}
	/**
	 * returns the # of items that are same in both arrays
	 * and in same location (index) too
	 * PRECONDITION THEY HAVE SAME LENGTH
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private int countCommonalities(Object[] arr1, Object[] arr2) {
		int sameCounter = 0;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] == arr2[i]) {
				sameCounter++;
			}
		}
		return sameCounter;
	}
	private Person[] selectGroup(Person[] population, int length) {
		Person[] grp = new Person[length];

		for(int i = 0; i < length; i++) {
			Person toAdd = randomPerson(population);
			while(alreadyContains(grp, toAdd)) {
				toAdd = randomPerson(population);
			}
			grp[i] = toAdd;
		}
		return grp;
	}
	private Person randomPerson(Person[] population) {
	
		int randNum = (int)(Math.random() * population.length);
		return population[randNum];
	}

	private boolean alreadyContains(Person[] population, Person p) {
		for(int i = 0; i < population.length; i++) {
			if(population[i] == p) {
				return true;
			}
		}
		return false;
		//array is a class generated at run time @JDM
	}
	private void populate(Object[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE, Person.LAST_END);
			Borough home = randomBorough();
			
			//BIG IDEA:
			//IN an object array, you can have multiple data types!
			//(This is unlike a primitive array, like int[], boolean[] etc
			if(Math.random() < .6) {
				// 60% of the time
				int money = (int)(Math.random() * 20+1) * -100000;
				people[i] = new Athlete(firstName, lastName, home, money);
			}else {
				//other 40% of the time
				people[i] = new Person(firstName, lastName, home);
			}
		}
		
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random() *  Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random() * a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();

	}

}
