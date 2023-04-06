package com.academy.tests;

import com.academy.base.TestBase;
import com.academy.pageobjects.PracticePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.*;

public class PracticePageTest extends TestBase {

    @Test(description = "Verify the functionality of selecting Radiobutton1")
    public void verifyRadioBtn1SelectFunctionality() {
        PracticePage practicePage = new PracticePage()
                .open();

        boolean radioButtonInitialState = practicePage
                .isRadioBtnSelected(0);
        assertFalse(radioButtonInitialState, "RadioBtn1 should be deselected, but is selected");

        practicePage
                .clickOnRadioBtnByPosition(0);

        boolean radioButtonActualState = practicePage
                .isRadioBtnSelected(0);
        assertTrue(radioButtonActualState, "RadioButton1 should be selected but is not selected");
    }


    @Test(description = "Verify the functionality of selecting Radiobutton2")
    public void verifyRadioBtn2SelectFunctionality() {
        PracticePage practicePage = new PracticePage()
                .open();

        boolean radioButtonInitialState = practicePage
                .isRadioBtnSelected(1);
        assertFalse(radioButtonInitialState, "RadioBtn2 should be deselected, but is selected");

        practicePage
                .clickOnRadioBtnByPosition(1);

        boolean radioButtonActualState = practicePage
                .isRadioBtnSelected(1);
        assertTrue(radioButtonActualState, "RadioButton2 should be selected but is not selected");
    }

    @Test(description = "Verify the functionality of selecting Radiobutton3")
    public void verifyRadioBtn3SelectFunctionality() {
        PracticePage practicePage = new PracticePage()
                .open();

        boolean radioButtonInitialState = practicePage
                .isRadioBtnSelected(2);
        assertFalse(radioButtonInitialState, "RadioBtn3 should be deselected, but is selected");

        practicePage
                .clickOnRadioBtnByPosition(2);

        boolean radioButtonActualState = practicePage
                .isRadioBtnSelected(2);
        assertTrue(radioButtonActualState, "RadioButton3 should be selected but is not selected");
    }

    @Test(description = "Verify the functionality of 'Open window' button click")
    public void verifyOpenWindowBtnFunctionality() {

        String actualUrl = new PracticePage()
                .open()
                .clickOnOpenWindowBtn()
                .switchToQaClickAcademyWindow()
                .getRedirectedUrl();

        assertEquals(actualUrl, "http://www.qaclickacademy.com/", "Redirected Url is incorrect");
    }

    @Test(description = "Verify the navigation to Courses page for  'Switch Window' Example")
    public void clickOnCoursesOnTop() {

        String actualUrl = new PracticePage()
                .open()
                .clickOnOpenWindowBtn()
                .switchToQaClickAcademyWindow()
                .clickOnCoursesButton()
                .getRedirectedUrl();

        assertEquals(actualUrl, "https://www.rahulshettyacademy.com/", "Redirected Url is incorrect");
    }

    @Test(description = "Check the data safety in the \"Element Displayed Example\" text field after hide/show actions")
    public void checkingElementDisplayedExampleTheDataSafety() {
        String finalText = new PracticePage()
                .open()
                .typeInTextAreaInElementDisplayExample("test")
                .clickOnHideBtn()
                .clickOnShowBtn()
                .getTextFromTextAreaInElementDisplayExample();

        assertEquals(finalText, "test", "Text is differ from origin");
    }

    @Test(description = "Check \"Element Displayed Example\" text field visibility")
    public void checkingElementDisplayedExampleFieldVisibility() {
        boolean textVisibility = new PracticePage()
                .open()
                .typeInTextAreaInElementDisplayExample("test")
                .clickOnHideBtn()
                .checkingTextAreaInElementDisplayExampleVisibility();

        assertFalse(textVisibility, "Text area is visible");
    }

    @Test(description = "Verify LogIn btn functionality")
    public void logInBtnFunctionalityChecking() {
        String actualUrl = new PracticePage()
                .open()
                .clickOnLogInBtn()
                .getLogInPageURL();

        assertEquals(actualUrl, "https://sso.teachable.com/secure/9521/identity/login/password",
                "Redirection doesn't work");
    }

