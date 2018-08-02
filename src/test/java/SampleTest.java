import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import  org.testng.annotations.*;

import java.net.URL;

public class SampleTest {

    public AppiumDriver driver;
    DesiredCapabilities cap;

    @BeforeClass
    public void setUp() throws  Exception{
        cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"6.0");
        cap.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/wordpress.apk");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.wordpress.android");
            cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.wordpress.android.ui.WPLaunchActivity");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }


    @Test
    public void demoTest() throws Exception{
        driver.findElement(By.id("org.wordpress.android:id/nux_create_account_button")).click();
        driver.findElement(By.id("org.wordpress.android:id/email_address")).sendKeys("arunkumar.c1993@gmail.com");
        driver.findElement(By.id("org.wordpress.android:id/username")).sendKeys("takkaiscool");
        driver.findElement(By.id("org.wordpress.android:id/password")).sendKeys("Kumar@123");
        //driver.findElement(By.id("org.wordpress.android:id/textView")).sendKeys("aruniscool");
        Thread.sleep(3000);
        driver.hideKeyboard();
        //System.out.print(driver.findElement(By.id("org.wordpress.android:id/password")).getAttribute("value"));
        driver.findElement(By.id("org.wordpress.android:id/signup_button")).click();
    }

    @Test
    public void loginTest() throws Exception{
        driver.findElement(By.id("org.wordpress.android:id/nux_username")).sendKeys("takkaiscool");
        driver.findElement(By.id("org.wordpress.android:id/nux_password")).sendKeys("Kumar@123");
        //driver.findElement(By.id("org.wordpress.android:id/textView")).sendKeys("aruniscool");
        driver.hideKeyboard();
        //System.out.print(driver.findElement(By.id("org.wordpress.android:id/password")).getAttribute("value"));
        driver.findElement(By.id("org.wordpress.android:id/nux_sign_in_button")).click();
    }

    @AfterClass
    public void tearDown(){
       // driver.quit();
    }

}
