package examples;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test_3
{
        AppiumDriver<AndroidElement> driver;
        File file = new File("src\\test\\java\\apps");
        File fs = new File(file, "calculator.apk");
        @BeforeTest

        public void setUp()
        {
            System.out.println("Step_1 is passed !!!");
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("platform", "Android");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
            cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
            try
            {
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println("Step_2 is passed !!!");
        }

        @Test
        public void validateText()
        {
            driver.findElementById("com.mi_ciel.calclc:id/button_7").click();
            driver.findElementById("com.mi_ciel.calclc:id/button_times").click();
            driver.findElementById("com.mi_ciel.calclc:id/button_7").click();
            driver.findElementById("com.mi_ciel.calclc:id/button_equal").click();

            String text = driver.findElementById("com.mi_ciel.calclc:id/display_math").getText();
            if(text.equals("49"))
            {
                System.out.println("Passed !!!");
            }
            else
            {
                System.out.println("Failed !!!");
            }
        }

        @AfterClass
        public void tearDown()
        {
            driver.quit();
            System.out.println("Step_3 is passed !!!");
        }
    }


