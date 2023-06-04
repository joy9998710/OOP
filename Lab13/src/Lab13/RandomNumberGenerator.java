package Lab13;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator{
	private Random random = new Random();
	private int number;
	
	//number를 get하는 getter
	public int getNumber() {
		return this.number;
	}
	//number를 제작하고 observer에 notify
	public void execute() {
		for(int i = 0; i < 10; i++) {
			this.number = random.nextInt(50);
			notifyObservers();
		}
	}
}
