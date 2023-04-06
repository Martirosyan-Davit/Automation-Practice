package com.academy.pageobjects;

public class SignUpPage extends PageBase<SignUpPage>{
    public static String PAGE_PATH ;
    @Override
    public SignUpPage open() {
        return openPage();
    }

    @Override
    public SignUpPage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return PAGE_PATH;
    }
    public String getSignUpPageURL(){
        return getActualUrl();
    }
}
