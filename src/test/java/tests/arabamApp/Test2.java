package tests.arabamApp;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test2 {


    AndroidDriver<AndroidElement> driver;

    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
       Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/notificationListing").isDisplayed());
        // alt menuden garaj butonuna tiklanir
        driver.findElementByXPath("(//*[@text='Garaj'])[2]").click();
        //atla yazısına tıklanır
        driver.findElementById("com.dogan.arabam:id/textViewSkip").click();
        //ekrandaki 5. resmi görene kadar ilerlenir

        Thread.sleep(3000);
        TouchAction action=new TouchAction<>(driver);

        for (int i = 0; i < 5; i++) {
            action.press(PointOption.point(1312,653))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(131,653)).release().perform();
        }
        //5. resmin görünür oldugu dogrulanır
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivSlider").isDisplayed());

        //Yakıt bolumunun altındaki resme tıklanır
        driver.findElementByXPath("(//android.widget.ImageView[@resource-id=\"com.dogan.arabam:id/imageView\"])[5]").click();

        //Dizel fiyatının 40,62 TL oldugu dogrulanır

        for (int i = 0; i < 3; i++) {
            action.press(PointOption.point(1116,1140))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(142,1140)).release().perform();
        }
        String actualPrice=driver.findElementById("com.dogan.arabam:id/textViewPriceWithoutCurrency").getText();

        double actPr= Double.parseDouble(actualPrice.replaceAll("TL","").replaceAll(",","."));

        Assert.assertEquals(actPr,"40.62");


    }
}
