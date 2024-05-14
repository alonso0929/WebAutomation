package com.co.rimac.stepdefinitions;

import com.co.rimac.models.VariablesGlobales;
import com.co.rimac.steps.AgregarCarritoSteps;
import com.co.rimac.utils.GlobalData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AgregarCarritoStepDefinitions {

    @Steps
    private AgregarCarritoSteps agregarCarritoSteps;

    @Given("el usuario ingresa a la web")
    public void elUsuarioIngresaALaWeb() {
        agregarCarritoSteps.ingresarWeb(GlobalData.baseUrl);
    }

    @When("abre el menu")
    public void abreElMenu() {
        agregarCarritoSteps.seleccionarMenu();
    }

    @And("escoge una categoria")
    public void escogeUnaCategoria() {
        agregarCarritoSteps.elegirCategoria();
    }

    @And("escoge una subcategoria")
    public void escogeUnaSubcategoria() {
        agregarCarritoSteps.elegirSubCategoria();
    }

    @And("escoge cinco productos con cantidades aleatoriamente")
    public void escogeProductosConCantidadesAleatoriamente() throws InterruptedException {
        int[] numerosAleatorios = GlobalData.generarNumerosAleatorios(5);

        for (int numero : numerosAleatorios) {
            String xpathProducto = "/html/body/div[1]/main/section[4]/div/div[2]/div[2]/div[2]/ul/li[" + numero + "]/article/section/div[2]/div[2]/button";
            agregarCarritoSteps.seleccionarProductos(xpathProducto);

            String xpathNombreProducto = "/html/body/div[1]/main/section[4]/div/div[2]/div[2]/div[2]/ul/li[" + numero + "]/article/section/div[1]/div/h3/a";
            String nombreProducto = agregarCarritoSteps.guardarNombreProducto(xpathNombreProducto);
            GlobalData.agregarDatosAlArray(nombreProducto);

            String xpathPrecioProducto = "/html/body/div[1]/main/section[4]/div/div[2]/div[2]/div[2]/ul/li["+numero+"]/article/section/div[2]/div[1]/div/div[1]";
            Double precioProducto = agregarCarritoSteps.guardarPrecioProducto(xpathPrecioProducto);
            GlobalData.agregarPreciosAlArray(precioProducto);

            int aleatorio = GlobalData.generarNumeroAleatorio();
            for (int i=1; i<=aleatorio; i++) {
                String xpathSumar = "/html/body/div[1]/main/section[4]/div/div[2]/div[2]/div[2]/ul/li["+numero+"]/article/section/div[2]/div[2]/div/button[2]";
                agregarCarritoSteps.seleccionarCantidad(xpathSumar);
            }
            String xpathCantidadProducto = "/html/body/div[1]/main/section[4]/div/div[2]/div[2]/div[2]/ul/li["+numero+"]/article/section/div[2]/div[2]/div/div/p";
            Integer cantidadProducto = agregarCarritoSteps.guardarCantidadProducto(xpathCantidadProducto);
            GlobalData.agregarCantidadAlArray(cantidadProducto);
        }

        agregarCarritoSteps.validarCargaProductos();
    }

    @Then("ingresa a la opcion de carrito")
    public void ingresaALaOpcionDeCarrito() {
        agregarCarritoSteps.seleccionarCarrito();
    }

    @And("se validan los nombres del producto")
    public void seValidanLosNombresDelProducto() {
        for(int i=0;i<VariablesGlobales.nombreProducto.length;i++) {
            agregarCarritoSteps.validarNombreProducto(VariablesGlobales.nombreProducto[i]);
        }
    }

    @And("se validan los precios de los productos")
    public void seValidanLosPreciosDeLosProductos() {
        agregarCarritoSteps.validarPreciototal();
    }

    @And("se validan las cantidades de los productos")
    public void seValidanLasCantidadesDeLosProductos() {
        for(int i=0;i<VariablesGlobales.cantidadProducto.length;i++) {
            agregarCarritoSteps.validarCantidadProducto(String.valueOf(VariablesGlobales.cantidadProducto[i]));
        }
    }

    @And("se validan el numero total de productos")
    public void seValidanElNumeroTotalDeProductos() {
        agregarCarritoSteps.validarCantidadTotalProducto();
    }
}
