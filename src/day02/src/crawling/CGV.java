package crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CGV {
	private WebDriver driver;
	private WebElement el;
	
    public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
    
    
    public static void main(String[] args) {
		CGV cgv = new CGV();
		WebElement el1 = null;
		WebElement el2 = null;
		//드라이버 설정
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//webdriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		cgv.driver = new ChromeDriver(options);
//		cgv.driver = new ChromeDriver();
		
		String url = "http://www.cgv.co.kr/movies/";
		
		cgv.driver.get(url);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		btn-more-fontbold
		
		el1 = cgv.driver.findElement(By.className("btn-more-fontbold"));//더보기 버튼
		
		//동적
		el1.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		sect-movie-chart
		el2 = cgv.driver.findElement(By.className("sect-movie-chart"));
		int rank = 0;
		//가져온 태그 안에 찾을 자식 태그가 있다면 또 한번 findElement()를 사용할 수 있다.
		for(WebElement film : el2.findElements(By.className("title"))) {
			System.out.println(++rank + ". "+film.getText());
		}//end for
		
		try {
			if(cgv.driver != null) {
			//드라이버 연결 종료
			cgv.driver.close();
			//프로세스 종료
			cgv.driver.quit();
			}//end if
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
