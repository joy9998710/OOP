package Lab12;

public class Buffer {
	private double[] data;
	private int loc = 0; //버퍼의 인덱스
	
	//size를 받고 버퍼를 생성하는 생성자
	public Buffer(int size) {
		data = new double[size];
		System.out.println("New buffer");
		System.out.println(this + "\n");
	}

	//size를 리턴하는 함수
	public int getSize() {
		return data.length;
	}
	
	//출력을 위한 toString method
	public synchronized String toString() {
		String toReturn = "";
		for(double d : data) {
			toReturn += String.format("%5.2f", d) + " ";
		}
		return toReturn;
	}
	
	//buffer에 data를 add하는 함수
	public synchronized void add(int pNum, double toAdd) throws InterruptedException{
		//buffer가 꽉 찼으면 wait
		while(loc >= data.length) {
			System.out.println("Producer#" + pNum + " @ Buffer is full.\n");
			wait();
		}
		
		//full 이 아니면 data에 원소를 추가하고 notify
		System.out.println("Producer#" + pNum + " Adding item on " + loc + ": " + toAdd);
		data[loc++] = toAdd;
		System.out.println(this);
		System.out.flush();
		notifyAll();
	}
	
	//버퍼에 존재하는 원소를 소모하는 함수
	public synchronized double remove(int pNum) throws InterruptedException{
		//버퍼가 비어있다면 wait
		while(loc <= 0) {
			System.out.println("Consumer#" + pNum + " O Buffer is empty.\n");
			wait();
		}
		//empty가 아니면 스택 맨 위 값을 리턴하고 그 값을 0 으로 초기화 후 notify
		double hold = data[--loc];
		System.out.println("Consumer#" + pNum + " Removing item on " + loc + ": " + hold);
		data[loc] = 0.0;
		System.out.println(this);
		System.out.flush();
		notifyAll();
		return hold;
	}
	
}
