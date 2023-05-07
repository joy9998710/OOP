package wallet;

import java.util.Scanner;

public class Market {
	public static void main(String[] args) {
		Wallet wal1 = new Wallet("my wallet");
		Scanner keyboard = new Scanner(System.in);
		while(true) {
			try {
				wal1.empty();
				System.out.print("Enter price: ");
				int price = keyboard.nextInt();
				if(price < 0) {
					throw new NegativeException();
				}
				else if(price > 100) {
					throw new TooMuchExpenseException(price);
				}
				else if(price > wal1.getBalance()) {
					throw new TooMuchExpenseException();
				}
				else if(0 <= price && price <= wal1.getBalance()) {
					wal1.increaseIndex();
					wal1.decreaseBalance(price);
					System.out.println("peace~~");
				}
			}
			catch(NegativeException e){
				System.out.println(e);
				System.out.println("\tat " + e.getStackTrace()[0]);
				System.out.println("oh, sorry!");
			}
			catch(TooMuchExpenseException e) {
				String temp = e.getMessage();
				System.out.println(e);
				System.out.println("\tat " + e.getStackTrace()[0]);
				if(temp.equals("Over the limit!")){
					System.out.println("you pay " + e.getInputNum());
				}
				System.out.println("oh, my!");
			}
			catch(Exception e) {
				System.out.println(e);
				System.out.println("\tat " + e.getStackTrace()[0]);
				System.out.println("the end...");
				keyboard.close();
				return;
			}
			finally {
				System.out.println(wal1);
				System.out.println("---transaction complete---");
				System.out.println();
			}
		}
	}
}
