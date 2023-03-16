package week3;

public class Staff {
	private String name;
	private int age;
	private String department;
	private int workDays;
	private int vacationDays;

	//default constructor
	public Staff() {
		name = "None";
		age = 10;
		department = "None";
		workDays = 0;
		vacationDays = 20;
	}
	
	
	public Staff(String name_, int age_) {
		name = name_;
		age = age_;
		department = "None";
		workDays = 0;
		vacationDays = 20;
	}
	
	public Staff(String name_, int age_, String department_, int workDays_, int vacationDays_) {
		name = name_;
		age = age_;
		department = department_;
		workDays = workDays_;
		vacationDays = vacationDays_;
	}
	
	public String getter() {
		return name;
	}
	
	public void setter(Staff a) {
		this.department = a.department;
		this.workDays = a.workDays;
	}
	
	public boolean sameCareer(Staff a) {
		if(this.department.equals(a.department) && this.workDays == a.workDays) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		String tmp = "Name: " + name + ", Age: " + age + ", Department: " + department + ", vacationDays: " + vacationDays;
		return tmp;
	}
	
	public void vacation(int days) {
		if(vacationDays < days) {
			System.out.printf("%s, 남은 휴가 일 수 부족", name);
			System.out.println();
			return;
		}
		vacationDays -= days;
		System.out.printf("%s, 휴가 %d 사용 남은 휴가 일 수: %d", name, days, vacationDays);
		System.out.println();
	}
	

}
