package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import dao.MemberDAO;
import dao.MemberDTO;
import dao.RecordNotFoundException;

//화면 
public class ManagerGUI {
   //화면에 관련된 컴포넌트들을 전역 변수로 선언
   Frame frame;
   Panel[] panel;
   Label lblTitle, lblName, lblHeight, lblWeight, lblSex, lblAge, lblStatus;
   TextField tfName, tfHeight, tfWeight, tfAge;
   Button btnSave, btnDelete, btnUpdate, btnReset, btnSearch;
   List list;
   Checkbox chMale, chFemale;
   CheckboxGroup chGroup;

   public ManagerGUI() {
      frame   = new Frame("회원관리");
      panel = new Panel[13];
      for(int i=0;i<panel.length;i++) {
         panel[i] = new Panel();
      }
      lblTitle = new Label("회원관리", Label.CENTER);
      Font font = new Font("dialog", Font.BOLD, 20);
      lblTitle.setFont(font); 
      lblTitle.setForeground(new Color(123,54,32));
      lblName = new Label("이름");
      lblAge = new Label("나이");
      lblHeight = new Label(" 키 ");
      lblWeight = new Label("체중");
      lblSex = new Label("성별");
      lblStatus = new Label("");
      lblStatus.setBackground(Color.LIGHT_GRAY);
      tfName = new TextField("");
      tfHeight = new TextField("");
      tfWeight = new TextField("");
      tfAge = new TextField("");
      btnSave = new Button("저장");
      btnSearch = new Button("검색");
      btnDelete = new Button("삭제");
      btnUpdate = new Button("수정");
      btnReset = new Button("지우기");
      chGroup = new CheckboxGroup();
      chMale = new Checkbox("Male", chGroup, false);
      chFemale = new Checkbox("Female", chGroup, false);
      list = new List(7, false);

      //닫기 버튼 활성화
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         };
      } );

      list.addItemListener(new ItemListener() {

         @Override
         public void itemStateChanged(ItemEvent e) {
            String str = list.getSelectedItem();
            StringTokenizer st = new StringTokenizer(str);
            tfName.setText(st.nextToken());
            tfAge.setText(st.nextToken());
            tfWeight.setText(st.nextToken());
            tfHeight.setText(st.nextToken());
            String sex = st.nextToken();
            if(sex.equals("남")) {
               chMale.setState(true);
            }else {
               chFemale.setState(true);
            }
         }
      });
      
   

   }
   private void launchFrame() {
      panel[1].setLayout(new GridLayout(2,1));
      panel[1].add(lblName);
      panel[1].add(lblHeight);
      panel[2].setLayout(new GridLayout(2,1));
      panel[2].add(tfName);
      panel[2].add(tfHeight);
      panel[3].setLayout(new BorderLayout());
      panel[3].add(panel[1], "West");
      panel[3].add(panel[2], "Center");
      panel[4].setLayout(new GridLayout(2,1));
      panel[4].add(lblAge);
      panel[4].add(lblWeight);
      panel[5].setLayout(new GridLayout(2,1));
      panel[5].add(tfAge);
      panel[5].add(tfWeight);
      panel[6].setLayout(new BorderLayout());
      panel[6].add(panel[4], "West");
      panel[6].add(panel[5], "Center");
      panel[6].add(new Label(""), "East");
      panel[7].setLayout(new GridLayout(1,2));
      panel[7].add(panel[3]);
      panel[7].add(panel[6]);
      panel[8].add(lblSex);
      panel[8].add(chMale);
      panel[8].add(chFemale);
      panel[9].setLayout(new BorderLayout());
      panel[9].add(lblTitle, "North");
      panel[9].add(panel[7], "Center");
      panel[9].add(panel[8], "South");
      panel[10].setLayout(new GridLayout(1,5));
      panel[10].setBackground(Color.black);
      panel[10].setForeground(Color.white);
      panel[10].add(new Label("이 름   "));
      panel[10].add(new Label("나 이   "));
      panel[10].add(new Label("체 중  "));
      panel[10].add(new Label(" 키    "));
      panel[10].add(new Label("성 별   "));
      panel[11].setLayout(new BorderLayout());
      panel[11].add(panel[10], "North");
      panel[11].add(list, "Center");
      panel[0].add(btnSave);
      panel[0].add(new Label(" "));
      panel[0].add(btnSearch);
      panel[0].add(new Label(" "));
      panel[0].add(btnDelete);
      panel[0].add(new Label(" "));
      panel[0].add(btnUpdate);
      panel[0].add(new Label(" "));
      panel[0].add(btnReset);
      panel[12].setLayout(new BorderLayout());
      panel[12].add(panel[9], "North");
      panel[12].add(panel[11], "Center");
      panel[12].add(panel[0], "South");
      
      frame.add(panel[12], "Center");
      frame.add(lblStatus, "South");
      frame.setSize(300,300);
      frame.pack();
      frame.setResizable(false);
      //창을 어떤 화면의 크기에 상관없이 가운데 오게 하기 
      frame.setLocation( ((frame.getToolkit().getScreenSize()).width - frame.getWidth()) / 2,
            ((frame.getToolkit().getScreenSize()).height - frame.getHeight() ) / 2   );
      
      frame.setVisible(true);
      
      //회원정보 보기 
      displayAll();
      
     //새롭게 입력한 회원정보를 버튼이랑 연결 
   	btnSave.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			String name=tfName.getText();
			String age=tfAge.getText();
			String heigth=tfHeight.getText();
			String weigth=tfWeight.getText();
			String sex="여";
			
			if(chMale.getState()) {
				//남자쪽버튼이 눌러져 있으면  남자로 바꿔주세요 
				sex="남";
			}
		MemberDAO dao=new MemberDAO();//정보를 넣을 생성자를 생성
		dao.insert(name, age, heigth, weigth, sex);
		displayAll();
		lblStatus.setText("한 행이 추가되었습니다.");
		}
	});
     
   	//정보 지우기 버튼 
   	btnReset.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			tfName.setText("");
			tfAge.setText("");
			tfHeight.setText("");
			tfWeight.setText("");
			chGroup.setSelectedCheckbox(null);
		}
	});
   	//삭제 버튼 
   	btnDelete.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name=tfName.getName();
			MemberDAO dao=new MemberDAO();//DAO에 있는 메소드를 쓰기위해 
			dao.delete(name);
			displayAll();
			lblStatus.setText("한 행이 삭제되었습니다..");
		}
	});
   	
   	//수정 버튼 
   	btnUpdate.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name=tfName.getText();//tfNmae은 이름을 입력하거나 뜨는 쪽 네모칸 
			String age=tfAge.getText();
			String height=tfHeight.getText();
			String weight=tfWeight.getText();
			String sex="남";
			
			if(chFemale.getState()) {
				sex="여";
			}
			MemberDAO dao = new MemberDAO();
			dao.update(name, age, height, weight, sex);
			displayAll();
			lblStatus.setText(name+"의 자료가 수정되었습니다.");
		}
	});
   	
   	//검색버튼 
   	btnSearch.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name=tfName.getText();
			MemberDAO dao=new MemberDAO();
			MemberDTO dto=new MemberDTO();
			
			//예외처리 RecordNotFoundException 
			try {
				dto = dao.serch(name);
			} catch (RecordNotFoundException e1) {
				// TODO Auto-generated catch block
				lblStatus.setText(e1.getMessage());
			}
			
			
			
			//dto에는 검색할려는 사람의 이름이 들어있다 
			//dto->화면 넣기
			tfName.setText(dto.getName());
			tfAge.setText(Integer.toString(dto.getAge()));
			//dto getage는 숫자이고 tfage에는 string타입으로 줘야하기 때문에 바꿔줌
			tfHeight.setText(String.valueOf(dto.getHeight()));
			//String .valueof -> 문자열로 바꾸기  
			//tfHeight.setText(""+dto.getHeight())); 이렇게도 문자열로 바꾸기 가능 
			tfWeight.setText(String.valueOf(dto.getWeight()));
			String sex=Character.toString(dto.getSex());
			//sex는 char타입이기 때문에 character 래퍼 클래스에 있는 toString()메소드를 사용
			
			if(sex.equals("남")) {
				chMale.setState(true);
			}else {
				chMale.setState(true);
			}
			
			
			
		}
	});
   	
   }//end launchFrame()

   	public void displayAll() {
   		list.removeAll(); 
   		//리스트 화면 클리어 
   		//awt에 있는 list이다.
   		MemberDAO dao=new MemberDAO();
   		ArrayList<MemberDTO> allDate =dao.select();
   		for(MemberDTO dto : allDate) {
   			String name = dto.getName();
   			int age=dto.getAge();
   			int height=dto.getHeight();
   			int weight=dto.getWeight();
   			char sex= dto.getSex();
   			list.add(name+"    "+age+"    "+weight+"    "+height+"    "+sex);
   		}
   	}
   
   	//회원정보 저장하기 버튼 연결
  
   	
   	
   public static void main(String[] args) {
      ManagerGUI mem= new ManagerGUI();
      mem.launchFrame();//화면
   }



}
