package bank;

import java.util.Random;
import java.util.Scanner;

public class ATMversion2 {
	// 각 은행별로 최대 100명의 고객을 유치할 수 있다.
	Shinhan[] arS = new Shinhan[100];
	Kookmin[] arK = new Kookmin[100];
	Woori[] arW = new Woori[100];

	int[] arMemberCount = { 0, 0, 0 };

	Bank[][] arrBank = { arS, arK, arW };

	// 메인메뉴 : 은행 선택(신한, 국민, 우리)
	String main_menu = "1.신한은행\n2.국민은행\n3.우리은행\n4.나가기";
	// 사용자 메뉴 : 계좌개설, 입금하기, 출금하기, 잔액조회, 계좌번호 찾기, 돌아가기
	String user_menu = "1.계좌개설\n2.입금하기\n3.출금하기\n4.잔액조회\n5.돌아가기";

	static Scanner sc = new Scanner(System.in);

	int bank_choice = 0;
	int user_choice = 0;

	Random r = new Random();

	// 계좌 개설 시 필요한 정보
	// 1. 예금주
	String name = null;
	// 2. 비밀번호(비밀번호는 4자리이고, 4자리를 입력할 때 까지 무한반복)
	String pw = null;
	// 3. 계좌번호(계좌번호는 6자리이며, 100000부터 시작한다. 중복검사 후 중복이 없을 때 까지 무한반복)
	String account = null;
	// new Random().nextInt() 사용
	// 4. 핸드폰 번호(-를 제외하고 입력받으며, 중복검사 후 중복이 없을 때 까지 무한 반복)
	String phone = null;

	// 사용자가 원하는 금액을 담을 변수
	int money = 0;

	// 계좌번호 FLAG
	boolean isDupAccount = false;

	// 고객을 담아줄 임시 저장소
	Bank temp = null;

	public static void main(String[] args) {

		ATMversion2 a2 = new ATMversion2();
		while (true) {
			System.out.println(a2.main_menu);
			a2.bank_choice = sc.nextInt();

			if (a2.bank_choice == 4) {
				break;
			} // end if

			while (true) {
				System.out.println(a2.user_menu);
				a2.user_choice = sc.nextInt();

				switch (a2.user_choice) {
				case 1:
					a2.register();
					break;
				case 2:
					a2.deposit();
					break;
				case 3:
					a2.withdraw();
					break;
				case 4:
					a2.balance();
					break;
				case 5:
					break;
				}// end switch
				break;
			} // end while
		} // end while
	}// end main

	void register() {

		if (arMemberCount[user_choice - 1] == arrBank[user_choice - 1].length) {
			System.out.println("정원 초과입니다.");
			return;
		} // end if

		System.out.print("예금주: ");
		name = sc.next();

		while (true) {
			System.out.println("비밀번호: ");
			pw = sc.next();
			if (pw.length() == 4) {
				break;
			} // end if
		} // end while

		while (true) {
			isDupAccount = false;

			account = r.nextInt(900000) + 100000 + "";

			for (int i = 0; i < arMemberCount.length; i++) {
				for (int j = 0; j < arMemberCount[i]; j++) {
					if (arrBank[i][j].account.equals(account)) {
						isDupAccount = true;
						break;
					}
				} // end for
				if (isDupAccount) {
					break;
				}
			} // end for
			if (!isDupAccount) {
				break;
			}
		} // end while

		while (true) {
			boolean isRightPhoneNumber = false;
			boolean isDupPhone = false;

			System.out.println("전화 번호: ");
			phone = sc.next();

			for (int i = 0; i < phone.length(); i++) {
				char c = phone.charAt(i);
				if (c < 48 || c > 57) {
					isRightPhoneNumber = true;
					break;
				}
			} // end for
			if (isRightPhoneNumber) {
				continue;
			}

			for (int i = 0; i < arMemberCount.length; i++) {
				for (int j = 0; j < arMemberCount[i]; j++) {
					if (arrBank[i][j].phone.equals(phone)) {
						isDupPhone = true;
						break;
					}
				} // end for
				if (isDupPhone) {
					break;
				} // end if
			} // end for

			if (!isRightPhoneNumber && !isDupPhone) {
				break;
			} // end if

		} // end while

		Bank[] arNewMember = { new Shinhan(), new Kookmin(), new Woori() };

		temp = arrBank[bank_choice - 1][arMemberCount[bank_choice - 1]] = arNewMember[bank_choice - 1];

		temp.name = name;
		temp.account = account;
		temp.pw = Bank.encrypt(pw);
		temp.phone = phone;
		
        System.out.println("예금주 : " + temp.name);
        System.out.println("계좌번호 : " + temp.account);
        System.out.println("암호화 : " + temp.pw);
        System.out.println("복호화 : " + temp.pw);
        System.out.println("폰번호 : " + temp.phone);

		arMemberCount[bank_choice - 1]++;

	}// end register

