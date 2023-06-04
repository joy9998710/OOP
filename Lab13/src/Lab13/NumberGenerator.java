package Lab13;

import java.util.ArrayList;

public abstract class NumberGenerator {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public abstract int getNumber();
	public abstract void execute();
	
	//새로운 객체를 arraylist에 추가
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	//ArrayList에 존해나는 객체 하나를 삭제
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	//subject에 변화가 있을 때 이를 observer에 notify하는 역할을 수행
	public void notifyObservers() {
		for(int i =0; i < observers.size(); i++) {
			observers.get(i).update(this);
		}
	}

}
