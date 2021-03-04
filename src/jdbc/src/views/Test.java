package views;

import dao.USER_TBL_DAO;
import vo.USER_TBL_VO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		USER_TBL_DAO dao = new USER_TBL_DAO();
		USER_TBL_VO vo = new USER_TBL_VO();
		
		
		dao.findPw("mwk","01081915743");
		
		
		
//		System.out.println(dao.findId("01081915743", "1111"));
		
		
//		vo.setAge(10);
//		vo.setId("mwk");
//		vo.setName("문우경");
//		vo.setPhoneNumber("01081915743");
//		vo.setPw("1234");
//		
//		if(dao.join(vo)) {
//			System.out.println("회원가입 성공");
//		}else {
//			System.out.println("회원가입 실패");
//		}
		
		
		
//		if(dao.login("mwk", "1234")) {
//			System.out.println("로그인 성공");
//			System.out.println(USER_TBL_DAO.session_id+"님 환영합니다.");
////			
//			if(dao.change("1234", "1111")) {
//				System.out.println("비밀번호 변경 다시 로그인 해주세요");
//				dao.logout();
//			}
//		
//			if(dao.logout()) {
//				System.out.println("로그아웃 성공");
//			}else {
//				System.out.println("로그인 후 이용 가능합니다.");
//			}
//		}else {
//			System.out.println("로그인 실패");
//		}
		
		
		
		
	}

}
