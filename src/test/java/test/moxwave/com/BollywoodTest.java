package test.moxwave.com;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BollywoodTest {
  
   static WebDriver driver;
    static String[] Actor_list;
    String[] movie_name;
    String[] year_list;
    int i=0;
    List<WebElement> moviename;
    List<WebElement> year;
  
    public static void main(String[]args) throws InterruptedException {
        
 System.setProperty("webdriver.chrome.driver","/home/adminp901/projects/wave/src/test/resources/chromedriver_linux64_version83.0.4103.14/chromedriver");
 ChromeOptions ChromeOption=new ChromeOptions();
 ChromeOption.addArguments("start-maximized");
  driver=new ChromeDriver(ChromeOption);
  driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
 driver.get("https://www.imdb.com/list/ls025929404/");
       
   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        // Get the Actor name list
        List<WebElement> actor_name= driver.findElements(By.xpath("//*[@class='lister list detail sub-list']/div[3]/div/div[2]/h3/a"));  
        Actor_list=new String[actor_name.size()];
        for(int i=0;i<actor_name.size();i++)
       {
        Actor_list[i]=actor_name.get(i).getText();
        System.out.println(Actor_list[i]);
                   
       }
       Scanner scan=new Scanner(System.in);
       System.out.println("please enter a Number from the above list to see the Movie list of that actor");
          int a=scan.nextInt();
        String actorname= Actor_list[a];
        System.out.println("You choose Actor name=  "+actorname);;
       
       driver.get("https://en.wikipedia.org/wiki/List_of_Bollywood_actors");
      Thread.sleep(5000);
       
       WebElement name = driver.findElement(By.xpath("//*[text()='"+actorname+"']"));
        System.out.println(name.getText());   
         name.click();

      //   driver.findElement(By.xpath("//*[@class='lister list detail sub-list']/div[3]/div[1]/div[2]/h3/a")).click(); // click on Actor name link
      //   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
      // List<WebElement> moviename=  driver.findElements(By.xpath("//*[@id='filmography']/div[2]/div/b"));   // Fetch movie name
      // List<WebElement> year=  driver.findElements(By.xpath("//*[@id='filmography']/div[2]/div/span"));    // Fetch year 
      //   movie_name=new String[moviename.size()];
      //   year_list=new String[year.size()];
      //      for(int i=0;i<moviename.size();i++){  
      //        movie_name[i]=moviename.get(i).getText();
      //        year_list[i]=year.get(i).getText();
             
      //     // System.out.println(moviename.get(i).getText()+"  "+year.get(i).getText());
      //      }
          
          
    //   Scanner scan=new Scanner(System.in);
    //   System.out.println("if you want to see Movie list of particular Actor, please Enter number from the above list");
    //  int number= scan.nextInt();
   // Thread.sleep(6000);
    //   System.out.println(number);
     // driver.findElement(By.xpath("//*[@class='lister list detail sub-list']/div[3]/div[5]/div[2]/h3/a")).click(); // click on Actor name link
      //System.out.println(number);
      // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      // List<WebElement> moviename=  driver.findElements(By.xpath("//*[@id='filmography']/div[2]/div/b"));   // Fetch movie name
      // List<WebElement> year=  driver.findElements(By.xpath("//*[@id='filmography']/div[2]/div/span"));    // Fetch year
      // for(int i=0;i<moviename.size();i++){   
      //   System.out.println(moviename.get(i).getText()+"  "+year.get(i).getText());
      // }
    //    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

    //     JavascriptExecutor js = (JavascriptExecutor) driver;
    //     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    //     driver.findElement(By.xpath("//*[@class='list-pagination']/a[2]")).click(); // Click on the 2nd pagination
    //     List<WebElement> wb1= driver.findElements(By.xpath("//*[@class='lister list detail sub-list']/div[3]/div/div[2]/h3")); // Get Actor name list from 2nd pagination
       
    //    for(int i=0;i<wb1.size();i++){
    //          System.out.println(wb1.get(i).getText());
             
    //    }
    

  }


}