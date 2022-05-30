import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class BaseTest {

    private static AppiumDriverLocalService service;

    @BeforeClass
    public void commonSetup(){
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }



    @AfterSuite(alwaysRun = true)
    public void globalTearDown () {
        if (service != null) {
            service.stop();
        }
    }

    public URL getServiceUrl () {
        return service.getUrl();
    }
}
