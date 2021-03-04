package dao;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



//�����ͺ��̽� �����ϴ� Ŭ����
public class MemberDAO {
//1.����Ŭ �����ͺ��̽� ������ ���� 4���� ������ ���ڿ��� ����
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String userid="system";//���� �ɹ� Ŭ������ ���̵�� ��й�ȣ 
	String passwd="1234";

	
	public MemberDAO() {
		try {			
	//2.����̹� �ε�  OracleDriver Ŭ������ �ڹٿ��� �̿��ϱ� ���ؼ� JVM�� �÷���
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}// end memberDAO
	
	//ȸ�� ���� ���� 
	public ArrayList<MemberDTO> select(){
		ArrayList list=new ArrayList<MemberDTO>();
	    Connection con = null;
		
		PreparedStatement pstmt=null;
		//�ڹٿ��� ���� ���� db�� �־��ֱ� 
		//insert into member values(?,?,?,?,?); �̷� �������� ����Ҷ� ���� �� 
		
		ResultSet rs=null;
		//���������� ������� ��ȯ�ϱ� ���� 
		//select�Ҷ��� ����� ��� ��
		
		
		//3.Connection �α� 
		try {
			con=DriverManager.getConnection(url,userid,passwd);
			String query="SELECT*FROM member";//5.sql�� �ۼ� 
		    pstmt =con.prepareStatement(query);//4.PreparedStatement ���� 
		    
			//Ouery�� ���� ����� �����´�.
			//Select ���� �� ���� ����Ѵ�.
			rs = pstmt.executeQuery(); //6.��û�� sql���� �����ϰ� �����ϴ� Ŭ���� 
			
			while(rs.next()) {
				MemberDTO dto=new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setHeight(rs.getInt("height"));
				dto.setWeight(rs.getInt("weight"));
				dto.setSex(rs.getString("sex").charAt(0));
				list.add(dto); //����Ʈ�� �ϳ��� �߰� 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			 //�پ��� ������ �����ؾ��Ѵ�. ������ �Ƚ�Ű�� �ٸ� ����ڰ� ���� �����Ƿ�. ������ finally�� ����Ͽ� �ݴ´�.
            // ���ȴ��� üũ�ϸ鼭 �ݾ�����Ѵ�. 
			//���̺������� ���� ������ �Ǵ� / resultset���� �ݴ�� Ȯ�� > statement > connection ������
			
			//7.�ڿ� �ݳ�
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
	
	//�����ư ���-�����ͺ��̽� ������ ���ο� �ڷ� �ֱ� 
	public void insert(String name, String age, String heigth, String weigth,String sex) {
		Connection con = null;
		PreparedStatement pstmt=null;
		//ptrparedStatment
		//?,?,?,?,?.�̰� �ȿ� �����͸� �ޱ� ���� ���� 
		
		try {
			con=DriverManager.getConnection(url,userid,passwd);
			String sql="INSERT INTO member (name,age,height,weight,sex)"
					+ "VALUES(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			//?�ȿ� ���� ������ �ֱ� 
			pstmt.setString(1, name);//1��?�� name�� �־��ּ���
			pstmt.setInt(2, Integer.parseInt(age));
			//age�� ó���� String ���� �޾����� �����ͺ��̽��� int�� ���� �س��� ������ int�� �ٲ�����Ѵ�.
			pstmt.setInt(3,	Integer.parseInt(heigth));
			pstmt.setInt(4,	Integer.parseInt(weigth));
			pstmt.setString(5, sex);
			
			int n=pstmt.executeUpdate();//excuteupdate->sql������ ���� ���� 
			
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
	
	
	//�˻���ư ���
	//�ϳ��� ������ �����ð� 
	//serch()������ ã�ƿ��� �޼ҵ� 
	//�̸��� �����̸Ӹ� Ű �̱� ������ �����ϴ� �׷��� �̸����� �˻� 
	public MemberDTO serch(String name) throws RecordNotFoundException {
		
		if(! isExist(name)) 
			throw new RecordNotFoundException("ã�� �̸��� �����ϴ�");
		//return ���� true�̱� ������ false�̸����� ���� 
		
		MemberDTO dto=new MemberDTO();
		Connection con= null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=DriverManager.getConnection(url,userid,passwd);//����̹� ����
			String sql="SELECT * FROM member WHERE name= ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			//.executeQuery()
			//�޼���� �����ͺ��̽����� �����͸� �߰�(Insert), ����(Delete), ����(Update)�ϴ� SQL ���� �����մϴ�
			
			while(rs.next()) {
				dto.setName(rs.getString("name"));
				//rs.get->������ ���̽����� �������� 
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
	
	
	
	//������ư ��� 
	
	//������ư ���
	public void update(String name,String age,String height,String weight,String sex) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=DriverManager.getConnection(url,userid,passwd);
			String sql="UPDATE member SET age=?, height=?,weight=?, sex=? WHERE name=?";
			//��񿡼� ���� ������ ���� 
			pstmt=con.prepareStatement(sql);//sql���� pstmt�� ����
			pstmt.setInt(1, Integer.parseInt(age));
			pstmt.setInt(2, Integer.parseInt(height));
			pstmt.setInt(3, Integer.parseInt(weight));
			pstmt.setString(4, sex);
			pstmt.setString(5, name);//�̸��� key�� �ٲܼ� ���� �׷��� ���� �ִ� �̸��� �״�� �� 
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
	
	//������ư ���
	public void delete(String name) {
		//�̸��� �޴� ������ ��񿡼� �̸��� �޾Ƶ� �� ���� �������� �����̴�.
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
	
	   //name�� �����ϴ��� üũ�ϴ� �޼ҵ�
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
