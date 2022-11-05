import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PGprojektkoncowy {
    //zadanie 1-Napisz test,który zweryfikuje działanie aplikacji,gdy przy próbie logowania nie podano loginu.
    @Test
    public void checkEmptyLoginFiled() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        WebElement userPass = driver.findElement(By.id("password"));
        WebElement logIn = driver.findElement(By.id("login-button"));

        userPass.sendKeys("secret_sauce");
        logIn.click();

        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        Assertions.assertEquals("Epic sadface: Username is required", errorBox.getText());
        driver.quit();
    }

    //zadanie 2-Napisz test,który zweryfikuje działanie aplikacji,gdy przy próbie logowania nie podano hasła.
    @Test
    void checkEmptyPasswordField() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement logIn = driver.findElement(By.id("login-button"));

        userName.sendKeys("standard_user");
        logIn.click();

        WebElement errorBox = driver.findElement(By.cssSelector(".error-message-container"));
        Assertions.assertEquals("Epic sadface: Password is required", errorBox.getText());
        driver.quit();
    }

    //zadanie 3-Sprawdź,czy strona główna oraz strona logowania zawiera logo i pole sortowania.
    @Test
    void checkLogoSelectField() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//div[@class='login_logo']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed());

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement userPass = driver.findElement(By.id("password"));
        WebElement logIn = driver.findElement(By.id("login-button"));

        userName.sendKeys("standard_user");
        userPass.sendKeys("secret_sauce");
        logIn.click();

        driver.findElement(By.xpath("//div[@class='app_logo']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//select[@class='product_sort_container']")).isDisplayed());
        driver.quit();
    }

    //zadanie 4-Napisz test sprawdzający przejście ze strony głównej do strony ”Kontakt”
    @Test
    void checkContactTab() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//div[@class='login_logo']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed());

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement userPass = driver.findElement(By.id("password"));
        WebElement logIn = driver.findElement(By.id("login-button"));

        userName.sendKeys("standard_user");
        userPass.sendKeys("secret_sauce");
        logIn.click();

        WebElement sideMenu = driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']"));
        WebElement aboutPage = driver.findElement(By.xpath("//*[@id='about_sidebar_link']"));

        sideMenu.click();
        aboutPage.click();

        WebElement contact = driver.findElement(By.linkText("Contact"));
        contact.click();
        WebElement contactSales = driver.findElement(By.linkText("Contact Sales"));
        contactSales.click();
        driver.quit();
    }

    // Zadanie 5-Napisz test sprawdzający przejścia ze strony logowania do strony głównej.
    @Test
    void checkGoMainPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//div[@class='login_logo']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed());

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement userPass = driver.findElement(By.id("password"));
        WebElement logIn = driver.findElement(By.id("login-button"));

        userName.sendKeys("standard_user");
        userPass.sendKeys("secret_sauce");
        logIn.click();

        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed());
        driver.quit();
    }

    //Zadanie 6-Napisz test, który dodaje produkt do koszyka. Zweryfikuj, czy dodanie powiodło się.
    @Test
    void checkShoppingCartOrder() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//div[@class='login_logo']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed());

        WebElement userName = driver.findElement(By.xpath("//*[@id='user-name'] "));
        WebElement userPass = driver.findElement(By.xpath("//*[@id='password'] "));
        WebElement logIn = driver.findElement(By.xpath("//*[@id='login-button'] "));

        userName.sendKeys("standard_user");
        userPass.sendKeys("secret_sauce");
        logIn.click();

        //Assertions.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).isDisplayed());

        WebElement addSauceLabsBackpack = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        WebElement addSauceLabsBikeLight = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        WebElement goToCart = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a"));

        addSauceLabsBackpack.click();
        //addSauceLabsBikeLight.click();
        goToCart.click();

        String itemQty = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        int amountOfItems = Integer.parseInt(itemQty);

        System.out.println("You have " + amountOfItems + " item(s) in Cart");
        driver.quit();
    }

        //Assertions.assertTrue(driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).isDisplayed());
        //driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        //String text = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();

        //System.out.println(text);
        //int num = Integer.parseInt(text);
        //if ( num >= 0) {
           // System.out.println("Yes");
       // }else{
           // System.out.println("No");
        //}

    //Zadanie 7-Napisz test, który dodaje produkt do koszyka, a następnie usuwa go. Zweryfikuj, czy usunięcie powiodło się.
    @Test
    public void checkAddRemoveOrder() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//div[@class='login_logo']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed());

        WebElement userName = driver.findElement(By.xpath("//*[@id='user-name'] "));
        WebElement userPass = driver.findElement(By.xpath("//*[@id='password'] "));
        WebElement logIn = driver.findElement(By.xpath("//*[@id='login-button'] "));

        userName.sendKeys("standard_user");
        userPass.sendKeys("secret_sauce");
        logIn.click();

        WebElement addSauceLabsBackpack = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        WebElement goToCart = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a"));

        addSauceLabsBackpack.click();
        goToCart.click();

        Assertions.assertTrue(driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).isDisplayed());
        WebElement removeOrder = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
        removeOrder.click(); //Comment this section to check what happends ;)

        if (driver.findElements(By.xpath("//*[@class='shopping_cart_badge']")).size() != 0) {
            String itemQty = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
            int amountOfItems = Integer.parseInt(itemQty);
            System.out.println("You have "+ amountOfItems + " item(s) in Cart");
        }else {
            System.out.println("There are no items in the Cart");
        }
        driver.quit();
    }

    //Zadanie 8-Zrefaktoruj logowanie. Utwórz metodę pomocniczą login(), która przymuje dwa parametry: login i hasło. Użyj jej w teście sprawdzającym logowanie.
    @Test
    public void loginFurther(String userName, String userPass) {

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//div[@class='login_logo']")).click();

        WebElement userNameId = driver.findElement(By.xpath("//*[@id='user-name'] "));
        WebElement userPassId = driver.findElement(By.xpath("//*[@id='password'] "));
        WebElement logIn = driver.findElement(By.xpath("//*[@id='login-button'] "));

        userName = userName;
        userPass = userPass;

        userNameId.sendKeys(userName);
        userPassId.sendKeys(userPass);
        logIn.click();

        WebElement sideMenu = driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']"));
        WebElement logoutPage = driver.findElement(By.xpath("//*[@id='logout_sidebar_link']"));

        sideMenu.click();
        logoutPage.click();

        driver.quit();
        }
}
