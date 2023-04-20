package Lab08;

import java.time.LocalDate;

public class BEV extends Car{
	private static int carNum = 0;;
	private static int CO2emission = 0;;
	private static final int GHGPERCAR = 25;
	
	BEV(){
		super();
	}
	
	BEV(String name, LocalDate date, int carNum){
		this.name = name;
		this.date = date;
		BEV.carNum += carNum;
		CO2emission += carNum * GHGPERCAR;
	}
	
	int totalCO2() {
		System.out.println("BEV emit CO2 most when generating electric energy");
		return CO2emission;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		else if(getClass() != obj.getClass()) {
			return false;
		}
		else {
			BEV temp = (BEV)obj;
			return ((this.name.equals(temp.name)) && this.date.equals(temp.date));
		}
	}
	public String toString() {
		if(date == null) {
			return "name: " + name + ", date: null"  + ", carNum: " + carNum;
		}
		return "name: " + name + ", date: " + date.toString() + ", carNum: " + carNum;
	}
}
