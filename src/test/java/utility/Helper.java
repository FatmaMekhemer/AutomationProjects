package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    public static void captureScreenshot(WebDriver driver,String screenshot){
        Path destination= Paths.get("./Screenshots",screenshot+".png");
        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream out=new FileOutputStream(destination.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception while taking screenshot"+e.getMessage());
        }
    }
}
