package com.co.rimac.utils;

import com.co.rimac.models.VariablesGlobales;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GlobalData {

    public static String baseUrl = "https://www.exito.com/";

    public static int[] generarNumerosAleatorios(int cantidad) {
        Random random = new Random();
        Set<Integer> numerosAleatoriosSet = new HashSet<>();

        while (numerosAleatoriosSet.size() < cantidad) {
            int numeroAleatorio = random.nextInt(8) + 1;
            numerosAleatoriosSet.add(numeroAleatorio);
        }

        int[] numerosAleatoriosArray = new int[cantidad];
        int index = 0;
        for (int numero : numerosAleatoriosSet) {
            numerosAleatoriosArray[index++] = numero;
        }
        return numerosAleatoriosArray;
    }

    public static int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    public static void agregarDatosAlArray(String dato) {
        int index = 0;
        while(index<VariablesGlobales.nombreProducto.length && VariablesGlobales.nombreProducto[index]!=null){
            index++;
        }

        if(index<VariablesGlobales.nombreProducto.length) {
            VariablesGlobales.nombreProducto[index] = dato;
        } else {
            System.out.println("No se pueden agregar mas productos");
        }
    }

    public static void agregarPreciosAlArray(Double dato) {
        DecimalFormat formato = new DecimalFormat("#0.000");
        String datoFormateado = formato.format(dato);
        int index = 0;
        while(index<VariablesGlobales.precioProducto.length && VariablesGlobales.precioProducto[index]!=null){
            index++;
        }

        if(index<VariablesGlobales.precioProducto.length) {
            VariablesGlobales.precioProducto[index] = Double.parseDouble(datoFormateado);
        } else {
            System.out.println("No se pueden agregar mas precios de productos");
        }
    }

    public static void agregarCantidadAlArray(Integer dato) {
        int index = 0;
        while(index<VariablesGlobales.cantidadProducto.length && VariablesGlobales.cantidadProducto[index]!=null){
            index++;
        }

        if(index<VariablesGlobales.cantidadProducto.length) {
            VariablesGlobales.cantidadProducto[index] = dato;
        } else {
            System.out.println("No se pueden agregar mas cantidades de productos");
        }
    }

    public static void calcularCantidadProductosTotal() {
        int total = 0;
        for(int i=0; i<5; i++){
            total += VariablesGlobales.cantidadProducto[i];
        }
        System.out.println("Cantidad total de productos: "+total);
    }

    public static double calcularMontoTotal() {
        double total = 0;
        for(int i=0; i<5; i++){
            double subtotal = VariablesGlobales.cantidadProducto[i]*VariablesGlobales.precioProducto[i];
            total += subtotal;
        }
        DecimalFormat formato = new DecimalFormat("#0.000");

        return Double.parseDouble(formato.format(total));
    }
}
