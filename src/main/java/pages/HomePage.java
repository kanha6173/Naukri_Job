package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class HomePage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUtils = new WaitUtils(driver);
    }

    // Search jobs button
    @FindBy(xpath = "//button[@aria-label='Search jobs here']")
    private WebElement searchJobsButton;

    // Skill / designation input
    @FindBy(xpath = "//input[contains(@placeholder, 'designation')]")
    private WebElement skillInput;

    // Experience dropdown
    @FindBy(id = "experienceDD")
    private WebElement experienceDropdown;

    // Search button
    @FindBy(xpath = "//button[@class='nI-gNb-sb__icon-wrapper']")
    private WebElement searchButton;

    private final By experience3YearsOption =
            By.xpath("//ul[contains(@class, 'dropdown')]//li[@title='4 years']");

    public void searchJob(String keyword) {

        // Click "Search jobs here"
        waitUtils.waitForElementToBeClickable(searchJobsButton);
        searchJobsButton.click();

        // Enter job keyword
        waitUtils.waitForElementToBeVisible(skillInput);
        skillInput.sendKeys(keyword);

        // Select experience
        waitUtils.waitForElementToBeClickable(experienceDropdown);
        experienceDropdown.click();

        WebElement experienceOption =
                waitUtils.waitForElementToBeClickable(experience3YearsOption);

        experienceOption.click();

        // Click search
        waitUtils.waitForElementToBeClickable(searchButton);
        searchButton.click();
    }
}