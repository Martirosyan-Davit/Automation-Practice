package com.academy.pageobjects;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

import static com.academy.configuration.DriverBase.getDriver;
import static com.academy.helper.WaitHelper.getWait;

public abstract class PageBase<T extends PageBase<T>> {

    public String MAIN_URL = "https://rahulshettyacademy.com/";


    public abstract T open();

    public abstract T init();

    public abstract String getUrlPath();

    protected T initPage() {
        PageFactory.initElements(getDriver(), this);
        return (T) this;
    }

    protected T openPage() {
        load();
        initPage();
        return (T) this;
    }

    protected void load() {
        if (getUrlPath() == null) {
            getDriver().get(MAIN_URL);
        } else {
            getDriver().get(MAIN_URL + getUrlPath());
        }
    }

    protected void switchToNewWindow() {
        String originalWindow = getDriver().getWindowHandle();
        Set<String> windows = getDriver().getWindowHandles();
        for (String windowHandle : windows) {
            if (!originalWindow.equals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
            }
        }
    }

    protected int getOpenedWindowsCount() {
        return getDriver().getWindowHandles().size();
    }

    protected String getActualUrl() {
        return getDriver().getCurrentUrl();
    }

    protected void clickOn(WebElement element) {
        getWait().waitUntilElementToBeClickable(element);
        element.click();
    }

    protected void clickOn(List<WebElement> elements, int index) {
        clickOn(elements.get(index));
    }

    protected String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }

    public T acceptAlert() {
        getDriver().switchTo().alert().accept();
        return (T) this;
    }

    public T dismissAlert() {
        getDriver().switchTo().alert().dismiss();
        return (T) this;
    }


    protected String readText(WebElement element) {
        return element.getText();
    }

    protected boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    protected boolean isElementSelected(List<WebElement> elements, int position) {
        return isElementSelected(elements.get(position));
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected String getText(List<WebElement> elements, int position) {
        return getText(elements.get(position));
    }

    protected void typeIn(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void typeIn(List<WebElement> elements, int position, String text) {
        if (position < 0 || position >= elements.size()) {
            throw new IndexOutOfBoundsException("Position is out of range");
        }
        typeIn(elements.get(position), text);
    }

    protected boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isAlertPresent() {
        try {
            getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    protected String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    protected void hover(WebElement element) {
        getWait().waitUntilElementToBeVisible(element);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }
}