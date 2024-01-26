package stepDefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import pages.pointrDemoPages;
import util.DriverFactory;

public class pointrDemoStepDefinitions {
    pointrDemoPages pointrPages = new pointrDemoPages(DriverFactory.getDriver());

    @When("I finish Get Started tutorial")
    public void GetStartedTutorial(){
        pointrPages.FinishGetStartedTutorial();
    }

    @And("I select a building and click on Start Button")
    public void SelectBuildingAndClickOnStart(){
        pointrPages.SelectBuildingAndClickOnStart();
    }

    @Then("map widget should be displayed")
    public void MapWidgetShouldBeDisplayed(){
        pointrPages.MapWidgetShouldBeDisplayed();
    }

    @When("I click on Search")
    public void clickOnSearchInput(){
        pointrPages.clickOnSearchInput();
    }

    @Then("All button should be displayed")
    public void assertAllButton(){
        pointrPages.assertAllButton();
    }

    @When("I click on collapse search icon")
    public void clickOnCollapseSearchIcon(){
        pointrPages.clickOnCollapseSearchIcon();
    }

    @Then("All button should not be displayed")
    public void assertAllBtnNotDisplayed() throws InterruptedException {
        pointrPages.assertAllBtnNotDisplayed();
    }

    @Then("I set up a route via search and quick access")
    public void setupRouteViaSearch(){
        pointrPages.setupRouteViaSearchAndQuickAccess();
    }




}
