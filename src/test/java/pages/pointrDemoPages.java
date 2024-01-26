package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.*;

public class pointrDemoPages {
    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public pointrDemoPages(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        this.elementHelper = new ElementHelper(driver);
    }

    String NextButton = "//android.widget.TextView[@text='Next']";
    String NextStepButton = "//android.widget.TextView[@text='Next Step']";
    String WhileUsingTheApp = "//android.widget.Button[@text='While using the app']";
    String PermissionsOptionVirtual = "//android.widget.TextView[@resource-id='android:id/title' and @text='Permissions']";
    String PermissionsOptionReal = "//android.widget.TextView[@text='Permissions']";
    String LocationOption = "//android.widget.TextView[@resource-id='android:id/title' and @text='Location']";
    String AllowAllTheTime = "//android.widget.RadioButton[@resource-id='com.android.permissioncontroller:id/allow_always_radio_button' and @text='Allow all the time']";
    String BackButtonVirtual = "//android.widget.ImageButton[@content-desc= 'Back']";
    String BackButtonReal = "//android.widget.ImageButton[@content-desc= 'Navigate up']";
    String BackButtonAppInfoPageVirtual = "//android.widget.ImageButton[@content-desc= 'Navigate up']";
    String BackButtonAppInfoPageReal = "//android.view.View[1]/android.widget.Button";
    String ModalAllowOption = "//android.widget.Button[@text= 'Allow']";
    String StartTheDemoOption = "//android.widget.TextView[@text= 'Start the Demo']";
    String OfficeBuilding01 = "//android.widget.TextView[@text= 'Office Building 01']";
    String TerminalE = "//android.widget.TextView[@text= 'Terminal E']";
    String RoundedStartButton = "//android.widget.ImageView[@content-desc= 'Start' and contains(@resource-id, 'start_maps_btn')]";
    String MapWidget = "//android.widget.FrameLayout[contains(@resource-id, 'pointrMapView')]";
    String TrackButton = "//android.widget.ImageButton[contains(@resource-id, 'mapTrackingModeChangeFAB')]";
    String LevelSelector = "//android.widget.FrameLayout[contains(@resource-id, 'levelSelectorLevelView')]//android.widget.TextView";
    String QuickAccess = "//androidx.recyclerview.widget.RecyclerView[contains(@resource-id, 'categories_grid')]";
    String SecondCategoryQuickAccess = "//android.widget.LinearLayout[2]/android.widget.LinearLayout";
    String CarouselBackButton = "//android.widget.ImageView[@content-desc='Back']";
    String SearchInput = "//android.widget.EditText[@text='Search here…' and contains(@resource-id, 'searchView')]";
    String SearchResultsPane = "//android.widget.ExpandableListView[contains(@resource-id, 'searchRecyclerView')]";
    String FirstSearchResult = "//android.widget.ExpandableListView/android.widget.FrameLayout[1]/android.widget.FrameLayout";
    String CollapseSearchIcon = "//android.widget.ImageView[@content-desc='Collapse search view' and contains(@resource-id,'collapseSearchViewImg')]";
    String ClearSearchInputIcon = "//android.widget.ImageView[@content-desc='Clear search term' and contains(@resource-id,'searchViewRightImg')]";
    String DirectionsButton = "//android.widget.TextView[contains(@resource-id, 'poiDetailButtonText') and @text='Directions']";
    String TakeMeThereButton = "//android.widget.TextView[@text='Take me there']";
    String ActiveCarouselCardDetailsButton = "(//android.view.ViewGroup[@content-desc='Poi details']//android.widget.TextView[@text='Details'])[1]";
    String CancelButton = "//android.view.ViewGroup[@content-desc=\"Wayfinding\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.FrameLayout";
    String HudsonsCoffee = "//android.widget.TextView[contains(@resource-id, 'poiNameTextView') and @text='Hudsons Coffee']";
    String PoiDismissButton = "//android.widget.ImageView[contains(@resource-id, 'poiDetailCloseButton') and @content-desc='Poi Close button']";
    String ExitButton = "//android.widget.TextView[contains(@resource-id, 'exitButton') and @content-desc='Exit']";
    String YesButtonExitModal = "//android.widget.Button[contains(@resource-id, 'button1') and @text='Yes']";

    LocalDateTime start;
    LocalDateTime end;

    private static boolean calculateMinutesDifference(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        return ChronoUnit.SECONDS.between(dateTime1, dateTime2) > 1800;
    }

    public void setupRouteViaSearchAndQuickAccess() {
        for (int i = 1; i <= 50; i++) {
            System.out.println("Iteration Count: " + i);
            setupRouteViaSearch();
            setupRouteViaCategory();
        }
        String end = "Test ended at " + ReturnDate();
        writeStringToFile(end);
        captureFullScreenshot(driver, "end.jpg");
    }

    public void setupRouteViaSearch() {
        driver.findElement(By.xpath(SearchInput)).click();
        driver.findElement(By.xpath(SearchInput)).sendKeys("coffee");
        driver.findElement(By.xpath(HudsonsCoffee)).click();
        driver.findElement(By.xpath(DirectionsButton)).click();
        driver.findElement(By.xpath(TakeMeThereButton)).click();
        driver.findElement(By.xpath(CancelButton)).click();
        driver.findElement(By.xpath(PoiDismissButton)).click();
        driver.findElement(By.xpath(CollapseSearchIcon)).click();
        driver.findElement(By.xpath(ExitButton)).click();
        driver.findElement(By.xpath(YesButtonExitModal)).click();
        Assert.assertTrue(driver.findElement(By.xpath(TerminalE)).isDisplayed());
        driver.findElement(By.xpath(TerminalE)).click();
        driver.findElementByXPath(RoundedStartButton).click();
        MapWidgetShouldBeDisplayed();
    }

