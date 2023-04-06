package com.academy.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.academy.helper.WaitHelper.*;
import static java.lang.Integer.parseInt;


public class PracticePage extends PageBase<PracticePage> {
    public static String PAGE_PATH = "AutomationPractice/";


    @Override
    public PracticePage open() {
        return openPage();
    }

    @Override
    public PracticePage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return PAGE_PATH;
    }


    @FindBy(css = ".radioButton")
    private List<WebElement> radioButtons;
    @FindBy(css = "#openwindow")
    private WebElement openWindowBtn;
    @FindBy(css = ".nav li:nth-child(2)")
    private WebElement coursesBtn;
    @FindBy(css = "#hide-textbox")
    private WebElement hideBtn;
    @FindBy(css = "#show-textbox")
    private WebElement showBtn;
    @FindBy(css = "#displayed-text")
    private WebElement textAreaInElementDisplayExample;
    @FindBy(css = " button:nth-child(3)")
    private WebElement logInBtn;
    @FindBy(css = "button:nth-child(4)")
    private WebElement signUpBtn;
    @FindBy(css = "button:nth-child(1)")
    private WebElement homeBtn;
    @FindBy(css = "#dropdown-class-example")
    private WebElement dropdownExampleField;
    @FindBy(css = "#dropdown-class-example > option")
    private List<WebElement> options;
    @FindBy(css = "#mousehover")
    private WebElement mouseHoverBtn;
    @FindBy(css = " fieldset > div > div > a:nth-child(2)")
    private WebElement reloadText;
    @FindBy(css = "div.nav-outer.clearfix > nav > div.navbar-collapse.collapse.clearfix > ul > li:nth-child(2) > a")
    private WebElement coursesBtnInIframe;
    @FindBy(css = "#courses-iframe")
    private WebElement iframe;

    @FindBy(css = "#name")
    private WebElement inputNameField;

    @FindBy(css = "#alertbtn")
    private WebElement alertBtn;

    @FindBy(css = "#confirmbtn")
    private WebElement confirmBtn;

    @FindBy(css = "#checkBoxOption1")
    private WebElement checkboxOption1;

    @FindBy(css = "#checkBoxOption2")
    private WebElement checkboxOption2;

    @FindBy(css = "#checkBoxOption3")
    private WebElement checkBoxOption3;

    @FindBy(css = "tbody:nth-child(2) tr td:nth-child(4)")
    private List<WebElement> fixedHeaderTable;
    @FindBy(css = ".totalAmount")
    private WebElement totalAmount;

    public PracticePage clickOnCoursesButton() {
        clickOn(coursesBtn);
        return this;
    }

    public void clickOnRadioBtnByPosition(int position) {
        clickOn(radioButtons, position);
    }

    public boolean isRadioBtnSelected(int position) {
        return isElementSelected(radioButtons, position);
    }

    public PracticePage clickOnOpenWindowBtn() {
        clickOn(openWindowBtn);
        return this;
    }


    public PracticePage switchToQaClickAcademyWindow() {
        switchToNewWindow();
        return this;
    }

    public String getRedirectedUrl() {
        return getActualUrl();
    }

    public PracticePage clickOnHideBtn() {
        clickOn(hideBtn);
        return this;
    }

    public PracticePage clickOnShowBtn() {
        clickOn(showBtn);
        return this;
    }

    public PracticePage typeInTextAreaInElementDisplayExample(String text) {
        typeIn(textAreaInElementDisplayExample, text);
        return this;
    }

    public String getTextFromTextAreaInElementDisplayExample() {
        return getText(textAreaInElementDisplayExample);
    }

    public boolean checkingTextAreaInElementDisplayExampleVisibility() {
        return isElementDisplayed(textAreaInElementDisplayExample);
    }

    public LogInPage clickOnLogInBtn() {
        clickOn(logInBtn);
        return new LogInPage().init();
    }

    public SignUpPage clickOnSignUpBtn() {
        clickOn(signUpBtn);
        return new SignUpPage().init();
    }

    public HomePage clickOnHomeBtn() {
        clickOn(homeBtn);
        return new HomePage();
    }

    public PracticePage clickOnDropdownField() {
        clickOn(dropdownExampleField);
        return this;
    }

    public PracticePage selectOptionFromOptionsList(int index) {
        clickOn(options, index);
        return this;
    }

    public String getTextFromDropdownField() {
        getWait().waitUntilElementToBeVisible(dropdownExampleField);
        return getAttribute(dropdownExampleField, "value");
    }

    public PracticePage hoverMouseHoverBtn() {
        hover(mouseHoverBtn);
        return this;
    }

    public boolean isReloadVisible() {
        return isElementDisplayed(reloadText);
    }

    public PracticePage clickOnCoursesBtn() {
        clickOn(coursesBtnInIframe);
        return this;
    }

    public PracticePage moveToIframe() {
        hover(iframe);
        return this;
    }

    public boolean isCoursesVisible() {
        return isElementDisplayed(coursesBtnInIframe);
    }

    public PracticePage typeInNameField(String text){
        typeIn(inputNameField, text);
        return this;
    }

    public PracticePage clickAlertButton(){
        clickOn(alertBtn);
        return this;
    }

    public PracticePage clickConfirmButton(){
        clickOn(confirmBtn);
        return this;
    }

    public PracticePage selectCheckboxOption1(){
        clickOn(checkboxOption1);
        return this;
    }

    public PracticePage selectCheckboxOption2(){
        clickOn(checkboxOption2);
        return this;
    }

    public PracticePage selectCheckboxOption3(){
        clickOn(checkBoxOption3);
        return this;
    }

    public boolean isSelectedCheckboxOption1(){
        return isElementSelected(checkboxOption1);
    }

    public boolean isSelectedCheckboxOption2(){
        return isElementSelected(checkboxOption2);
    }

    public boolean isSelectedCheckboxOption3(){
        return isElementSelected(checkBoxOption3);
    }

    public String getAlertMessage(){
        return getAlertText();
    }

    public boolean isAlertDisplayed(){
        return isAlertPresent();
    }

    public int fixedHeaderTableSum() {
        int sum = 0;
        for (WebElement i : fixedHeaderTable) {
            sum += parseInt(getText(i));
        }
        return sum;
    }

    public int getTotalAmount() {
        String str = getText(totalAmount);
        str = str.replaceAll("[^0-9]", "");
        int sum = parseInt(str);
        return sum;
    }


}
