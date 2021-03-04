package crawling;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NaverBook {
	private WebDriver driver;
	private String url;
	
    public static final String WEB_DRIVER_ID ="webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH ="C:\\chromedriver.exe";
    
    public NaverBook() {
		System.setProperty(WEB_DRIVER_ID,WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		
		url = "https://book.naver.com/";
	}//end cons
    
    public void operate() {
    	loadEmail();
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
    }//end operate
    
    
    public void loadEmail() {
    	
    	Scanner sc = new Scanner(System.in);
    	String book = "저자: ";
    	String choice = "번호: ";
    
    	
    	WebElement element = null;

    	
    	driver.get(url);
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			element = driver.findElement(By.className("snb_search_text"));
			System.out.println(book);
			element.sendKeys(sc.nextLine());
			element.sendKeys(Keys.RETURN);
			
			element = driver.findElement(By.className("basic"));
			
			List<WebElement> bookTitle = element.findElements(By.tagName("dt"));
			
			int num = 0;
			for(int i = 0; i < bookTitle.size(); i++) {
				System.out.println(++num + ". " + bookTitle.get(i).getText());
			}//end for
			
			List<WebElement> bookPrice = element.findElements(By.className("price"));
			List<WebElement> bookComp = element.findElements(By.className("txt_block"));
			System.out.println(choice);
			int choiceNum = sc.nextInt();
			
			System.out.println(bookTitle.get(choiceNum-1).getText() + " " + bookPrice.get(choiceNum-1).getText() + " " + bookComp.get(choiceNum-1).getText());
		} catch (Exception e) {
			System.out.println("해당 검색 결과는 없습니다.");
		}

    	
//		search_recom
    	
    	
    	
    }//end loadEmail
    
    public static void main(String[] args) {
		NaverBook n = new NaverBook();
		n.operate();
	}
}//end naver
