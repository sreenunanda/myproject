package resources;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class myLocks {
 
    WebDriver driver;
 
    By headertitle = By.xpath("//span[@id='lblHeaderTextPage']");
   
    
    
    
    
    
    
    //all objects belongs to that page
            

   //Constructor
     public myLocks(WebDriver driver){
 
        this.driver = driver;
 
    }
     public WebElement mheadertitle()
     {
    	 return driver.findElement(headertitle);
     }
    
		
	}
     
    
     
 
   
 
     
 
    //Click on login button
 
 
 
