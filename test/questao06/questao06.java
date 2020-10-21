package questao06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class questao06 {
	
	@Test
	public void testeA() {
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://andreendo.github.io/sample-ui-compras/example.html");
		
		d.findElement(By.name("produto")).sendKeys("Teste de Software");
		d.findElement(By.name("quantidade")).sendKeys("10");
		d.findElement(By.xpath("//*[@id=\"root\"]/div/form/input")).click();
		
		String firstH1 = d.findElement(By.tagName("h1")).getText();
		d.findElement(By.xpath("//*[@id=\"root\"]/div/div/button")).click();
		
		String secondH1 = d.findElement(By.tagName("h1")).getText();
		
		assertNotEquals(firstH1, secondH1);
		
		d.close();
	}
	
	@Test
	public void testeB() {
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://andreendo.github.io/sample-ui-compras/example.html");
		
		d.findElement(By.name("produto")).sendKeys("Produto 1");
		d.findElement(By.name("quantidade")).sendKeys("10");
		d.findElement(By.xpath("//*[@id=\"root\"]/div/form/input")).click();

		d.findElement(By.name("produto")).sendKeys("Produto 2");
		d.findElement(By.name("quantidade")).sendKeys("20");
		d.findElement(By.xpath("//*[@id=\"root\"]/div/form/input")).click();

		d.findElement(By.name("produto")).sendKeys("Produto 3");
		d.findElement(By.name("quantidade")).sendKeys("30");
		d.findElement(By.xpath("//*[@id=\"root\"]/div/form/input")).click();

		d.findElement(By.name("produto")).sendKeys("Produto 4");
		d.findElement(By.name("quantidade")).sendKeys("40");
		d.findElement(By.xpath("//*[@id=\"root\"]/div/form/input")).click();
		
		d.findElement(By.id("prod3")).click();
		d.findElement(By.id("prod0")).click();
		
		assertEquals("removerProduto 2 - 20", d.findElement(By.xpath("//*[@id=\"root\"]/div/div/ul/li[1]")).getText());
		assertEquals("removerProduto 3 - 30", d.findElement(By.xpath("//*[@id=\"root\"]/div/div/ul/li[2]")).getText());
		
		d.close();
		
	}
	
	@Test
	public void testeC() {
		System.setProperty("webdriver.chrome.driver", "./libs/chromedriver");
		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		d.get("https://andreendo.github.io/sample-ui-compras/example.html");
		
		d.findElement(By.name("produto")).sendKeys("Produto 1");
		d.findElement(By.name("quantidade")).sendKeys("10");
		d.findElement(By.xpath("//*[@id=\"root\"]/div/form/input")).click();

		d.findElement(By.name("produto")).sendKeys("Produto 2");
		d.findElement(By.name("quantidade")).sendKeys("20");
		d.findElement(By.xpath("//*[@id=\"root\"]/div/form/input")).click();

		d.findElement(By.name("produto")).sendKeys("Produto 3");
		d.findElement(By.name("quantidade")).sendKeys("30");
		d.findElement(By.xpath("//*[@id=\"root\"]/div/form/input")).click();

		d.findElement(By.xpath("//*[@id=\"root\"]/div/div/button")).click();
		
		assertEquals("3 itens a comprar", d.findElement(By.tagName("h2")).getText());
		
		d.findElement(By.xpath("//*[@id=\"Produto 2:20\"]")).click();
		assertTrue(d.findElement(By.xpath("//*[@id=\"Produto 2:20\"]")).isSelected());
		
		d.close();
		
	}

}