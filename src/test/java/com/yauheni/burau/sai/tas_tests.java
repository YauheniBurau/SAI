package com.yauheni.burau.sai;

import com.codeborne.selenide.Configuration;
import com.codepine.api.testrail.model.Case;
import com.codepine.api.testrail.model.Field;
import core.TAS.config.TestrailProperties;
import core.TAS.steps.Browser;
import core.TAS.testrail.TestRailUtility;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by anonymous on 21.02.2019.
 */
public class tas_tests {

    @Test
    public void connect_read_testrail() {
        TestRailUtility tru = new TestRailUtility(TestrailProperties.TESTRAIL_HOST,
                TestrailProperties.TESTRAIL_USERNAME,
                TestrailProperties.TESTRAIL_PASSWORD,
                TestrailProperties.TESTRAIL_APP_NAME
        );
        tru.test();

    }

    @Test
    public void selenide_test() {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "E:/temp/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        //WebDriverRunner.setWebDriver( new ChromeDriver() );
        Browser.openPage("https://www.google.com/");

    }

    @Test
    public void execute_testCase() {
        // init webdriver
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "E:/temp/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        // init testrail
        TestRailUtility tru = new TestRailUtility(TestrailProperties.TESTRAIL_HOST,
                TestrailProperties.TESTRAIL_USERNAME,
                TestrailProperties.TESTRAIL_PASSWORD,
                TestrailProperties.TESTRAIL_APP_NAME
        );
        // get testCase and steps
        Case testCase = tru.getTestCase(1);
        ArrayList<Field.Step> steps = (ArrayList<Field.Step>)testCase.getCustomFields().get("steps_separated");
        for (Field.Step step: steps) {

        }

        for(Field.Step step: steps) {
            System.out.println("step: " + step.getContent() + "; expected result: " + step.getExpected());
            String content = step.getContent();
            int index;
            index = content.indexOf("in ")+3;
//            String modul = content;
        }
        Browser.openPage("https://www.google.com/");
    }

}
