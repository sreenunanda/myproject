package resources;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class myaccount {
 
    WebDriver driver;
 
    By headertitle = By.xpath(".//*[@id='lblHeaderTextPage']");
   
    
    
    
    
    
    
    //all objects belongs to that page
            

   //Constructor
     public myaccount(WebDriver driver){
 
        this.driver = driver;
 
    }
     public WebElement mheadertitle()
     {
    	 return driver.findElement(headertitle);
     }
    
		
	}
     
    
     
 
   
 
     
 
    //Click on login button
 
 
 
