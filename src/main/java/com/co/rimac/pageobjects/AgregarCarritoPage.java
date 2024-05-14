package com.co.rimac.pageobjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class AgregarCarritoPage extends PageObject {

    private static By btn_Menu = By.xpath("/html/body/div[1]/header/section/div/div[1]/button");
    private static By btn_Categoria = By.xpath("/html/body/div[1]/header/aside/ul/section[2]/div/li[6]/div/div/p");
    private static By btn_SubCategoria = By.xpath("/html/body/div[1]/header/div/div[2]/ul/div[2]/li[1]/ul/li[1]/a");
    private static By btn_Carrito = By.xpath("/html/body/div[1]/header/section/div/div[2]/div[2]/button");

    public static By getBtn_Menu() {
        return btn_Menu;
    }

    public static By getBtn_Categoria() {
        return btn_Categoria;
    }

    public static By getBtn_SubCategoria() {
        return btn_SubCategoria;
    }

    public static By getBtn_Carrito() {
        return btn_Carrito;
    }
}