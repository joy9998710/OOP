package account;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Account {
	private String name;
	private double yearlyInterest;
	private LocalDate created;
	private double balance;
	
	public Account(String name_, double yearlyInterest_, LocalDate created_) {
		name = name_;
		yearlyInterest = yearlyInterest_;
		created = LocalDate.of(created_.getYear(), created_.getMonthValue(), created_.getDayOfMonth());
		balance = 0;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public LocalDate getCreated() {
		LocalDate temp = LocalDate.of(created.getYear(), created.getMonthValue(), created.getDayOfMonth());
		return temp;
	}
	
	public void increaseYearlyInterest(int percent) {
		yearlyInterest += percent;
	}
	
	public void receiveIncome(double income) {
		balance += income;
	}
	
	public void receiveInterest() {
		balance += (balance*(yearlyInterest/100))/12;
	}
	
	public String toString() {
		return "이름: " + name + ", 연이자: " + yearlyInterest + ", 잔고: " + balance + ", 가입일 : " + created; 
	}
}
