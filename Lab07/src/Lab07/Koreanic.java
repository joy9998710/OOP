package Lab07;

public class Koreanic extends Language{
	public Koreanic(String name_, int numSpeakers_) {
		super(name_, numSpeakers_, "Korean peninsula(South Korea, North Korea, Jeju) and several prefectures of China", "subject-object-verb");
		if(name_.contains("Jeju")){
			regionsSpoken = "Jeju island";
		}
	}
}
