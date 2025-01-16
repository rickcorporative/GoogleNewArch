package com.demo.pages;

import com.demo.core.allure.AllureLogger;

public class Pages extends AllureLogger {
    /**
     * Pages
     */
    private static GoogleSearchPage googlePage;

    /**
     * This function return an instance of `NavigationPage`
     */


    public static GoogleSearchPage googlePage(){
        if(googlePage == null) {
            googlePage = new GoogleSearchPage();
        }
        return googlePage;
    }
}