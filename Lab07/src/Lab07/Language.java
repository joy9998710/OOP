package Lab07;

public class Language {
	protected String name;
	protected int numSpeakers;
	protected String regionsSpoken;
	protected String wordOrder;
	
	public Language(String name_, int numSpeakers_, String regionSpoken_, String wordOrder_) {
		name = name_;
		numSpeakers = numSpeakers_;
		regionsSpoken = regionSpoken_;
		wordOrder = wordOrder_;
	}
	
	public void getInfo() {
		System.out.println(name + " is spoken by " + numSpeakers + " people mainly in " + regionsSpoken + ", The language follow the word order: " + wordOrder + ".");
	}
	
	public static void main(String[] args) {
	      System.out.println("---------- Language ----------");
	      Language spanish = new Language(
	            "Spanish", 555000000, 
	            "Spain, Latin America, and Equatorial Guinea", 
	            "subject-verb-object");
	      spanish.getInfo();
	      
	      System.out.println("----------Koreanic----------");
	      Language korean = new Koreanic("Korean", 80400000);
	      korean.getInfo();
	      
	      Language jeju_uh = new Koreanic("Jeju Language", 695500);
	      jeju_uh.getInfo();
	      
	      System.out.println("----------Mayan----------");
	      Mayan kiche = new Mayan("Ki'che'", 2330000);
	      kiche.getInfo();
	   }

}
