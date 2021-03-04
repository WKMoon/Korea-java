package bank;

public class Bank {
	static final int KEY = 3;
	//돈
	int money;
	String name;
	String account;
	String pw;
	String phone;
	
	//객체
	public Bank() {
		// TODO Auto-generated constructor stub
	}
	public Bank(int money) {
		this.money = money;
	}
	

	
	//메소드
	//입금
	/**
	 * 
	 * @param money
	 */
	void deposit(int money) {
		if(money < 0) {throw new ArithmeticException();}
		this.money += money;
	}
	//출금
	boolean withdraw(int money) {
		if(this.money - money < 0) {
			return false;
		}
		this.money -= money;
		return true;
	}
	//잔액조회
	int balance() {
		return this.money; 
	}
	
	//암호화
	public static String encrypt(String pw) {
		String en_pw = "";
		for(int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	//복호화
	public static String decrypt(String en_pw) {
		String de_pw = "";
		for(int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / KEY);
		}
		return de_pw;
	}
}
