package org.example.translations.test;

import org.example.translations.data.DataHelper;

import org.example.translations.page.LoginPage;
import org.example.translations.page.TranslationsMoney;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class translationsTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:7777/");
    }

    //Проверка перевода с первой карты на вторую
    @Test
    void transferFromTheFirstCardToTheSecond() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);

        var firstCard = DataHelper.getCard1();
        var startingBalance1 = dashboardPage.getFirstCardBalance();

        var secondCard = DataHelper.getCard2();
        var startingBalance2 = dashboardPage.getTwoCardBalance();

        var amount = DataHelper.getPossibleAmount();
        var moneyTransferPage = dashboardPage.cardToTransfer(secondCard);

        // Создаем объект TransferMoney для выполнения транзакции
        var transferMoney = new TranslationsMoney.TransferMoney();

        // Выполняем перевод с первой карты на вторую
        transferMoney.makeValidTransfer(firstCard, String.valueOf(amount));

        // Получаем балансы после транзакции
        var finalBalance1 = dashboardPage.getFirstCardBalance();
        var finalBalance2 = dashboardPage.getTwoCardBalance();

        // Проверяем, что балансы изменились согласно ожидаемым значениям
        assertEquals(startingBalance1 - amount, finalBalance1);
        assertEquals(startingBalance2 + amount, finalBalance2);
    }

    //Проверка перевода с второй карты на первую
    @Test
    void transferFromTheSecondCardToTheFirst() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);

        var firstCard = DataHelper.getCard1();
        var startingBalance1 = dashboardPage.getFirstCardBalance();

        var secondCard = DataHelper.getCard2();
        var startingBalance2 = dashboardPage.getTwoCardBalance();

        var amount = DataHelper.getPossibleAmount();
        var moneyTransferPage = dashboardPage.cardToTransfer(firstCard);

        // Создаем объект TransferMoney для выполнения транзакции
        var transferMoney = new TranslationsMoney.TransferMoney();

        // Выполняем перевод с первой карты на вторую
        transferMoney.makeValidTransfer(secondCard, String.valueOf(amount));

        // Получаем балансы после транзакции
        var finalBalance1 = dashboardPage.getFirstCardBalance();
        var finalBalance2 = dashboardPage.getTwoCardBalance();

        // Проверяем, что балансы изменились согласно ожидаемым значениям
        assertEquals(startingBalance1 + amount, finalBalance1);
        assertEquals(startingBalance2 - amount, finalBalance2);
    }

    //Проверка перевода с первой карты на первую карту
    @Test
    void transferFromTheFirstCardToTheFirst() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);

        var firstCard = DataHelper.getCard1();
        var startingBalance1 = dashboardPage.getFirstCardBalance();

        var secondCard = DataHelper.getCard2();
        var startingBalance2 = dashboardPage.getTwoCardBalance();

        var amount = DataHelper.getPossibleAmount();
        var moneyTransferPage = dashboardPage.cardToTransfer(firstCard);

        // Создаем объект TransferMoney для выполнения транзакции
        var transferMoney = new TranslationsMoney.TransferMoney();

        // Выполняем перевод с первой карты на первую
        transferMoney.makeValidTransfer(firstCard, String.valueOf(amount));

        // Получаем балансы после транзакции
        var finalBalance1 = dashboardPage.getFirstCardBalance();
        var finalBalance2 = dashboardPage.getTwoCardBalance();

        // Проверяем, что балансы изменились согласно ожидаемым значениям
        assertEquals(startingBalance1, finalBalance1);
        assertEquals(startingBalance2, finalBalance2);
    }

    //Проверка перевода с второй карты на вторую
    @Test
    void transferFromTheSecondCardToTheSecond() {
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify(verificationCode);

        var firstCard = DataHelper.getCard1();
        var startingBalance1 = dashboardPage.getFirstCardBalance();

        var secondCard = DataHelper.getCard2();
        var startingBalance2 = dashboardPage.getTwoCardBalance();

        var amount = DataHelper.getPossibleAmount();
        var moneyTransferPage = dashboardPage.cardToTransfer(secondCard);

        // Создаем объект TransferMoney для выполнения транзакции
        var transferMoney = new TranslationsMoney.TransferMoney();

        // Выполняем перевод с второй на вторую карту
        transferMoney.makeValidTransfer(secondCard, String.valueOf(amount));

        // Получаем балансы после транзакции
        var finalBalance1 = dashboardPage.getFirstCardBalance();
        var finalBalance2 = dashboardPage.getTwoCardBalance();

        // Проверяем, что балансы изменились согласно ожидаемым значениям
        assertEquals(startingBalance1, finalBalance1);
        assertEquals(startingBalance2, finalBalance2);
    }
}