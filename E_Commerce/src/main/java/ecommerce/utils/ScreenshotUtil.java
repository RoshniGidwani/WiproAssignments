package ecommerce.utils;

import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String testName) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            String path = System.getProperty("user.dir") 
                    + "/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";

            File dest = new File(path);

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved at: " + path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}