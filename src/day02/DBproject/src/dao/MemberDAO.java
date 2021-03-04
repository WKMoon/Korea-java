package dao;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



//데이터베이스 연결하는 클래스
public class MemberDAO {
//1.오라클 데이터베이스 연동을 위한 4가지 정보를 문자열에 저장
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String userid="system";//만든 맴버 클래스의 아이디랑 비밀번호 
	String passwd="1234";

	
	public MemberDAO() {
		try {			
	//2.드라이버 로딩  OracleDriver 클래스를 자바에서 이용하기 위해서 JVM에 올려줌
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}// end memberDAO
	
	//회원 정보 보기 
	public ArrayList<MemberDTO> select(){
		ArrayList list=new ArrayList<MemberDTO>();
	    Connection con = null;
		
		PreparedStatement pstmt=null;
		//자바에서 넣은 값을 db로 넣어주기 
		//insert into member values(?,?,?,?,?); 이런 쿼리문을 사용할때 쓰는 것 
		
		ResultSet rs=null;
		//쿼리문에서 결과값을 반환하기 위해 
		//select할때만 결과를 담는 것
		
		
		//3.Connection 맺기 
		try {
			con=DriverManager.getConnection(url,userid,passwd);
			String query="SELECT*FROM member";//5.sql문 작성 
		    pstmt =con.prepareStatement(query);//4.PreparedStatement 생성 
		    
			//Ouery의 실행 결과를 가져온다.
			//Select 쿼리 일 떄만 사용한다.
			rs = pstmt.executeQuery(); //6.요청할 sql문을 전송하고 실행하는 클래스 
			
			while(rs.next()) {
				MemberDTO dto=new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setHeight(rs.getInt("height"));
				dto.setWeight(rs.getInt("weight"));
				dto.setSex(rs.getString("sex").charAt(0));
				list.add(dto); //리스트에 하나씩 추가 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			 //다쓰면 연결을 해제해야한다. 해제를 안시키면 다른 사용자가 쓸수 없으므로. 닫을때 finally를 사용하여 닫는다.
            // 열렸는지 체크하면서 닫아줘야한다. 
			//값이변경됬는지 보고 열린지 판단 / resultset부터 반대로 확인 > statement > connection 순으로
			
			//7.자원 반납
			if(rs != null)
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return list;
	}//end select()
	
	//저장버튼 기능-데이터베이스 안으로 새로운 자료 넣기 
	public void insert(String name, String age, String heigth, String weigth,String sex) {
		Connection con = null;
		PreparedStatement pstmt=null;
		//ptrparedStatment
		//?,?,?,?,?.이곳 안에 데이터를 받기 위해 실행 
		
		try {
			con=DriverManager.getConnection(url,userid,passwd);
			String sql="INSERT INTO member (name,age,height,weight,sex)"
					+ "VALUES(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			//?안에 실제 데이터 넣기 
			pstmt.setString(1, name);//1번?애 name을 넣어주세요
			pstmt.setInt(2, Integer.parseInt(age));
			//age는 처음에 String 으로 받앗지만 데이터베이스는 int로 선언 해놨기 때문에 int로 바꿔줘야한다.
			pstmt.setInt(3,	Integer.parseInt(heigth));
			pstmt.setInt(4,	Integer.parseInt(weigth));
			pstmt.setString(5, sex);
			
			int n=pstmt.executeUpdate();//excuteupdate->sql저장한 것을 실행 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}//end insert
	
	
	//검색버튼 기능
	//하나의 정보씩 가져올것 
	//serch()정보를 찾아오는 메소드 
	//이름은 프라이머리 키 이기 때문에 유일하다 그래서 이름으로 검색 
	public MemberDTO serch(String name) throws RecordNotFoundException {
		
		if(! isExist(name)) 
			throw new RecordNotFoundException("찾는 이름이 없습니다");
		//return 값이 true이기 떄문에 false이면으로 정의 
		
		MemberDTO dto=new MemberDTO();
		Connection con= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(url,userid,passwd);//드라이버 연결
			String sql="SELECT * FROM member WHERE name= ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			//.executeQuery()
			//메서드는 데이터베이스에서 데이터를 추가(Insert), 삭제(Delete), 수정(Update)하는 SQL 문을 실행합니다
			
			while(rs.next()) {
				dto.setName(rs.getString("name"));
				//rs.get->데이터 베이스에서 가져오기 
				dto.setAge(rs.getInt("age"));
				dto.setHeight(rs.getInt("height"));
				dto.setWeight(rs.getInt("weight"));
				dto.setSex(rs.getString("sex").charAt(0));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
		
		
	}
	
	
	
	//삭제버튼 기능 
	
	//수정버튼 기능
	public void update(String name,String age,String height,String weight,String sex) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DriverManager.getConnection(url,userid,passwd);
			String sql="UPDATE member SET age=?, height=?,weight=?, sex=? WHERE name=?";
			//디비에서 쓰는 쿼리문 쓰기 
			pstmt=con.prepareStatement(sql);//sql문이 pstmt로 리턴
			pstmt.setInt(1, Integer.parseInt(age));
			pstmt.setInt(2, Integer.parseInt(height));
			pstmt.setInt(3, Integer.parseInt(weight));
			pstmt.setString(4, sex);
			pstmt.setString(5, name);//이름은 key라서 바꿀수 없음 그래서 원래 있던 이름이 그대로 들어감 
			int n= pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	//지우기버튼 기능
	public void delete(String name) {
		//이름만 받는 이유는 디비에서 이름만 받아도 그 행이 지워지기 때문이다.
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con=DriverManager.getConnection(url,userid,passwd);
			String sql="DELETE FROM member WHERE name=?";
			con.prepareStatement(sql);
			pstmt.setString(1,name);
			int n=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	   //name이 존재하는지 체크하는 메소드
    public boolean isExist(String name) {
    	boolean result=false;
    	Connection con= null;
    	PreparedStatement pstmt=null;
    	ResultSet rs=null;
    	
    	try {
			con=DriverManager.getConnection(url,userid,passwd);
			String sql="SELECT*FROM member WHERE name=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				result=true;
			}
			
			
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
  	  return result;
    }
	
}//class end
