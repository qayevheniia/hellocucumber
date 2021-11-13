package hellocucumber;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ScenarioHooks {
    @Before (order = 0)
    // для того чтоб задать очередность
    private void setUpbrowser90(){
        Configuration.browser = "chrome";
    }

}
