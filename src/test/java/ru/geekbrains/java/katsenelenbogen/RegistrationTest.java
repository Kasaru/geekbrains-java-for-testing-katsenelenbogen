package ru.geekbrains.java.katsenelenbogen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.java.katsenelenbogen.account.AccountDataGenerator;
import ru.geekbrains.java.katsenelenbogen.account.BuildAccount;
import ru.geekbrains.java.katsenelenbogen.base.BaseUI;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends BaseUI {
    @BeforeEach
    private void goToSignInPage() {
        mainPage.home();
        mainPage.goToSignIn();
        assertTrue(signInPage.isPageHeaderPresent());
        assertEquals("authentication", signInPage.getPageHeaderText().toLowerCase());
    }

   // private static Stream<BuildAccount> createNewAccountTestDataSupplier() {
   //     AccountDataGenerator accountDataGenerator = new AccountDataGenerator();
   //     return accountDataGenerator.genAccount(5).stream();
   // }

    @DisplayName("Checks: main page - Sign in - Create an account - Register with valid data")
   // @ParameterizedTest(name = "{index} ==> {0}")
  //  @MethodSource("createNewAccountTestDataSupplier")
    @Test
    public void createNewAccountTest(BuildAccount account) {
        signInPage.enterEmailAndGoToRegistration(account.getEmail());
        assertTrue(registrationPage.isPageHeaderPresent());
        assertEquals("create an account", registrationPage.getPageHeaderText().toLowerCase());
        registrationPage.submitForms(account);
        assertTrue(accountPage.isPageHeaderPresent());
        assertEquals("my account", accountPage.getPageHeaderText().toLowerCase());
    }

    private static Stream<Arguments> registrationFailTestDataSupplier() {
        AccountDataGenerator accGen = new AccountDataGenerator();
        return Stream.of(
                Arguments.of(accGen.genAccount(), BuildAccount.Field.FIRST_NAME, RegistrationPage.Alert.FIRST_NAME_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.LAST_NAME, RegistrationPage.Alert.LAST_NAME_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.EMAIL, RegistrationPage.Alert.EMAIL_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.PASSWD, RegistrationPage.Alert.PASSWD_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.ADDR_FIRST_NAME, RegistrationPage.Alert.FIRST_NAME_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.ADDR_LAST_NAME, RegistrationPage.Alert.LAST_NAME_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.ADDRESS, RegistrationPage.Alert.ADDR_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.CITY, RegistrationPage.Alert.CITY_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.STATE, RegistrationPage.Alert.STATE_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.ZIP, RegistrationPage.Alert.ZIP_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.COUNTRY, RegistrationPage.Alert.COUNTRY_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.PHONE, RegistrationPage.Alert.PHONE_ERR.getText()),
                Arguments.of(accGen.genAccount(), BuildAccount.Field.ADDR_ALIAS, RegistrationPage.Alert.ADDR_ALIAS_ERR.getText())
        );
    }

    @DisplayName("Checks: main page - Sign in - Create an account - Register with invalid data (missing one field)")
    @ParameterizedTest(name = "{index} ==> Empty field: {1}; Expected alert: {2}")
    @MethodSource("registrationFailTestDataSupplier")
    public void registrationFailTest(BuildAccount account, BuildAccount.Field fieldToBreak, String expectedAlert) {
        signInPage.enterEmailAndGoToRegistration(account.getEmail());
        account.setField(fieldToBreak, "");
        registrationPage.submitForms(account);
        assertTrue(registrationPage.isAlertPresent());
        assertTrue(registrationPage.getAlertText().contains(expectedAlert));
    }
}
