import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class ex3 {
    public static void main(String[] args) {
       firstButton ();
     //   secondButton ();
      //  thirdButton ();

    }

public static void firstButton(){
    ChromeDriver driver = null;
    try {
        driver = WebDriver.getChromeDriver ();
        driver.get ("https://demoqa.com/browser-windows");

        WebElement tabButton = driver.findElement (By.id ("tabButton"));
        tabButton.click ();

        String parentWindow = driver.getWindowHandle ();
        Set<String> windowHandles =  driver.getWindowHandles ();

        for (String windows: windowHandles){
            if (!windows.equals (parentWindow)){
                driver.switchTo ().window (windows);
                break;
            }
        }

        System.out.println (driver.findElement (By.id ("sampleHeading")).getText ());
        driver.close ();

        throw new NoSuchFieldException ("Exceptie custom");


    }catch (Exception e) {
        System.out.println ("Am intrat in ramura de catch");
        if (driver != null) {
            File file = driver.getScreenshotAs (OutputType.FILE);
            File destFile = new File ("D:\\poze\\primulButton.png");

            try {
                FileUtils.copyFile (file, destFile);
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

public static void secondButton(){
    ChromeDriver driver = null;
        try {
            driver = WebDriver.getChromeDriver ();
            driver.get ("https://demoqa.com/browser-windows");

            String parentWindow = driver.getWindowHandle ();
            Set<String> windowHandles2 =  driver.getWindowHandles ();


            driver.switchTo ().window (parentWindow);
            driver.findElement (By.id ("windowButton")).click ();

            for (String windows: windowHandles2){
                if (!windows.equals (parentWindow)){
                    driver.switchTo ().window (windows);
                    break;
                }
            }
            System.out.println (driver.findElement (By.id ("sampleHeading")).getText ());
            driver.close ();

        }catch (Exception e){
            System.out.println ("Am intrat in ramura de catch");
            if (driver != null){
                File file = driver.getScreenshotAs (OutputType.FILE);
                File destFile = new File ("D:\\poze\\secondButton.png");

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

        public static void thirdButton(){
            ChromeDriver driver = null;
            try {
                driver = WebDriver.getChromeDriver ();
                driver.get ("https://demoqa.com/browser-windows");

                String parentWindow = driver.getWindowHandle ();
                Set<String> windowHandles3 =  driver.getWindowHandles ();


                driver.switchTo ().window (parentWindow);
                driver.findElement (By.id ("messageWindowButton")).click ();

                for (String windows: windowHandles3){
                    if (!windows.equals (parentWindow)){
                        driver.switchTo ().window (windows);
                        break;
                    }
                }
                System.out.println (driver.findElement (By.id ("body")).getText ());
                driver.close ();

            }catch (Exception e){
                System.out.println ("Am intrat in ramura de catch");
                if (driver != null){
                    File file = driver.getScreenshotAs (OutputType.FILE);
                    File destFile = new File ("D:\\poze\\thirdButton.png");

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
