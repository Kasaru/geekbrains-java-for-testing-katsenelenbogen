package ru.geekbrains.java.katsenelenbogen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.java.katsenelenbogen.account.BuildAccount;

public class RegistrationPage extends BaseActions {

        private static final By REGISTRATION_PAGE_HEADER = By.cssSelector(".page-heading");
        private static final By FIRST_NAME_INPUT = By.cssSelector("#customer_firstname");
        private static final By LAST_NAME_INPUT = By.cssSelector("#customer_lastname");
        private static final By EMAIL_INPUT = By.cssSelector("#email");
        private static final By PASSWORD_INPUT = By.cssSelector("#passwd");
        private static final By ADDR_FIRST_NAME_INPUT = By.cssSelector("[id=firstname]");
        private static final By ADDR_LAST_NAME_INPUT = By.cssSelector("[id=lastname]");
        private static final By ADDR_INPUT = By.cssSelector("#address1");
        private static final By CITY_INPUT = By.cssSelector("#city");
        private static final By STATE_SELECT = By.cssSelector("#id_state");
        private static final By ZIP_INPUT = By.cssSelector("#postcode");
        private static final By COUNTRY_SELECT = By.cssSelector("#id_country");
        private static final By PHONE_INPUT = By.cssSelector("#phone_mobile");
        private static final By ADDR_ALIAS_INPUT = By.cssSelector("#alias");
        private static final By REGISTER_BTN = By.cssSelector("#submitAccount");
        private static final By ALERT_DIV = By.cssSelector("#center_column .alert");

        public RegistrationPage(WebDriver driver, WebDriverWait wait) {
            super(driver, wait);
        }

        public boolean isPageHeaderPresent() {
            return isElementPresent(REGISTRATION_PAGE_HEADER);
        }

        public boolean isAlertPresent() {
                return isElementPresent(ALERT_DIV);
        }
        public String getPageHeaderText() {
            return driver.findElement(REGISTRATION_PAGE_HEADER).getText();
        }


        public String getAlertText() {
            return driver.findElement(ALERT_DIV).getText();
        }
        public enum Alert {
                FIRST_NAME_ERR("firstname is required"),
                LAST_NAME_ERR("lastname is required"),
                EMAIL_ERR("email is required"),
                PASSWD_ERR("passwd is required"),
                ADDR_ERR("address1 is required"),
                CITY_ERR("city is required"),
                STATE_ERR("This country requires you to choose a State"),
                ZIP_ERR("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"),
                COUNTRY_ERR("Country is invalid"),
                PHONE_ERR("You must register at least one phone number"),
                ADDR_ALIAS_ERR("alias is required");

                private String text;

                Alert(String text) {
                        this.text = text;
                }

                public String getText() {
                        return text;
                }
        }
        public void submitForms(BuildAccount account) {
                type(account.getFirstName(), FIRST_NAME_INPUT);
                type(account.getLastName(), LAST_NAME_INPUT);
                type(account.getEmail(), EMAIL_INPUT);
                type(account.getPassword(), PASSWORD_INPUT);
                type(account.getAddrFirstName(), ADDR_FIRST_NAME_INPUT);
                type(account.getAddrLastName(), ADDR_LAST_NAME_INPUT);
                type(account.getAddress(), ADDR_INPUT);
                type(account.getCity(), CITY_INPUT);
                select(account.getStateId(), STATE_SELECT);
                type(account.getZip(), ZIP_INPUT);
                select(account.getCountryId(), COUNTRY_SELECT);
                type(account.getMobilePhone(), PHONE_INPUT);
                type(account.getAddressAlias(), ADDR_ALIAS_INPUT);
                click(REGISTER_BTN);
        }
}
