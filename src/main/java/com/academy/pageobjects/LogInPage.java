package com.academy.pageobjects;

public class LogInPage extends PageBase<LogInPage>{
    public static String PAGE_PATH ;
    @Override
    public LogInPage open() {
        return openPage();
    }

    @Override
    public LogInPage init() {
        return initPage();
    }

    @Override
    public String getUrlPath() {
        return PAGE_PATH;
    }
    public String getLogInPageURL(){
        return getActualUrl();
    }
}
