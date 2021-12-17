package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Test1 {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeClass
    public static void beforeTest() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }

    @Test
    public void login() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        driver.get("https://www.ciceksepeti.com/");
        driver.manage().window().setSize(new Dimension(1616, 876));
        driver.findElement(By.className("js-subheader-close")).click();
        WebElement element = driver.findElement(By.linkText("Üyelik"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        WebElement element2 = driver.findElement(By.tagName("body"));
        Actions builder2 = new Actions(driver);
        builder.moveToElement(element, 0, 0).perform();
        driver.findElement(By.cssSelector(".user-menu-container:nth-child(3) .users-process-list__item:nth-child(1) .users-process-list__icon:nth-child(1)")).click();
        driver.findElement(By.id("EmailLogin")).click();
        driver.findElement(By.id("EmailLogin")).sendKeys("sepetic41@gmail.com");
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).sendKeys("password1234");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".pull-right")).click();
    }

    @Test
    public void changePassword() throws InterruptedException {
        login();
        Thread.sleep(3000);
        driver.get("https://www.ciceksepeti.com/");
        driver.manage().window().setSize(new Dimension(1616, 876));
        driver.findElement(By.cssSelector(".user-menu-container:nth-child(3) .user-menu__item:nth-child(3) .user-menu__icon")).click();
        WebElement element = driver.findElement(By.cssSelector(".user-menu-container:nth-child(3) .user-menu__item:nth-child(3) .user-menu__icon"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        WebElement element2 = driver.findElement(By.tagName("body"));
        Actions builder2 = new Actions(driver);
        builder.moveToElement(element, 0, 0).perform();
        driver.findElement(By.cssSelector(".account-menu__item:nth-child(10) .account-menu__text")).click();
        driver.findElement(By.id("OldPassword")).click();
        driver.findElement(By.id("OldPassword")).sendKeys("password1234");
        driver.findElement(By.id("NewPassword")).click();
        driver.findElement(By.id("NewPassword")).sendKeys("sepet5678cicek");
        driver.findElement(By.id("NewPasswordConfirm")).click();
        driver.findElement(By.id("NewPasswordConfirm")).sendKeys("sepet5678cicek");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn-lg")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void afterTest() {

    }

}

