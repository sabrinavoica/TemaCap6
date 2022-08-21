import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class ex2 {
    public static void main(String[] args)  {
        tryTabel ();

    }

    public static void tryTabel(){
        ChromeDriver driver = null;
        try {
            driver = WebDriver.getChromeDriver ();
            driver.get ("https://testpages.herokuapp.com/styled/html5-form-test.html");

            WebElement colour = driver.findElement (By.cssSelector ("input#colour-picker"));
            WebElement date = driver.findElement (By.cssSelector ("input#date-picker"));
            WebElement dateLocal = driver.findElement (By.cssSelector ("input#date-time-picker"));
            WebElement mail = driver.findElement (By.cssSelector ("input#email-field"));
            WebElement month = driver.findElement (By.cssSelector ("input#month-field"));
            WebElement number = driver.findElement (By.cssSelector ("input#number-field"));
            WebElement submitButton = driver.findElement (By.name ("submitbutton"));


            colour.click ();
            colour.sendKeys ("#4033FF");
            date.sendKeys ("01022022");
            dateLocal.sendKeys ("01012021" + Keys.TAB + "0304" + Keys.TAB + "P");
            mail.clear ();
            mail.sendKeys ("sdbjfh@yahoo.com");
            month.sendKeys ("September" + Keys.TAB + "2022");
            number.clear ();
            number.sendKeys ("3");
            submitButton.click ();

            throw new NoSuchFieldException ("Exceptie custom");


        }catch (Exception e){
            System.out.println ("Am intrat in ramura de catch");
            if (driver != null){
                File file = driver.getScreenshotAs (OutputType.FILE);
                File destFile = new File ("D:\\poze\\screenshott.png");

                try {
                    FileUtils.copyFile (file,destFile);
                } catch (IOException ex) {
                    throw new RuntimeException (ex);
                }

            }
        }finally {
            if (driver != null){
                driver.quit ();
            }
        }
        System.out.println ("Finish");
    }
}






