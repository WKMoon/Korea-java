package user;

public class Form {
	public static void main(String[] args) {
		UserField uf = new UserField();
		
		User user=  new User();
		
		user.id = "hds1234";
		user.pw = "4321";
		
		
		String msg = uf.join(user) ? "회원가입 성공" : "회원가입 실패";
		System.out.println(msg);
		
		msg = uf.login("hds1234", "4321") ? "로그인 성공" : "로그인 실패";
		System.out.println(msg);
	}
}
