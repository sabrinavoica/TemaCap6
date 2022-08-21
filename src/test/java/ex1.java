import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class ex1 {

    public static void main(String[] args) throws IOException {
        thirdButton ();

    }

    public static void thirdButton() throws IOException {





        ChromeDriver driver = null;
        try {driver = WebDriver.getChromeDriver ();
            driver.get ("https://testpages.herokuapp.com/styled/alerts/alert-test.html");


            WebElement thirdButton = driver.findElement (By.id ("promptexample"));
            thirdButton.click ();


            Alert alert = driver.switchTo ().alert ();
            alert.sendKeys ("Sabrina");
            alert.accept ();
            thirdButton.click ();
            alert.sendKeys ("Text2");
            alert.dismiss ();

            throw new NoSuchFieldException ("Exceptie custom");


        } catch (Exception e) {

            System.out.println ("Am intrat i  ramura de catch");
            if (driver != null){
                File file = driver.getScreenshotAs (OutputType.FILE);
                File destFile = new File ("D:\\poze\\poza.png");

                FileUtils.copyFile (file,destFile);


                }
            }finally {
            if (driver != null){
                driver.quit ();
            }

        }
        System.out.println ("Finish");
    }
}
