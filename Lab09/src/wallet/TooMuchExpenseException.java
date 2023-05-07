package wallet;

public class TooMuchExpenseException extends Exception{
	private int inputNum;
	public TooMuchExpenseException() {
		super("Not enough balance");
	}
	public TooMuchExpenseException(int n) {
		super("Over the limit!");
		inputNum = n;
	}
	
	public int getInputNum() {
		return inputNum;
	}

}
