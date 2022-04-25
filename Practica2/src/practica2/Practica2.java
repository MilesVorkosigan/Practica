/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;
import CalculadoraPractica.calculadoraPractica;


/**
 *
 * @author esther
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String seleccio;

        calculadoraPractica calculadora = new calculadoraPractica();
        do {
            calculadora.setNumero1("Calculadora\n Introdueix el primer número. ");

            calculadora.seleccionarOperacio();

            calculadora.setNumero2("\n Introdueix el segon número.");
            calculadora.realitzarOperacio();

            System.out.println(calculadora);

            seleccio = calculadora.preguntarContinuarCalculant("\n Vols continuar operant? \n [s/n]");

        } while (seleccio.equalsIgnoreCase("S"));
    }
}
