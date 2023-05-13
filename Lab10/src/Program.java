
public class Program {
	
	public static void main(String[] args) {
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();
		
		Animal[] animal = new Animal[3];

		animal[0] = dog;
		animal[1] = tiger;
		animal[2] = turtle;
		
		Person person = new Person() {
			private int hp = 100;
			public void control(Animal animal) {
				if(animal instanceof Tiger) {
					hp -= 80;
				}
				else if(animal instanceof Dog) {
					hp -= 10;
				}
				else if(animal instanceof Turtle) {}
				System.out.println("You have overpowered the " + animal.getName());
			}
			public void showInfo() {
				System.out.println("Person HP: " + hp);
			}
		};
		showResult(animal, person);
	}
	
	private static void showResult(Animal[] animal, Person p) {
		for(int i = 0; i < animal.length; i++) {
			int idx = i+1;
			System.out.println("Animal" + idx + ":" + animal[i].getName());
			if(animal[i] instanceof Dog) {
				Dog temp = (Dog)animal[i];
				System.out.println("Animal" + idx + " barked " + temp.bark());
			}
			else if(animal[i] instanceof Tiger) {
				Tiger temp = (Tiger)animal[i];
				System.out.println("Animal" + idx + " barked " + temp.bark());
			}
			p.control(animal[i]);
			p.showInfo();
		}
		
	}

}
