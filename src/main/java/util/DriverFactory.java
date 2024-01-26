package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static AppiumDriver driver;
    static Properties properties;
    static DesiredCapabilities capabilities;

    public static AppiumDriver initialize_Driver(String browser) {
        properties = ConfigReader.getProperties();

        capabilities = new DesiredCapabilities();
        if (browser.equals("Android")) {
// real device
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "192.168.1.12:5555");
            capabilities.setCapability("appPackage", "com.pointrlabs.demo.qa3gateway.prod");
            capabilities.setCapability("appActivity", "com.pointrlabs.sample.splash.PointrLoadingActivity");

            // emulator
//            capabilities.setCapability("platformName", "Android");
//            capabilities.setCapability("udid", "emulator-5554");
//            capabilities.setCapability("appPackage", "com.pointrlabs.demo.qa3gateway.prod");
//            capabilities.setCapability("appActivity", "com.pointrlabs.sample.splash.PointrLoadingActivity");

//            capabilities.setCapability("platformName", "Android");
//            capabilities.setCapability("udid", "emulator-5554");
//            capabilities.setCapability("appPackage", "com.dmall.mfandroid");
//            capabilities.setCapability("appActivity", "com.dmall.mfandroid.activity.base.NewSplash");
        } else if (browser.equals("iOS")) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("udid", "");
            capabilities.setCapability("appPackage", "");
            capabilities.setCapability("appActivity", "");
        }
        try {
            driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        return getDriver();
    }

    public static AppiumDriver getDriver() {
        return driver;
    }


}