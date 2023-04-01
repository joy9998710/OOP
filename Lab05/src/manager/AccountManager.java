package manager;

import java.time.LocalDate;
import account.Account;

public class AccountManager {
	public static void main(String args[]) {
		LocalDate start = LocalDate.of(2021, 12, 01);
		LocalDate currDate = null;
		Account acc = new Account("Moon", 5, start);
		System.out.println(acc.toString());
		
		int monthPassed = 0;
		int flag = 0;

		while(acc.getBalance() < 10000) {
			acc.receiveIncome(100);
			acc.receiveInterest();
			monthPassed += 1;
			currDate = start.plusMonths(monthPassed);
			
			if(currDate.isEqual(acc.getCreated().plusYears(1)) || currDate.isAfter(acc.getCreated().plusYears(1))) {
				if(currDate.getMonthValue() == 1) {
					int eventNum = (int)(Math.random()*9);
					int randomNum = (int)(Math.random()*9);
					if(eventNum == randomNum) {
						System.out.println("이벤트 당첨!");
						acc.receiveIncome(100);
					}
				}
			}
			
			if(currDate.isAfter(acc.getCreated().plusYears(3)) || currDate.isEqual(acc.getCreated().plusYears(3))) {
				if(flag == 0) {
					acc.increaseYearlyInterest(2);
					System.out.println("가입 후 3년이 지나서 이자율이 2% 인상되었습니다.");
					flag = 1;
				}
			}
		}
		
		System.out.println(acc.toString() + ", 1억 모으기 끝: " + currDate.toString());
	}
}
