package Lab11;

public class Hub {
	private int number;
	private String description;
	private String area;
	private double price_per_box;
	
	public Hub(int number, String description, String area, double price_per_box) {
		this.number = number;
		this.description = description;
		this.area = area;
		this.price_per_box = price_per_box;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getPricePerBox() {
		return price_per_box;
	}

	public void setPricePerBox(double price_per_box) {
		this.price_per_box = price_per_box;
	}
	
	public String toString() {
		return "Box Number : " + number + "\n" + "Description : " + description + "\n" + "Area : " + area + "\n" + "Price per box : " + price_per_box;
	}
}
