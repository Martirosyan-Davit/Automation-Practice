package com.academy.pageobjects;

public class PracticeProjectPage extends PageBase<PracticePage>{
    public static String URL_PATH = "/practice-project";
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
        return URL_PATH;
    }
    public String getPracticeProjectPageURL(){
        return getActualUrl();
    }
}