    public void setupRouteViaCategory() {
        driver.findElement(By.xpath(SecondCategoryQuickAccess)).click();
        driver.findElement(By.xpath(ActiveCarouselCardDetailsButton)).click();
        driver.findElement(By.xpath(DirectionsButton)).click();
        driver.findElement(By.xpath(TakeMeThereButton)).click();
        driver.findElement(By.xpath(CancelButton)).click();
        driver.findElement(By.xpath(PoiDismissButton)).click();
        driver.findElement(By.xpath(CarouselBackButton)).click();
        driver.findElement(By.xpath(ExitButton)).click();
        driver.findElement(By.xpath(YesButtonExitModal)).click();
        Assert.assertTrue(driver.findElement(By.xpath(TerminalE)).isDisplayed());
        driver.findElement(By.xpath(TerminalE)).click();
        driver.findElementByXPath(RoundedStartButton).click();
        MapWidgetShouldBeDisplayed();
    }

    public void FinishGetStartedTutorial() {
        captureFullScreenshot(driver,  "start.jpg");
        String start = "Test started at " + ReturnDate();
        writeStringToFile(start);
        driver.findElement(By.xpath(NextStepButton)).click();
        driver.findElementByXPath(NextButton).click();
        driver.findElementByXPath(NextButton).click();
        driver.findElementByXPath(WhileUsingTheApp).click();
        driver.findElementByXPath(NextButton).click();
        driver.findElementByXPath(PermissionsOptionReal).click();
        driver.findElementByXPath(LocationOption).click();
        driver.findElementByXPath(AllowAllTheTime).click();
        driver.findElementByXPath(BackButtonReal).click();
        driver.findElementByXPath(BackButtonReal).click();
        driver.findElementByXPath(BackButtonAppInfoPageReal).click();
        driver.findElementByXPath(NextButton).click();
        driver.findElementByXPath(NextButton).click();
        driver.findElementByXPath(ModalAllowOption).click();
        driver.findElementByXPath(NextButton).click();
        driver.findElementByXPath(NextButton).click();
//        only for real device
        driver.findElementByXPath(NextButton).click();
        driver.findElementByXPath(ModalAllowOption).click();
        driver.findElementByXPath(NextButton).click();
        driver.findElementByXPath(StartTheDemoOption).click();
    }

    public void SelectBuildingAndClickOnStart() {
//        driver.findElementByXPath(OfficeBuilding01).click();
        driver.findElementByXPath(TerminalE).click();
        driver.findElementByXPath(RoundedStartButton).click();
    }

    public void MapWidgetShouldBeDisplayed() {
        MobileElement mapWidget = (MobileElement) driver.findElement(MobileBy.xpath(MapWidget));
        MobileElement trackButton = (MobileElement) driver.findElement(MobileBy.xpath(TrackButton));
        MobileElement levelSelector = (MobileElement) driver.findElement(MobileBy.xpath(LevelSelector));
        Assert.assertTrue(mapWidget.isDisplayed());
        Assert.assertTrue(trackButton.isDisplayed());
        Assert.assertTrue(levelSelector.isDisplayed());
    }

    public void clickOnSearchInput() {
        driver.findElementByXPath(SearchInput).click();
    }

    public void assertAllButton() {
        MobileElement allButton = (MobileElement) driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='All']"));
        Assert.assertTrue(allButton.isDisplayed());
    }

    public void clickOnCollapseSearchIcon() {
        MobileElement collapseSearchIcon = (MobileElement) driver.findElement(MobileBy.xpath(CollapseSearchIcon));
        collapseSearchIcon.click();
    }

    public void assertAllBtnNotDisplayed() throws InterruptedException {
        boolean res = waitUntilElementDisappears("//android.widget.TextView[@text='All']");
        Assert.assertTrue(res);
    }

    public boolean verifyElementExists(String locator) {
        try {
            MobileElement element = (MobileElement) driver.findElement(MobileBy.xpath(locator));
            System.out.println("Element Present");
            return true;

        } catch (Exception e) {
            System.out.println("Element absent");
            return false;
        }
    }

    public boolean waitUntilElementDisappears(String locator) throws InterruptedException {
        int counter = 0;
        boolean result = false;
        while (counter < 5) {
            System.out.println("counter: " + counter + " result: " + result);
            List<MobileElement> elements = driver.findElements(MobileBy.xpath(locator));
            if (elements.isEmpty()) {
                result = true;
                break;
            } else {
                Thread.sleep(1000);
                counter++;
            }
        }
        return result;
    }

    public static void writeStringToFile(String content) {
        String filePath = "log.txt";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(content + System.lineSeparator());
            System.out.println("Content successfully written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public String ReturnDate() {
        LocalDateTime startTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
        return startTime.format(formatter);
    }

    private static void captureFullScreenshot(AppiumDriver driver, String fileName) {
        // Check if driver implements TakesScreenshot interface
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

            // Specify the destination folder
            String destinationFolder = "screenshots";

            // Create the destination folder if it doesn't exist
            File folder = new File(destinationFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            String destinationPath = destinationFolder + File.separator + fileName;
            try {
                // Copy the screenshot file to the destination path
                org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File(destinationPath));
                System.out.println("Full screen screenshot saved to: " + destinationPath);
            } catch (IOException e) {
                System.err.println("Error saving screenshot: " + e.getMessage());
            }
        } else {
            System.err.println("Driver does not support screenshots");
        }
    }

}

