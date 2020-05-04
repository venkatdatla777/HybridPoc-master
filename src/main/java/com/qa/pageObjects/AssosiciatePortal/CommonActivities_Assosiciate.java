package com.qa.pageObjects.AssosiciatePortal;

import com.qa.base.TestBase;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.qa.base.TestBase.*;

public class CommonActivities_Assosiciate {
    String constructedEmailId="";
    String currentWindowHandle;

    public void openAssociatePortal(String associatePortalURL){
        try {
        driver.navigate().to(associatePortalURL);
        LogThisStepInExtentReport("An User Logged in to Associate Portal with URL : "+associatePortalURL);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void loginToAssociatePortal(){
        try {
            associate_LandingPage.enterUserName("rdatla");
            associate_LandingPage.enterPassword("Rama7@renuka");
            LogThisStepInExtentReport("An User Logged in to Associate Portal with Userame : ramki and Password : Test1234");
            associate_LandingPage.clickOnLogin();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void searchForCostumerUsingFirstameLastName(String name) throws InterruptedException {
         currentWindowHandle = getDriver().getWindowHandle();
        asociate_AccountDashboardPage.searchAccountWith_LF(name);
        LogThisStepInExtentReport("Now user searched for an Account with lastname and firstname :"+name);
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        for (String window:windowHandles){
            if (window != currentWindowHandle){
                driver.switchTo().window(window);
            }
        }
        associate_CreditProfile_Page.waiTillCreditCardPortifolioPageLoaded();
       // LogThisStepInExtentReport("Now user searched for an Account with lastname and firstname :"+name);
    }

    public void addEmailInOtherCateogryAndUpdate() throws InterruptedException {
        associate_CreditProfile_Page.clickOnSkipVerficationYes();
        associate_CreditProfile_Page.clickOnEmailTab();
        String currentWindowHandle1 = driver.getWindowHandle();
        associate_CreditProfile_Page.ClickOnAddButton();
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ArrayList<String> windowHandles_list = new ArrayList<String>(driver.getWindowHandles());
        for (String window:windowHandles_list){
            System.out.println("window ID::"+window);
            if (window != currentWindowHandle1){
                System.out.println("Switched Window ID::::"+window);
                driver.switchTo().window(window);
            }
        }
        associate_CreditProfile_Page.selectEmailTypeAsOtherEmail();
        constructedEmailId="test"+generateRandomNumber()+"@gmail.com";
        associate_CreditProfile_Page.enterMailAddress(constructedEmailId);
        LogThisStepInExtentReport("Now adding the Email address :"+constructedEmailId);
        associate_CreditProfile_Page.enterEmailConsentYes();
        associate_CreditProfile_Page.ClickOnUpdateButton();
        Thread.sleep(5000);
        driver.switchTo().window(currentWindowHandle1);
    }


    public void editAndUpdateEmailInOtherCateogry() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-1'][contains(text(),'"+constructedEmailId+"')]")).click();
        String currentWindowHandle1 = driver.getWindowHandle();
        associate_CreditProfile_Page.ClickOnEmailUpdateButton();
        Thread.sleep(5000);
        ArrayList<String> windowHandles_list = new ArrayList<String>(driver.getWindowHandles());
        for (String window:windowHandles_list){
            System.out.println("window ID::"+window);
            if (window != currentWindowHandle1){
                System.out.println("Switched Window ID::::"+window);
                driver.switchTo().window(window);
            }
        }
        Thread.sleep(5000);
        associate_CreditProfile_Page.UpdateMailAddress("abc"+constructedEmailId);
        LogThisStepInExtentReport("Now Updating existing Email address to :"+"abc"+constructedEmailId);
        associate_CreditProfile_Page.ClickOnUpdateButton();
        Thread.sleep(5000);
        driver.switchTo().window(currentWindowHandle1);
    }

    public void deleteEnteredEmailInOtherCateogary() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-1'][contains(text(),'"+constructedEmailId+"')]")).click();
        LogThisStepInExtentReport("Now Deleting existing Email address to :"+constructedEmailId);
        associate_CreditProfile_Page.ClickOnEmailDeleteButton();
    }

    public void disposeAccount_SelectingPaymentOffer_SubmitAndColseAccount() throws InterruptedException {
        associate_CreditProfile_Page.clickOnDisposition();
        associate_CreditProfile_Page.SelectPaymentOfferAccepted();
        Thread.sleep(5000);
        LogThisStepInExtentReport("Now Trying to Dospose The Account by Submit and closingn the account");
        associate_CreditProfile_Page.ClickOnSubmitAndCloseAccountButton();
        Thread.sleep(5000);
    }

    public void logoutFromAssociatePortal() throws InterruptedException {
        currentWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(currentWindowHandle);
        LogThisStepInExtentReport("Now Logging out from Associate Portal");
        associate_LandingPage.clickOnLogout();
    }

}
