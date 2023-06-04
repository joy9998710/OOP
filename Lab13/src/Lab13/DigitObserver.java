package Lab13;

//일반적인 observer interface를 활용한 DigitObserver
public class DigitObserver implements Observer{
	private NumberGenerator num;
	
	
	//NumberGenerator의 digit에 대한 observer
	public DigitObserver(NumberGenerator num) {
		this.num = num;
		num.addObserver(this);
	}
	
	//Subject인 NumberGenerator에 문제가 생기면 notify 받아서 update 하는 함수
	public void update(NumberGenerator generator) {
		System.out.println("DigitObserver: " + generator.getNumber());
		
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