	void deposit() {
		while (true) {
			isDupAccount = false;

			System.out.println("계좌 번호: ");
			account = sc.next();

			for (int i = 0; i < arMemberCount.length; i++) {
				for (int j = 0; j < arMemberCount[i]; j++) {
					if (arrBank[i][j].account.equals(account)) {
						isDupAccount = true;
						temp = arrBank[i][j];
						break;
					}
				}
				if (isDupAccount) {
					break;
				}
			} // end for
			if (!isDupAccount) {
				System.out.println("유효하지 않은 계좌번호입니다.");
				continue;
			}//end if
			
			System.out.println("비밀번호: ");
			pw = sc.next();
			
			pw = Bank.encrypt(pw);
			if(temp.pw.equals(pw)) {
				System.out.println("입금액");
				money = sc.nextInt();
				if(money < 1) {
					System.out.println("해당 금액은 입금하실 수 없습니다.");
					continue;
				}//end if
				
				temp.deposit(money);
				System.out.println("입금 성공");
				break;
			}//end if
			else {
				System.out.println("잘못된 비밀번호입니다.");
				continue;
			}//end else
			
		} // end while
	}// end deposit

	void withdraw() {
		while(true) {
			isDupAccount = false;

			System.out.println("계좌 번호: ");
			account = sc.next();

			for (int i = 0; i < arMemberCount.length; i++) {
				for (int j = 0; j < arMemberCount[i]; j++) {
					if (arrBank[i][j].account.equals(account)) {
						isDupAccount = true;
						temp = arrBank[i][j];
						break;
					}
				}
				if (isDupAccount) {
					break;
				}
			} // end for
			if (!isDupAccount) {
				System.out.println("유효하지 않은 계좌번호입니다.");
				continue;
			}//end if
			
			System.out.println("비밀번호: ");
			pw = sc.next();
			
			pw = Bank.encrypt(pw);
			if(temp.pw.equals(pw)) {
				System.out.println("출금액");
				money = sc.nextInt();
				if(money > temp.money || money < 1) {
					System.out.println("해당 금액은 출금하실 수 없습니다.");
					continue;
				}//end if
				
				boolean check = temp.withdraw(money);
				if(check) {
					System.out.println("출금 성공");
					break;
				}else {
					System.out.println("출금실패");
				}
				break;
			}//end if
			else {
				System.out.println("잘못된 비밀번호입니다.");
				continue;
			}//end else			
		}//end while
	}// end withdraw

	void balance() {
		while(true) {
			isDupAccount = false;
			
			System.out.println("계좌 번호: ");
			account = sc.next();
			
			for(int i = 0; i < arMemberCount.length; i++) {
				for(int j = 0; j < arMemberCount[i]; j++) {
					if(arrBank[i][j].account.equals(account)) {
						isDupAccount = true;
						temp = arrBank[i][j];
						break;
					}//end if
				}//end for
				if(isDupAccount) {
					break;
				}//end if
			}//end for
			System.out.println("비밀 번호: ");
			pw = sc.next();
			pw = Bank.encrypt(pw);
			if(temp.pw.equals(pw)) {
				System.out.println("잔액: " + temp.money);
				break;
			}//end of
			else {
				System.out.println("잘못된 비밀번호입니다.");
				continue;
			}//end else
		}//end while
	}// end balance



}// end class
