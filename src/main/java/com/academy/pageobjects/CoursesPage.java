package com.academy.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.configuration.DriverBase.getDriver;

public class CoursesPage extends PageBase<CoursesPage> {
    private String PATH_COURSES = "courses/";

    @Override
    public CoursesPage open() {
        return openPage();
    }

    @Override
    public CoursesPage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return PATH_COURSES;
    }

    @FindBy(css = ".fedora-navbar-link.navbar-link")
    private List<WebElement> headerButtons;

    public CoursesPage clickOnCoursesButton(int indexCourses){
        clickOn(headerButtons,indexCourses);
        return this;
    }
}
