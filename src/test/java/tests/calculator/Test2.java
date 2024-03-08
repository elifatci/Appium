package tests.calculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test2 {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Elif\\IdeaProjects\\Appium\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }



    @Test
    public void test01(){
        //uygulamanin yuklendigini dogrular
        assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        //uygulamanin acildigini dogrular
        assertTrue(driver.findElementByAccessibilityId("clear").isDisplayed());
        //6! 720 oldugunu dogrular
        driver.findElementByAccessibilityId("6").click();
        driver.findElementByAccessibilityId("factorial").click();

        String actualResult=driver.findElementById("com.google.android.calculator:id/result_preview").getText();

        assertEquals(Integer.parseInt(actualResult),720);

    }

    @Test
    public void test02(){
        //uygulamanin yuklendigini dogrular
        assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        //uygulamanin acildigini dogrular
        assertTrue(driver.findElementByAccessibilityId("square root").isDisplayed());
        //log10000 4 oldugunu dogrular
        driver.findElementByAccessibilityId("Expand").click();
        driver.findElementByAccessibilityId("logarithm").click();
        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();

        String actualResult=driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        int act=Integer.parseInt(actualResult);
        int exp=4;

        assertEquals(act,exp);
    }


}
