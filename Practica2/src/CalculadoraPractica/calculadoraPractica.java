/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculadoraPractica;

import java.util.Scanner;

/**
 *
 * @author marco
 */
public class calculadoraPractica {

    private String operacio;
    private double n1;
    private double n2;
    private double res;
    private static Scanner sc = new Scanner(System.in);

    public void setNumero1(String text) {
        String numero1;
        do {
            System.out.println(text);
            numero1 = sc.nextLine();
        } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
        n1 = new Double(numero1);
    }

    public void seleccionarOperacio() {
        boolean comprobar = false;
        do {
            System.out.println("\n Operació? (Indica el signe)");
            System.out.println("Signe ---- Operació seleccionada\n"
                    + "<---------------------------------->\n"
                    + " \"+\" ~~~~~ sumar \n"
                    + " \"-\" ~~~~~ restar \n"
                    + " \"x\" ~~~~~ multiplicar \n"
                    + " \"/\" ~~~~~ dividir \n"
                    + " \"p\" ~~~~~ elevar primer num al segon num.\n"
                    + " \"%\" ~~~~~ residu.\n"
                    + " \"L\" ~~~~~ logaritme");
            operacio = sc.nextLine();
            comprobar = operacio.equals("+") || operacio.equals("-")
                    || operacio.equalsIgnoreCase("X")
                    || operacio.equals("/")
                    || operacio.equals("%")
                    || operacio.equalsIgnoreCase("P")
                    || operacio.equalsIgnoreCase("L");
            if (comprobar == false) {
                System.err.println("Selecció incorrecte");
            }
        } while (comprobar != true);
    }

    public void setNumero2(String text) {
        String numero2;
        do {
            System.out.println(text);
            numero2 = sc.nextLine();
        } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
        n2 = new Double(numero2);
    }

    public void realitzarOperacio() {
        boolean comprobar = true;
        do {

            switch (operacio) {
                case "+":
                    res = n1 + n2;
                    break;
                case "-":
                    res = n1 - n2;
                    break;
                case "x":
                case "X":
                    res = n1 * n2;
                    break;
                case "/":
                    while (n2 == 0) {

                        setNumero2(" Al denominador hi ha un zero \n"
                                + "per a  evitar errors coloca un altre valor.");
                    }
                    res = n1 / n2;
                    break;

                case "p":
                case "P":
                    res = Math.pow(n1, n2);
                    break;
                case "%":
                    while (n2 == 0) {

                        setNumero2(" Al denominador hi ha un zero \n"
                                + "per a  evitar errors coloca un altre valor.");
                    }
                    res = n1 % n2;
                    break;
                case "L":
                case "l":
                    while (n1 <= 0 || n1 == 1) {
                        setNumero1(" La base (n1) ha de ser positiva i diferent de 1, \n"
                                + "per a  evitar errors coloca un altre valor.");

                    }
                    while (n2 <= 0) {
                        setNumero2("La x (n2) ha de ser positiva, \n"
                                + "per a  evitar errors coloca un altre valor.");

                    }
                    res = Math.log(n2) / Math.log(n1);
                    break;
            }
        } while (comprobar != true);
    }
    

    @Override
    public String toString() {
        return "Operació " + n1 + "  " + operacio
                + "  " + n2 + " " + " = " + res;
    }

    public String preguntarContinuarCalculant(String seleccio) {
        boolean comprobar = true;
        System.out.println(seleccio);
        do {

            seleccio = sc.nextLine();
            if (!(seleccio.equalsIgnoreCase("S")
                    || seleccio.equalsIgnoreCase("N"))) {

                System.err.println("\n Error, posa un valor vàlid. \n");
                comprobar = false;
            }

        } while (comprobar != true);
        return seleccio;
    }

}
