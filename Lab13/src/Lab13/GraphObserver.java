package Lab13;

public class GraphObserver implements Observer{
	private NumberGenerator num;
	
	//NumberGenerator class의 graph를 subject로 한 observer
	public GraphObserver(NumberGenerator num) {
		this.num= num;
		num.addObserver(this);
	}
	
	//NumberGenerator class에서 graph에 변화가 있을 때 이를 notify 받고 update 수행
	public void update(NumberGenerator generator) {
		System.out.print("GraphObserver: ");
		
		for(int i = 0; i < generator.getNumber(); i++) {
			System.out.print("*");
		}
		System.out.println("");
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
