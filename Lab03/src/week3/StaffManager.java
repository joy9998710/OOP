package week3;

public class StaffManager {

	public static void main(String args[]) {
		Staff A = new Staff("James Wright", 29, "Accounting", 365, 15);
		Staff B = new Staff("Peter Coolidge", 32, "R&D", 1095, 7);
		Staff C = new Staff("Amy Smith", 27);
		
		System.out.println(A.toString());
		System.out.println(B.toString());
		System.out.println(C.toString());
		

		System.out.println("---");
		System.out.println("Same Career?");
		
		if(B.sameCareer(C)) {
			System.out.printf("%s and %s, Same", B.getter(), C.getter());
		}
		else {
			System.out.printf("%s and %s, Not exactly same", B.getter(), C.getter());
		}
		System.out.println();
		
		System.out.println("...A Few years later...");
		
		C.setter(B);

		if(B.sameCareer(C)) {
			System.out.printf("%s and %s, Same", B.getter(), C.getter());
		}
		else {
			System.out.printf("%s and %s, Not exactly same", B.getter(), C.getter());
		}

		System.out.println();
		System.out.println("---");
		
		
		A.vacation(10);
		C.vacation(20);
		C.vacation(1);
	}

}
