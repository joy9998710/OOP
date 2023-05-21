package Lab11;
import java.util.ArrayList;
import java.util.Scanner;

public class Logistics {
	public static void main(String[] args) {
		String[] new_gyeonggi_boxes = {"SuWon#1","SeongNam#1","YongIn#1","GoSeong#1","GaPyeong#1"};
		String[] new_gangwon_boxes = {"Gangneung#1","Wonju#1"};
		ArrayList<Gyeonggi> gyList = new ArrayList<>();
		ArrayList<Gangwon> gaList = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		
		ServiceManagement.<Gyeonggi>packageBoxes(new_gyeonggi_boxes, Gyeonggi.class, gyList);
		ServiceManagement.<Gangwon>packageBoxes(new_gangwon_boxes, Gangwon.class, gaList);
		
		System.out.println("*** Oh, delivery price has been increased!! ***");
		
		ServiceManagement.<Gyeonggi>raiseAll(Gyeonggi.class, gyList, 1.05);
		ServiceManagement.<Gangwon>raiseAll(Gangwon.class, gaList, 1.05);
		
		System.out.println("Which box is important in Gangwon-area?");
		int index = scan.nextInt();
		index = ServiceManagement.<Gangwon>findIndexByNum(gaList, index);
		if(index == -1) {
			System.out.println("nothing");
		}
		else {
            System.out.println("The box \""+gaList.get(index).getDescription()+"\" is important! be careful!\n");
            ServiceManagement.<Gangwon>raisePerBox(gaList.get(index), 1.2);
		}
		
		System.out.println("Which box has the wrong area in Gyeonggi-area?");
		
		int idx = scan.nextInt();
		idx = ServiceManagement.<Gyeonggi>findIndexByNum(gyList, idx);
		if(idx == -1) {
			System.out.println("nothing");
		}
		else {
			System.out.println("The box \"" + gyList.get(index).getDescription()
+ "\" is actually has to go to Gangwon! late! hurry up!\n");
			ServiceManagement.<Gyeonggi, Gangwon>changeHub(gyList, idx, Gangwon.class, gaList);
		}
		
		System.out.println("-------- Delivery List for Gyeonggi --------");
		for(Gyeonggi g : gyList) {
			System.out.println(g+"\n");
		}
		
		System.out.println("-------- Delivery List for Gangwon --------");
		for(Gangwon j : gaList) {
            System.out.println(j+"\n");
		}
		
		scan.close();
	}

}
