package tests.arabamApp;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ArabamApp {

    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.dogan.arabam");
        // Hangi uygulama uzerinde calismak istiyorsak o uygulamaya ait appPackage degeri yani uygulamanin kimlik bilgisi
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // AppPackage da belirlenen uygulamanin hangi sayfasindan baslanacak oldugunu belirlemek icin girilen activity degeri
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest() throws InterruptedException {

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
         assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // uygulaminin basarili bir sekilde acildigi dogrulanir
        assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());
        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();
        // kategori olarak otomobil secilir
        Thread.sleep(2000);
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(815,508)).release().perform();
        Thread.sleep(1000);
        // arac olarak Volkswagen secilir

        for (int i = 0; i < 4; i++) {
            action.press(PointOption.point(548,1607))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(548,348))
                    .release().perform();
            Thread.sleep(1000);
        }

        driver.findElementByXPath("//*[@text='Volkswagen']").click();
        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();
        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();
        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Highline']").click();
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementById("com.dogan.arabam:id/imageViewSorting").click();
        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        String actStr=driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]").getText();

        int act=Integer.parseInt(actStr.replaceAll("\\D",""));

        assertTrue(act>500.000);
    }


}
