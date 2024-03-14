package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
        /* Bizler almis oldugumuz locateleri testlerimizin icerisinde kullanmak istedigimiz POM a gore bu sayfaya kaydedilen locateleri
        kullaniriz. Bu locateler test esnasinda olusturulan obje uzerinden cagirildiginda eger WebDriver ozelligini kullanamazsa
        o locatler islemlerini yerine getiremezler. Bunun icin bu sayfadaki tanimlanan driverimizin WebDriver castingi yapilarak alinan locateleri
        bu WebDriverin api larini kullanan appium artik islemleri yapabilir hale gelir!!!!!
         */
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement guessButton;

    @FindBy(xpath = "(//*[@class='android.widget.Button'])[2]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement kalkisTextKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[11]")
    public WebElement biletFiyat;





}
