package calculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculator {

    AndroidDriver<AndroidElement> driver;//Android cihazlardaki islemleri yapabilmemizi saglayan driver objesi

    //IOSDriver<IOSElement> iosDriver;//Ios cihazlardaki islemleri yapabilmemizi saglayan driver objesi
    //AppiumDriver<MobileElement> appiumDriver;//her iki platformdada islemlerizi yapmamızı saglayan driver objesi

    @Test
    public void ilkHesapAppTesti() throws MalformedURLException {
        //kullanici gerekli kurulumu yapar
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\Elif\\IdeaProjects\\Appium\\Apps\\Calculator_8.4 (503542421)_Apkpure.apk");
        /*
        UiAutomator2==>sadece Android 6'dan yuksek olan android sistemleri icin calisir
        UiAutomator ==>Android 6 ve 6'dan dusuk olan android sistemleri icin calisir
         */

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //uygulamanin yuklendigini dogrular
        //uygulamanin acildigini dogrular
        //200'un 7 katinin 1400 oldugunu dogrular







    }
}