    @Test(description = "Verify SignUp btn functionality")
    public void signUpBtnFunctionalityChecking() {
        String actualUrl = new PracticePage()
                .open()
                .clickOnSignUpBtn()
                .getSignUpPageURL();

        assertEquals(actualUrl, "https://sso.teachable.com/secure/9521/identity/sign_up",
                "Redirection doesn't work");
    }

    @Test(description = "Verify Home btn functionality")
    public void homeBtnFunctionalityChecking() {
        String actualUrl = new PracticePage()
                .open()
                .clickOnHomeBtn()
                .getHomePageURL();

        assertEquals(actualUrl, "https://www.rahulshettyacademy.com/",
                "Redirection doesn't work");
    }

    @Test(description = "Verify Practice btn functionality")
    public void practiceBtnFunctionalityChecking() {
        String actualUrl = new PracticePage()
                .open()
                .clickOnHomeBtn()
                .init()
                .clickOnPracticeText()
                .getPracticeProjectPageURL();

        assertEquals(actualUrl, "https://www.rahulshettyacademy.com/practice-project",
                "Redirection doesn't work");
    }

    @Test(description = "Verify the 'Switch To Alert Example' functionality for Alert button")
    public void verifySwitchToAlertFunctionalityForAlertButton() {
        String input = "lena";
        String actualAlertMessage = new PracticePage()
                .open()
                .typeInNameField(input)
                .clickAlertButton()
                .getAlertMessage();
        assertEquals(actualAlertMessage,
                "Hello " + input + ", share this practice page and share your knowledge",
                "Incorrect alert text");
    }

    @Test(description = "Verify the 'Switch To Alert Example' functionality for Confirm button")
    public void verifySwitchToAlertFunctionalityForConfirmButton() {
        String actualAlertMessage = new PracticePage()
                .open()
                .typeInNameField("test")
                .clickConfirmButton()
                .getAlertMessage();
        assertEquals(actualAlertMessage, "Hello test, Are you sure you want to confirm?",
                "Incorrect alert text");
    }

    @Test(description = "Verify that alert is closed after clicking OK button")
    public void verifyAlertOkButtonFunctionality() {
        boolean isAlertDisplayed = new PracticePage()
                .open()
                .clickAlertButton()
                .acceptAlert()
                .isAlertDisplayed();
        assertFalse(isAlertDisplayed, "Alert is not displayed");
    }

    @Test(description = "Check that alert is closed after clicking Cancel button")
    public void verifyAlertCancelButtonFunctionality() {
        boolean isAlertDisplayed = new PracticePage()
                .open()
                .clickAlertButton()
                .dismissAlert()
                .isAlertDisplayed();
        assertFalse(isAlertDisplayed, "Alert is not displayed");
    }

    @Test(description = "Verify 'Checkbox Example' functionality")
    public void verifyCheckboxFunctionality() {
        SoftAssert softAssert = new SoftAssert();
        PracticePage practicePage = new PracticePage()
                .open()
                .selectCheckboxOption1()
                .selectCheckboxOption2()
                .selectCheckboxOption3()
                .init();
        softAssert.assertTrue(practicePage.isSelectedCheckboxOption1(), "Option1 is not selected");
        softAssert.assertTrue(practicePage.isSelectedCheckboxOption2(), "Option2 is not selected");
        softAssert.assertTrue(practicePage.isSelectedCheckboxOption3(), "Option3 is not selected");
        softAssert.assertAll();
    }

    @Test(description = "Check \"VIEW ALL COURSES\" button functionality")
    public void checkTotalAmountCollected() {
        PracticePage practicePage = new PracticePage();
        int actualSum = practicePage
                .open()
                .fixedHeaderTableSum();
        int expectedSum = practicePage
                .getTotalAmount();
        assertEquals(actualSum,expectedSum,"Total amount values are not equal");
    }
}