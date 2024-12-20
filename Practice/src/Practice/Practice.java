package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Practice {

    public static void main(String[] args) {
        // Set up the Chrome WebDriver
        System.setProperty("webdriver.chrome.driver", "E:\\SQA Course\\SQA soft\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Login Page
            driver.get("https://hachnat.stage-carelogix.de/sing-in");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Initialize WebDriverWait with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for Username, Password, and Login button to be visible
            WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("credential")));
            WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.className("ant-btn")));

            // Enter login credentials and click the login button
            username.sendKeys("Shahriyar@yopmail.com");
            password.sendKeys("Carelogix24!!");
            login.click();

            // Wait for the page to load after login (explicit wait could be added here for a specific element)
            Thread.sleep(5000);  // Replace with explicit wait if necessary

            // Wait for the first target element to be clickable and click it
            WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[1]/div[2]/div/div/div[30]/div[1]")));
            targetElement.click();
            System.out.println("Target element clicked successfully!");

            // Wait for the file input element to appear and upload the file
            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));  // Update XPath to match the file input field
            fileInput.sendKeys("C:\\Users\\enamk\\OneDrive\\Desktop\\test_video.mp4");
            System.out.println("File uploaded successfully!");

            // Wait for the Send button to be clickable and click it
            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/div/button")));
            Thread.sleep(2000);  // Replace with explicit wait if necessary
            sendButton.click();
            System.out.println("Send button clicked successfully!");

            // Wait for the download element to be visible and interact with it
            WebElement downloadElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/main/div/div/div/div[2]/section/div/div/div/div[2]/div/div[5]/div[1]/div[1]/div[2]/div[2]/div/video")));
            downloadElement.click();  // Click the download element or perform another action as needed
            System.out.println("Download element clicked successfully!");

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Close the browser
          
            System.out.println("Test Completed!");
        }
    }
}