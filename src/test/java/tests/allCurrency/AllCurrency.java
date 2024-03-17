package tests.allCurrency;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AllCurrency {

    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();

    AllCurrencyPage allCurrencyPage=new AllCurrencyPage();
    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {
        // all currency uygulamasinin yuklendigi dogulanir
       assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
        // uygulamanin acildigi dogrulanir
        assertTrue(allCurrencyPage.currencyText.isDisplayed());
        // cevirmek istedigimiz para birimi zloty olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(500,343,750);
        ReusableMethods.scrollWithUiScrollable("PLN");
        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(504,493,750);
        ReusableMethods.scrollWithUiScrollable("TRY");
        // cevrilen tutar screenShot olarak kaydedilir
        ReusableMethods.scrollWithUiScrollable("1");
        ReusableMethods.scrollWithUiScrollable("3");
        ReusableMethods.scrollWithUiScrollable("5");

       //File file=driver.getScreenshotAs(OutputType.FILE);
       //FileUtils.copyFile(file,new File("ZlotyToTl.jpg"));
        ReusableMethods.getScreenshot("new");

        // kullaniciya sms olarak bildirilir
        WebElement result=driver.findElementById("com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB");
        String resultText=result.getText();

        driver.sendSMS("5555555555","Cevirmek istediginiz para biriminin sonucu :"+resultText);

    }
}

