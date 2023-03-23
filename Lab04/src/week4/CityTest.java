package week4;

public class CityTest {
	public static void main(String[] args) {
		City city1 = new City("Seoul", 23, 45);
		City city2 = new City("Paris", 123, 41);
		City city3 = new City("Racoon City");
		City city4 = new City("Mega City");

		System.out.println(city1.toString());
		System.out.println(city2.toString());
		System.out.println(city3.toString());
		System.out.println(city4.toString());

		System.out.printf("%s-%s : %.14f\n", city1.getName(), city2.getName(), City.distance(city1, city2));
		System.out.printf("%s-%s : %.14f\n", city1.getName(), city3.getName(), City.distance(city1, city3));
		System.out.printf("%s-%s : %.14f\n", city2.getName(), city4.getName(), City.distance(city2, city4));
	}
}
