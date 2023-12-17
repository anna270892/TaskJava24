package org.example.translations.page;
import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import org.example.translations.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class TranslationsMoney {

    @Value
    public static class TransferMoney {
        SelenideElement popUpString = $("[data-test-id=amount] input");
        SelenideElement from = $("[data-test-id=from] [type=tel]");
        SelenideElement transferTo = $("[data-test-id=to]");
        SelenideElement popUpButton = $("[data-test-id=action-transfer]");
        SelenideElement cancelButton = $("[data-test-id=action-cancel]");
        SelenideElement errorMessage = $("[data-test-id=error-notification]");

        public void transferMoney(DataHelper.CardInfo cardNumber, String amount) {
            popUpString.val(amount);
            from.val(cardNumber.getCardNumber());
            popUpButton.click();
        }

        public DashboardPage makeValidTransfer(DataHelper.CardInfo cardNumber, String amount) {
            transferMoney(cardNumber, amount);
            return new DashboardPage();
        }
    }
}
