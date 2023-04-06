package com.academy.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.academy.configuration.DriverBase.getDriver;

public class HomePage extends PageBase<HomePage>{

    public static String URL_PATH;

    @Override
    public HomePage open() {
        return openPage();
    }

    @Override
    public HomePage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return URL_PATH;
    }
    @FindBy(css = "body > div > header > div.header-upper > div > div > div.nav-outer.clearfix > nav > " +
            "div.navbar-collapse.collapse.clearfix > ul > li:nth-child(7) > a")
    protected WebElement practiceText;
    public String getHomePageURL(){
        return getActualUrl();
    }
    public PracticeProjectPage clickOnPracticeText(){
        clickOn(practiceText);
        return new PracticeProjectPage();
    }
}
