package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import vo.USER_TBL_VO;

public class USER_TBL_DAO {
	public static String session_id;
	
	private static final int KEY = 3;
	
	Connection conn; //접속에 성공한 DB의 연결 객체
	PreparedStatement pstm; //JAVA에서 문자열로 작성한 쿼리문을 저장하고,
							//?에 필요한 값을 채운 후 쿼리를 실행시켜 준다.
	ResultSet rs; //조회 결과값을 담을 수 있는 객체
	
	//아이디 검사
	public boolean checkId(String id) {
		String query  = "select count(*) from USER_TBL where id = ?";
		boolean check = false;
		try {
			//커넥션 객체 가져오기
			conn = DBConnecter.getConnection();
			//가져온 커넥션 객체를 통해 preparedStatement 실행 후 pstm객체에 놓기
			pstm = conn.prepareStatement(query);
			//?에 들어갈 값 설정
			pstm.setString(1, id);
			//완성된 쿼리문을 실행, 결과가 있다면 rs객체에 넣기
			rs = pstm.executeQuery();
			
			//결과 값 행 1개 불러오기
			rs.next();
			//첫번쨰 결과 열 가져오기
			if(rs.getInt(1) == 1) {
				//아이디 검사 후 존재한다면 1, 존재하지 않으면 0
				check = true;
			}
			
		} catch (SQLException e) {
			System.out.println("checkId() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("checkId() 알 수 없는 오류");
		}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		return check;

		}//end checkId
	//회원가입
	public boolean join(USER_TBL_VO user) {
		//INSERT
		//회원 번호는 SEQ 사용
		//USER_SEQ.NEXTVAL: 시퀀스 가져오기
		
		String query = "insert into USER_TBL values (USER_SEQ.NEXTVAL,?,?,?,?,?)";
		boolean check = false;
		//사용자가 입력한 아이디를 DB에서 검사한다.
		if(checkId(user.getId())) {
			//true일 떄 중복이 있다는 뜻
			return check;
		}
		try {
			//커넥션 객체 가져오기
			conn = DBConnecter.getConnection();
			//가져온 커넥션 객체를 통해 preparedStatement 실행 후 pstm객체에 놓기
			pstm = conn.prepareStatement(query);
			//?에 들어갈 값 설정
			pstm.setString(1,user.getId());
			pstm.setString(2,encrypt(user.getPw()));
			pstm.setString(3,user.getName());
			pstm.setInt(4,user.getAge());
			pstm.setString(5,user.getPhoneNumber());
			
			//executeQuery(): SELECT의 결과를 리턴해주는 메소드(ResultSet)
			//executeUpdate(): UPDATE,INSERT,DELETE의 결과 건수를 리턴해주는 메소드(int)
			
			if(pstm.executeUpdate() == 1) {
				check = true;
			}
		
		} catch (SQLException e) {
			System.out.println("join() 쿼리문 오류");

		}catch(Exception e) {
			System.out.println("join() 알 수 없는 오류");

		}finally {
				try {

					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		return check;
	}//end join
	//로그인
	public boolean login(String id, String pw) {
		String query = "select count(*) from USER_TBL where id=? and pw=?";
		boolean check = false;

		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			//행
			rs.next();
			//열
			if(rs.getInt(1) == 1) {
				check = true;
				session_id = id;
			}
			
			
		} catch (SQLException e) {
			System.out.println("login() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("login() 알 수 없는 오류");
		}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		return check;
	}//end login
	
	//로그아웃
	public boolean logout() {
		if(session_id != null) {
			session_id = null;
			return true;
		}//end if
		return false;
	}//end logout
	
	
	
	//삭제(회원 탈퇴)
	public boolean delete(String pw) {
		boolean check = true;
		String query = "delete from USER_TBL where id = ? and pw = ?";
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, pw);
			
			if(pstm.executeUpdate() == 1) {check = true;}
			
		}  catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("delete() 알 수 없는 오류");
		}finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		return check;
	}//end delete
	
