package core.TAS.steps;

import com.codeborne.selenide.Selenide;

/**
 * Created by anonymous on 24.02.2019.
 */
public class Browser {

    public static void openPage(String url){
        Selenide.open(url);
    }


}
