package com.anhtester.KiemTra1;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewCategory extends BaseTest {

    private String CATEGORY_NAME = "Test Category VTCC A3";

    @Test
    public void testCreateNewCategory() {
        driver.get("https://cms.anhtester.com/login");

        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Welcome to Active eCommerce CMS", "The header of Login page not match. ");

        //Enter email password
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Dashboard']")).isDisplayed(), "The Dashboard page not display.");

        //Open Category page
        driver.findElement(By.xpath("//span[normalize-space()='Products']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Category']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//h5")).getText(), "Categories", "The header of Category page not match. ");

        //Open Add New Category page
        driver.findElement(By.xpath("//span[normalize-space()='Add New category']")).click();

        //Enter data for add new category
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(CATEGORY_NAME);
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div//button")).click();
        sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div//input")).sendKeys("Sport shoes");
        sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Parent Category']/following-sibling::div//input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='order_level']")).sendKeys("1");
        driver.findElement(By.xpath("//label[normalize-space()='Type']/following-sibling::div//button")).click();
        sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Digital']")).click();

        //Select Banner
        driver.findElement(By.xpath("//label[normalize-space()='Banner (200x200)']/following-sibling::div")).click();
        sleep(1);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("car");
        sleep(2);
        driver.findElement(By.xpath("(//div[@title='car.jpg']//img)[1]")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(2);
        //Select icon
        driver.findElement(By.xpath("//label[normalize-space()='Icon (32x32)']/following-sibling::div")).click();
        sleep(1);
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("Cosy");
        sleep(2);
        driver.findElement(By.xpath("(//div[@title='Cosy.png']//img)[1]")).click();
        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys(CATEGORY_NAME);
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("Danh mục (hay có thể gọi là thể loại)");
        sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//button")).click();
        sleep(1);
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//input")).sendKeys("Capacity");
        driver.findElement(By.xpath("//label[normalize-space()='Filtering Attributes']/following-sibling::div//input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

        //Check alert message
        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Category has been inserted successfully']")).isDisplayed(), "The alert message success not display.");

        //Search and re-check
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(CATEGORY_NAME);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).isDisplayed(), "The Category not display.");
        Assert.assertEquals(driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText(), CATEGORY_NAME, "The Category Name not match.");

    }

}
