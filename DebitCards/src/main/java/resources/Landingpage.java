package resources;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class Landingpage {
 
    WebDriver driver;
 
    By homeview = By.xpath(".//*[@id='bodyContent_divHomeView']/a/img");
   
    By mydevices= By.xpath(".//*[@id='bodyContent_divDevices']/a/img");
    By locks= By.xpath(".//*[@id='bodyContent_divLocks']/a/img");
    By myaccount= By.xpath(".//*[@id='bodyContent_divAccount']/a/img");
    By mycontacts= By.xpath(".//*[@id='bodyContent_divContacts']/a/img");
    By home= By.xpath(".//*[@id='bodyContent_lnkHome']");
    By night= By.xpath(".//*[@id='bodyContent_lnkNight']");
    By away= By.xpath(".//*[@id='bodyContent_lnkAway']");
    
    
    
    
    
    //all objects belongs to that page
            

   //Constructor
     public Landingpage(WebDriver driver){
 
        this.driver = driver;
 
    }
     public WebElement mmydevices()
     {
    	 return driver.findElement(mydevices);
     }
     public WebElement mlocks()
     {
    	 return driver.findElement(locks);
     }
     public WebElement mmyaccount()
     {
    	 return driver.findElement(myaccount);
     }
     public WebElement mmycontacts()
     {
    	 return driver.findElement(mycontacts);
     }
     public WebElement mhome()
     {
    	 return driver.findElement(home);
     }
     public WebElement mnight()
     {
    	 return driver.findElement(night);
     }
     public WebElement maway()
     {
    	 return driver.findElement(away);
     }

		
	}
     
    
     
 
   
 
     
 
    //Click on login button
 
 
 
