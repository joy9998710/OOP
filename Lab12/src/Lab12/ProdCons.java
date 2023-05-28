package Lab12;

public class ProdCons {
	private Buffer buffer;
	private Producer[] producer;
	private Consumer[] consumer;
	
	public ProdCons() {
		buffer = new Buffer(5);
		//배열에 새로운 Producer Thread 저장
		producer = new Producer[2];
		producer[0] = new Producer(buffer);
		producer[1] = new Producer(buffer);
		//배열에 새로운 Consumer Thread 저장
		consumer = new Consumer[2];
		consumer[0] = new Consumer(buffer);
		consumer[1] = new Consumer(buffer);
	}
	
	//prodcons의 inner class
	private class Producer extends Thread{
		private static int serial = 0;
		private int pNum;
		private final Buffer buffer;
		
		//buffer를 인자로 받는 생성자
		public Producer(Buffer buff) {
			this.pNum = serial++;
			this.buffer = buff;
		}
		
		//pNum을 리턴하는 함수
		public int getNum() {
			return pNum;
		}
		
		//buffer에 data를 추가하는함수
		public void produce() throws InterruptedException{
			for(int i = 0; i < buffer.getSize(); i++) {
				System.out.println("Producer#" + this.pNum + ":" + this);
				buffer.add(this.pNum ,Math.random()*100);
			}
		}
		
		//Thread를 실행시키는 함수 => override
		public void run() {
			//produce가 throws clause가 존재하므로 try catch문으로 잡아줌
			try {
				produce();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//ProdCons의 inner class
	private class Consumer extends Thread{
		private static int serial = 0;
		private int pNum;
		private final Buffer buffer;
		
		//buffer 객체를 인자로 받는 생성자
		public Consumer(Buffer buff) {
			this.pNum = serial++;
			this.buffer = buff;
		}
		
		//pNum을 리턴하는 함수
		public int getNum() {
			return pNum;
		}
		
		//buffer의 원소를 제거하는 함수
		public void consume() throws InterruptedException {
			for(int i = buffer.getSize(); i > 0; i--) {
				System.out.println("Consumer#" + this.pNum + ":" + this);
				buffer.remove(this.pNum);
			}
		}
		
		//Thread를 실행하는 함수 
		public void run() {
			//consume에 throws clause가 존재하므로 try-catch로 exception을 catch 해야함
			try {
				consume();
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Thread를 start하는 함수
	void startThread() {
		for(int i = 0; i < producer.length; i++) {
			producer[i].start();
			System.out.println(buffer);
			consumer[i].start();
		}
		
	}
}