	//마이페이지
	public USER_TBL_VO select(String pw) {
		USER_TBL_VO user = null;
		String query = "select * from USER_TBL where id = ? and pw = ?";
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, session_id);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				user = new USER_TBL_VO();
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setPhoneNumber(rs.getString("phonenumber"));
			}
			
		} catch (SQLException e) {
			System.out.println("select() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("select() 알 수 없는 오류");
		}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		return user;
	}//end select
	
	//목록(회원 전체 목록)
	public ArrayList<USER_TBL_VO> selectAll(){
		ArrayList<USER_TBL_VO> ar = new ArrayList();
		String query = "select * from USER_TBL";	
		USER_TBL_VO user = null;

		
		
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				user = new USER_TBL_VO();
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setPhoneNumber(rs.getString("phonenumber"));
				ar.add(user);
			}//end if
			
		}  catch (SQLException e) {
			System.out.println("selectAll() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("selectAll() 알 수 없는 오류");
		}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
		
		}//end finally
		return ar;
	}//end selectAll
	
	
	//아이디 찾기
	//핸드폰 번호와 비밀번호로 아이디 조회
	public String findId(String phonenumber, String pw) {
		String query = "select id from USER_TBL where phonenumber=? and pw=?";
		String id = "";
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, phonenumber);
			pstm.setString(2, encrypt(pw));
			rs = pstm.executeQuery();
			if(rs.next()) {
				id = rs.getString(1);
			}
			
		}catch (SQLException e) {
			System.out.println("searchId() 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("searchId() 알 수 없는 오류");
		}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
		
		}//end finally
		
		
		return id;
	}//end searchId
	
	//수정(비밀번호 변경: 로그인 된 상태에서)
	//현재 비밀번호, 새로운 비밀번호
	public boolean change(String pw, String new_pw) {
		String query = "update USER_TBL set pw=? where id = ? and pw = ?";
		boolean check = false;
		try {
			conn = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, encrypt(new_pw));
			pstm.setString(2, session_id);
			pstm.setString(3, encrypt(pw));
			
			if(pstm.executeUpdate()==1) {
				check = true;
			}
		} catch (SQLException e) {
			System.out.println("change(String,String) 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("change(String,String) 알 수 없는 오류");
		}finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
		}//end finally
		return check;
	}//end change
	
	//수정(비밀번호 변경: 임시비밀번호로 변경)
	
	
	//비번 찾기(아이디와 핸드폰 번호를 전달 받는다.)
	//회원번호와 임시비밀번호로 비밀번호 변경
	public void changePw(int user_number, String temp_pw) {
		String query = "update USER_TBL set pw=? where user_number = ?";
		
		try {
			conn  = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, encrypt(temp_pw));
			pstm.setInt(2, user_number);

			pstm.executeUpdate();
		}catch (SQLException e) {
			System.out.println("changePw(int,String) 쿼리문 오류");
		}catch(Exception e) {
			System.out.println("changePw(int,String) 알 수 없는 오류");
		}finally {
				try {
					if(pstm != null) {
						pstm.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
		}//end finally
	}//end changePw
	
	
	//임시비밀번호 6자리 생성(Random)
	//SMS API를 사용하여 JSON으로 데이터(수신번호, 발신번호, 내용 등) 전송
	//전송된 임시 비밀번호로 update
	//본인 핸드폰에 온 문자 확인 후 임시비밀번호 확인
	
	public void findPw(String id, String phoneNumber) {
		String query = "select user_number from USER_TBL where id = ? and phonenumber = ?";
		
		try {
			conn  = DBConnecter.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, phoneNumber);
			
			rs = pstm.executeQuery();
			if(rs.next()) {
				//임시 비번 생성
				Random r = new Random();
				String temp = "0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+=[] {};:/?";
				String temp_pw = "";
				final int TEMP_PW_LENGTH = 6;
				for (int i = 0; i < TEMP_PW_LENGTH; i++) {
					temp_pw += temp.charAt(r.nextInt(temp.length()));
				}
				//비밀번호 변경
				changePw(rs.getInt(1),temp_pw);
				
				
				//SMS 문자 전송
				 String api_key = "NCSFM7Q8JOBVTHIN";
				    String api_secret = "DPFJQARXRF1PDSLEOT9YXTHUBKLSZEZO";
				    Message coolsms = new Message(api_key, api_secret);

				    // 4 params(to, from, type, text) are mandatory. must be filled
				    HashMap<String, String> params = new HashMap<String, String>();
				    params.put("to", "01081915743");
				    params.put("from", "01081915743");
				    params.put("type", "SMS");
				    params.put("text", "[테스트]\n임시 비밀번호: " + temp_pw + "\n노출될 수 있으니 반드시 비밀번호를 변경해 주세요.");
				    params.put("app_version", "JAVA SDK v2.2"); // application name and version

				    try {
				      JSONObject obj = (JSONObject) coolsms.send(params);
				      System.out.println(obj.toString());
				    } catch (CoolsmsException e) {
				      System.out.println(e.getMessage());
				      System.out.println(e.getCode());
				    }
				
			}//end if
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end findPw
	
	//암호화
	public String encrypt(String pw) {
		String en_pw = "";
		for(int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		return en_pw;
	}
	
	}//end class
	
	
	


