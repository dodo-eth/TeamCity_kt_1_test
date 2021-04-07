package teamcity.jetbrains.com
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.util.concurrent.TimeUnit

class MyFirstTest {

    var driver: WebDriver?=null

    @BeforeTest
    fun createDriver()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/kotlin/teamcity/jetbrains/com/driver/chromedriver.exe")
        driver =ChromeDriver()
    }
    @AfterTest
    fun  tearDownDriver()
    {
        driver!!.quit()
    }

    @Test
    fun  page_1_test()
    {
        driver!!.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        var url = "https://teamcity.jetbrains.com/"
        driver!!.get(url)
        driver!!.findElement(By.className("auth-button-federated")).click()
        Assert.assertEquals(driver!!.currentUrl,url,"web page did not match")

    }

    @Test
    fun  page_2_test()
    {
        driver!!.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        var url="https://teamcity.jetbrains.com/login.html"
        var fin_url = "https://teamcity.jetbrains.com/overview.html"
        driver!!.get(url)
        driver!!.findElement(By.cssSelector("div:nth-child(5)>a")).click()
        Assert.assertEquals(driver!!.currentUrl,fin_url,"web page did not match")

    }
}
