package com.qa.pageObjects.CustomerPortal;

import static com.qa.base.TestBase.*;

public class CommonActivities_Customer {

    public void openCustomerPortal(String URL){
       getDriver().navigate().to(URL);
        LogThisStepInExtentReport("Customer Portal : Opening Application with following URL : "+URL);

    }
    public void logintoCustomerPortal() throws InterruptedException {
        User_LandingPage.enterFirstName(new String("Florian"));
        User_LandingPage.enterLastName(new String("Boutellier"));
        User_LandingPage.enterLastFourDigits(new String("1727"));
        User_LandingPage.enterMonth("Dec");
        User_LandingPage.enterDay("27");
        User_LandingPage.enterYear("1992");
        LogThisStepInExtentReport("Customer portal : logging into account with following details");
        User_LandingPage.clickOnLogin();
    }


    public void createAnAppointment() throws InterruptedException {
        Thread.sleep(8000);
        User_AccountSummaryPage.ClickOnScheduleAppointmentHyperlink();
        String dateForAppointment=user_ScheduleAppointments.getADateFromAvailableDates();
        user_ScheduleAppointments.enterAppointmentDate(dateForAppointment);
        user_ScheduleAppointments.selectWorkPhone();
        user_ScheduleAppointments.enterReasonsForCall("First Call");
        user_ScheduleAppointments.clickOnContinue();
        user_ScheduleAppointments.verify_appointmentGivenDate(dateForAppointment);
        user_ScheduleAppointments.verify_appointmentCommentsGiven("First Call");
        LogThisStepInExtentReport("Customer portal : Creating an Appointment with comments as : First Call");
        user_ScheduleAppointments.clickOnAppointmentSubmit();
        user_ScheduleAppointments.verifyAppointmentSuccessMessage("Appointment Saved Successfully");
        user_ScheduleAppointments.backToAppointmentHyperlink();
        Thread.sleep(5000);
    }

    public void editAnAppointment(){
        user_ScheduleAppointments.clickOnEditButtonOfScheduleAppointments();
        user_ScheduleAppointments.clearReasonsForCallTextBox();
        user_ScheduleAppointments.enterReasonsForCall("Edited Call");
        LogThisStepInExtentReport("Customer portal : Editing an Appointment with comments as : Edited Call");
        user_ScheduleAppointments.clickOnContinue();
        user_ScheduleAppointments.verify_appointmentCommentsGiven("Edited Call");
        user_ScheduleAppointments.clickOnAppointmentSubmit();
        user_ScheduleAppointments.backToAppointmentHyperlink();
    }

    public void deleteTheCreatedAppointmet(){
        user_ScheduleAppointments.clickOnDeleteButtonOfScheduleAppointments();
        LogThisStepInExtentReport("Customer portal : Deleting the existing Appointment");
        user_ScheduleAppointments.clickOnDeleteConfirmationYes();
    }

    public void logoutFromCustomerPortal() throws InterruptedException {

        LogThisStepInExtentReport("Customer Portal : logging out from customer portal");
        User_AccountSummaryPage.LogoutFromUserPortal();
    }
}
