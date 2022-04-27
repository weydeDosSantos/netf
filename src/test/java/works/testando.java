package works;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testando {
	String url;
	WebDriver driver;

	@Before
	public void setUp() throws Exception {

		url = "https://www.netflix.com/br/login";
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("id_userLoginId")).sendKeys("teste@teste.com.br");
		Thread.sleep(2000);
		driver.findElement(By.id("id_password")).sendKeys(Keys.chord("uede0099"));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#appMountPoint > div > div.login-body > div > div > div.hybrid-login-form-main > form > button")).click();
		Thread.sleep(5000);
	}
		

	@After
	public void tearDown() throws Exception {
	driver.quit();
	}

	@Test
	public void test() {
	String texto = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/div/div[2]")).getText();
	System.out.println(texto);
	assertEquals("Senha incorreta. Tente novamente ou redefina sua senha.", texto);
	}
	

}
