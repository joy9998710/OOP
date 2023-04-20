package Lab08;

import java.time.LocalDate;

public final class ICE extends Car{
	private static int carNum = 0;
	private static int CO2emission = 0;
	private static final int GHGPERCAR = 35;
	
	ICE(){
		super();
	}
	ICE(String name, LocalDate date, int carNum){
		this.name = name;
		this.date = date;
		ICE.carNum += carNum;
		ICE.CO2emission += carNum * GHGPERCAR;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		else if(getClass() != obj.getClass()) {
			return false;
		}
		else {
			ICE temp = (ICE)obj;
			return (this.name.equals(temp.name)) && this.date.equals(temp.date);
		}
	}
	
	public String toString() {
		if(date == null) {
			return "name: " + name + ", date: null" + ", carNum: " + carNum;
		}
		return "name: " + name + ", date: " + date.toString() + ", carNum: " + carNum;
	}
	
	int totalCO2(){
		System.out.println("ICE emit CO2 most when driving");
		return CO2emission;
	}
}
