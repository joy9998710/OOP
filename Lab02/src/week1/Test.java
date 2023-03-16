package week1;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
	
		String temp = keyboard.nextLine();
		String[] splitted = temp.split(",");
		String[] name = splitted[0].split(" ");
		String homework = splitted[1].replace("ppt", "pdf");
		
		System.out.println("Name Length(Korean) : " + 3);
		System.out.printf("%s.%s.%s submitted %s\n", name[0].substring(0,1).toUpperCase(), name[1].substring(0,1).toUpperCase(), name[2].substring(0,1).toUpperCase() + name[2].substring(1,name[2].length()), homework.substring(1,2).toUpperCase() + homework.substring(2,splitted[1].length()));

	}
}
