package com.co.rimac.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ValidacionesPage extends PageObject {

    private static By body = By.xpath("/html/body");
    private static By montoTotal = By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[3]/section/div[6]/div/div[2]/div[1]/span[2]");

    public static By getBody() {
        return body;
    }

    public static By getMontoTotal() {
        return montoTotal;
    }
}
