package org.example.translations.data;

import lombok.Value;
import org.example.translations.page.DashboardPage;


public class DataHelper {
    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    public static CardInfo getCard1() {
        return new CardInfo("5559000000000001");
    }

    public static CardInfo getCard2() {
        return new CardInfo("5559000000000002");
    }

    public static int[] getCardBalances(DashboardPage dashboardPage, CardInfo card1, CardInfo card2) {
        int balance1 = dashboardPage.getCardBalance(card1);
        int balance2 = dashboardPage.getCardBalance(card2);

        return new int[]{balance1, balance2};
    }

    public static int getPossibleAmount() {
        return 10000;
    }

    public static int getImpossibleAmount() {
        return 10000;
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }
    @Value
    public static class VerificationCode {
        private String code;
    }
    @Value
    public static class CardInfo {
        String cardNumber;
    }
}