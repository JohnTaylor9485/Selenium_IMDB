import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Main {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.imdb.com");
        String title = driver.getTitle();
        System.out.println("-----------------------Title at mainpage------------------------------------");
        System.out.println(title);
        ((ChromeDriver) driver).findElementById("navbar-query").sendKeys("the avengers");
        ((ChromeDriver) driver).findElementById("navbar-submit-button").click();
        title = driver.getTitle();
        System.out.println("-----------------------Title after search------------------------------------");
        System.out.println(title);
        System.out.println("-----------------------Search result———————------------------------------------");
        List<WebElement> search_result = driver.findElements(By.xpath("//*[@id=\"main\"]/div/div[2]/table"));
        for(WebElement result : search_result){
            System.out.println(result.getText());
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"imdb-signin-link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"signin-options\"]/div/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys("Username");
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("123345");
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("daoerqing2010");
        driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]")).sendKeys("daoerqing");
        driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).submit();
        title = driver.getTitle();
        System.out.println("-----------------------Title at sign up------------------------------------");
        System.out.println(title);
        String waring = driver.findElement(By.xpath("//*[@id=\"auth-error-message-box\"]/div/div")).getText();
        System.out.println("-----------------------warning infrmation------------------------------------");
        System.out.println(waring);
        /*
        the part below is test for register function, to use this part you have to replace the email address and username to you own
         */
//        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).clear();
//        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("775085212@qq.com");
//        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("daoerqing2010");
//        driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]")).sendKeys("daoerqing2010");
//        driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).submit();
//        title = driver.getTitle();
//        System.out.println("-----------------------Title after sign up------------------------------------");
 //      System.out.println(title);

        driver.close();
        driver = new ChromeDriver();
        driver.get("http://www.imdb.com");
        driver.findElement(By.xpath("//*[@id=\"imdb-signin-link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"signin-options\"]/div/div[1]/a[1]/span[2]")).click();
        title = driver.getTitle();
        System.out.println("-----------------------Title at sign in------------------------------------");
        System.out.println(title);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("775085212@qq.com");
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("daoerqing2010");
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).submit();
        waring = driver.findElement(By.xpath("//*[@id=\"auth-warning-message-box\"]/div/div")).getText();
        System.out.println("-----------------------warning information------------------------------------");
        System.out.println(waring);


    }
}
