package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Melon {
	private WebDriver driver;
	private String url;
	
    public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
    
    public Melon() {
		System.setProperty(WEB_DRIVER_ID,WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		url = "https://www.melon.com/";
	}//end cons

    
    public void operate() {
    	searchSong();
    	//드라이버 종료
    	try {
			if(driver != null) {
			driver.close();
			driver.quit();
			}//end if
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
    }
    
    public void searchSong() {
    	//메인로직
    	
    	//노래 제목을 scanner로 입력받고, 검색 결과를 뿌려준 후 사용자가 선택한 노래의 가사를 출력해준다.
    	
    	//1.사용자가 입력한 키워드를 멜론 사이트 검색창에 넣어주기
    	//2.입력한 값으로 검색(엔터)을 해준다.
    	//*엔터 입력: 태그 객체.sendKeys(Keys.RETURN);
    	//3.검색 결과가 없다면 알맞는 메세지 출력
    	//NoSuchElementException(셀레니움 패키지)
    	//4.사용자에게 검색된 곡 정보들을 출력해준다.(10개)
    	//5.사용자가 입력한 번호에 맞게 곡의 가사를 출력해준다.
    	//6.가사가 없거나 성인곡이라면 알맞는 메세지를 출력해준다.
    	Scanner sc = new Scanner(System.in);
    	String searchMsg = "노래 제목: ";
    	String lyricNumMsg = "곡 번호: ";
    	
    	WebElement element = null;
    	//변수의 재사용
    	//1.메모리 효율, 절약
    	//2.가독성이 떨어진다.

    	
    	driver.get(url);
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//검색 창 태그 가져오기
    	element = driver.findElement(By.className("ui-autocomplete-input"));
    	
    	
    	
    	//사용자가 입력한 키워드를 멜론사이트 검색창에 넣어주기
    	System.out.print(searchMsg);
//    	sc.next();
//    	태그 객체.sendKeys(sc.next());
    	element.sendKeys(sc.nextLine());//노래제목에 공백이 포함될수 있기 때문에 nextLine()

    	//엔터 입력
    	element.sendKeys(Keys.RETURN);
    	//검색 결과 페이지 로딩 대기

    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			//곡명으로 검색된 결과를 담고 있는 form태그 객체 frm_searchSong
			element = driver.findElement(By.id("frm_searchSong"));
			
			//곡 번호 가져오기
			List<WebElement> numList = element.findElements(By.className("no"));
			
			
			//곡명 가져오기 fc_gray
			
			List<WebElement> titleList = element.findElements(By.className("fc_gray"));

			//아티스트 가져오기 artistName
			List<WebElement> artistList = element.findElements(By.id("artistName"));

			//가져온 데이터를 통해 목록 출력
			for(int i = 0; i < numList.size(); i++) {
				System.out.println(numList.get(i).getText()+". "+
				titleList.get(i).getText()+ ", 아티스트:"+
				artistList.get(i).getText());
			}
			
			
			//번호 입력
			System.out.print(lyricNumMsg);
			int num = sc.nextInt();
			
			//입력한 번호의 가사 보기 버튼 클릭 btn_icon_detail
			element.findElements(By.className("btn_icon_detail")).get(num-1).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				driver.findElement(By.className("d_register"));
				System.out.println("가사가 없는 곡입니다.");
			} catch (NoSuchElementException nsee) {
				
			
			//가사 펼치기 클릭
			try {
				driver.findElement(By.className("button_more")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//가사 가져와서 출력하기
				element = driver.findElement(By.className("lyric"));
				System.out.println(element.getText());
			} catch (Exception e) {
				System.out.println("성인 노래 가사는 열람하실 수 없습니다.");
			}
			}//end catch
		} catch (NoSuchElementException e) {
			System.out.println("검색 결과가 없습니다.");
		}//end catch
    	//예외처리
    	
    	
    
    	
    	
    }//end searchSong
    
    
    public static void main(String[] args) {
		Melon m= new Melon();
		m.operate();
	}
    
    
    
}//end class
