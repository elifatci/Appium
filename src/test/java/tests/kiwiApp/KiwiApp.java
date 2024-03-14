package tests.kiwiApp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;
import utils.ReusableMethods;

import static org.testng.Assert.assertTrue;

public class KiwiApp {


    AndroidDriver<AndroidElement>driver=Driver.getAndroidDriver();

    KiwiPage kiwiPage=new KiwiPage();

    @Test
    public void kiwiAppTest() throws InterruptedException {

        // uygulamanin yuklendigi dogrulanir
        assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir
       assertTrue(kiwiPage.guessButton.isDisplayed());
        // misafir olarak devam et e tiklanir
        kiwiPage.guessButton.click();
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        for (int i = 0; i <4 ; i++) {
            ReusableMethods.koordinatTiklamaMethodu(541,1700,2000);
        }
        // Trip type,one way olarak secilir
        ReusableMethods.scrollWithUiScrollable("Return");
        ReusableMethods.scrollWithUiScrollable("One way");
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        ReusableMethods.scrollWithUiScrollable("From:");
        ReusableMethods.wait(2);
        ReusableMethods.koordinatTiklamaMethodu(1019,139,1000);
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        ReusableMethods.wait(1);
        ReusableMethods.scrollWithUiScrollable("ESB, Esenboğa International");
        ReusableMethods.scrollWithUiScrollable("Choose");
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        ReusableMethods.scrollWithUiScrollable("Anywhere");
        for (int i = 0; i < 2; i++) {
            ReusableMethods.scrollScreenMethod(457,833,750,457,197,1000);
        }

        ReusableMethods.scrollWithUiScrollable("Stuttgart, Baden-Württemberg");
        ReusableMethods.scrollWithUiScrollable("Choose");
        // gidis tarihi eylul ayinin 21 i olarak secilir ve set date e tiklanir
        ReusableMethods.scrollWithUiScrollable("Departure:");
        for (int i = 0; i < 7; i++) {
            ReusableMethods.scrollScreenMethod(475,1300,750,475,354,2000);
        }
        ReusableMethods.koordinatTiklamaMethodu(972, 749,1000);
        ReusableMethods.scrollWithUiScrollable("Set date");
        // search butonuna tiklanir
        kiwiPage.searchButton.click();
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        ReusableMethods.scrollWithUiScrollable("Best");
        ReusableMethods.scrollWithUiScrollable("Cheapest");
        ReusableMethods.wait(3);


        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

        String biletFiyat=kiwiPage.biletFiyat.getText();
        driver.sendSMS("1111111111","KiwiApp uygulamasındaki biletin fiyati");
    }
}
