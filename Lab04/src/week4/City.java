package week4;

public class City {
	private String name;
	private int locationX;
	private int locationY;
	
	public City(String name_, int locationX_, int locationY_) {
		name = name_;
		locationX = locationX_;
		locationY = locationY_;
	}
	public City(String name_) {
		name = name_;
		locationX = (int)(Math.random()*360);
		locationY = (int)(Math.random()*360);
	}
	
	public String getName() {
		return name;
	}
	public int getLocationX() {
		return locationX;
	}
	public int getLocationY() {
		return locationY;
	}
	
	public boolean equals(City otherCity) {
		if(this.name == otherCity.name && this.locationX == otherCity.locationX && this.locationY == otherCity.locationY) {
			return true;
		}
		return false;
	}

	public String toString() {
		return name + ", " + locationX + ", " + locationY;
	}
	
	public static double distance(City city1, City city2) {
		double distance_ = Math.sqrt(Math.pow(city1.locationX - city2.locationX, 2) + Math.pow(city1.locationY - city2.locationY,2));
		return distance_;
	}
	
	
	

}
