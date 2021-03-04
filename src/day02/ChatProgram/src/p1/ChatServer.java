package p1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer extends Thread implements ActionListener{

	Frame frame;//윈도우창 프레임 지원 클래스
	TextArea ta;//채팅된 내용 부분
	TextField tf;//채팅 쓰는 부분
	ServerSocket s;
	Socket s1;
	DataOutputStream dos;
	DataInputStream dis;
	boolean stop;
	
	public ChatServer() {
		launchFrame();//화면 구현
		service();//서버 연결 화면
	}
	
	private void service() {
		//네트워크 연결하기
		try {
			ta.append("서비스 하기 위해서 준비중...\n");

			s = new ServerSocket(5432);
			ta.append("클라이언트 접속 대기중...\n");
			s1 = s.accept();
			ta.append("클라이언트가 접속하였습니다.." + s1.getInetAddress() + "\n");
			dos = new DataOutputStream(s1.getOutputStream());
			dis = new DataInputStream(s1.getInputStream());
			this.start();
			dos.writeUTF("채팅 서버에 접속하신 것을 환엽합니다..");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
			try {
				while(!stop) {
				ta.append(dis.readUTF()+"\n");
				}//end while
				dis.close(); s1.close();
			} 
			catch(EOFException e){System.out.println("클라이언트로부터 연결이 끊겼습니다...\n");}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void launchFrame() {
		//채팅 화면 구현
		frame  = new Frame("일대일 채팅");
		ta = new TextArea();
		tf = new TextField();
		frame.setBackground(Color.LIGHT_GRAY);
		ta.setEditable(false);//수정 막음
		frame.add(ta, BorderLayout.CENTER);
		frame.add(tf, BorderLayout.SOUTH);
		tf.addActionListener(this);
		frame.setSize(500,300);
		frame.setVisible(true);
		tf.requestFocus();
		
	}

	public static void main(String[] args) {
		new ChatServer();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String msg = tf.getText();
		ta.append(msg + "\n");
		if(msg.equals("exit")) {
			ta.append("bye");
			stop = true;
			try {
				dos.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				s1.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}else {
			try {
				dos.writeUTF("서버 : " + msg);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			tf.setText("");
		}//end else
	}

}
