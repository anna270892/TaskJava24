package org.example.translations.page;

import com.codeborne.selenide.ElementsCollection;

import lombok.val;
import org.example.translations.data.DataHelper;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    // к сожалению, разработчики не дали нам удобного селектора, поэтому так
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
    }

    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }

    public int getTwoCardBalance() {
        val text = cards.last().text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

        public TranslationsMoney cardToTransfer(DataHelper.CardInfo info) {
            cards.findBy(text(info.getCardNumber().substring(12, 16))).$("button").click();
            return new TranslationsMoney();
        }
    }

