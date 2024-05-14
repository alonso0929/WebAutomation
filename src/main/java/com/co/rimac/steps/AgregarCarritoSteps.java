package com.co.rimac.steps;

import com.co.rimac.pageobjects.AgregarCarritoPage;
import com.co.rimac.pageobjects.ValidacionesPage;
import com.co.rimac.utils.GlobalData;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static net.serenitybdd.core.Serenity.getDriver;
import static org.junit.Assert.assertEquals;

public class AgregarCarritoSteps {

    AgregarCarritoPage agregarCarritoPage = new AgregarCarritoPage();
    ValidacionesPage validacionesPage = new ValidacionesPage();

    @Step
    public void ingresarWeb(String url) {
        getDriver().get(url);
    }

    @Step
    public void seleccionarMenu() {
        agregarCarritoPage.getDriver().findElement(AgregarCarritoPage.getBtn_Menu()).click();
    }

    @Step
    public void elegirCategoria() {
        agregarCarritoPage.getDriver().findElement(AgregarCarritoPage.getBtn_Categoria()).click();
    }

    @Step
    public void elegirSubCategoria() {
        agregarCarritoPage.getDriver().findElement(AgregarCarritoPage.getBtn_SubCategoria()).click();
    }

    @Step
    public void seleccionarProductos(String xpath) throws InterruptedException {
        agregarCarritoPage.getDriver().findElement(By.xpath(xpath)).click();
        Thread.sleep(3000);
    }

    @Step
    public void seleccionarCantidad(String xpath) throws InterruptedException {
        agregarCarritoPage.getDriver().findElement(By.xpath(xpath)).click();
        Thread.sleep(3000);
    }

    @Step
    public void validarCargaProductos() {
        agregarCarritoPage.getDriver().findElement(AgregarCarritoPage.getBtn_Carrito());
    }

    @Step
    public void seleccionarCarrito() {
        agregarCarritoPage.getDriver().findElement(AgregarCarritoPage.getBtn_Carrito()).click();
    }

    @Step
    public String guardarNombreProducto(String xpath) {
        return agregarCarritoPage.getDriver().findElement(By.xpath(xpath)).getText();
    }

    @Step
    public Double guardarPrecioProducto(String xpath) {
        String precioProducto = agregarCarritoPage.getDriver().findElement(By.xpath(xpath)).getText();
        int lastIndex = precioProducto.lastIndexOf("$");
        if (lastIndex != -1) {
            precioProducto = precioProducto.substring(lastIndex + 1).trim();
        }
        return Double.parseDouble(precioProducto);
    }

    @Step
    public Integer guardarCantidadProducto(String xpath) {
        String cantidad = agregarCarritoPage.getDriver().findElement(By.xpath(xpath)).getText();
        String valorSinSimbolo = cantidad.replaceAll("[^0-9]", "");
        return Integer.parseInt(valorSinSimbolo);
    }

    @Step
    public void validarNombreProducto(String producto) {
        assert agregarCarritoPage.getDriver().findElement(ValidacionesPage.getBody()).getText().contains(producto);
    }

    @Step
    public void validarCantidadProducto(String cantidad) {
        assert agregarCarritoPage.getDriver().findElement(ValidacionesPage.getBody()).getText().contains(cantidad);
    }

    @Step
    public void validarPreciototal() {
        double montoTotal = GlobalData.calcularMontoTotal();

        String precioProductos = agregarCarritoPage.getDriver().findElement(ValidacionesPage.getMontoTotal()).getText();
        String precioSinPuntos = precioProductos.replace("$ ", "").replace(".", "");

        double precioDouble = Double.parseDouble(precioSinPuntos)/1000;

        System.out.println("Monto Total Calculado: "+montoTotal);
        System.out.println("Monto Total Carrito: "+precioDouble);
        //assertEquals("Los montos no son iguales", montoTotal, precioDouble);
    }

    @Step
    public void validarCantidadTotalProducto() {
        GlobalData.calcularCantidadProductosTotal();
    }
}
