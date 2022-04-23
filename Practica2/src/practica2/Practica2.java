/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar = false;

        do {

            String numero1;
            // s'ha de crear un métode per entrada de double
            do {
                System.out.println("Calculadora\n Introdueix el primer numero. ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            //double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);

            // métode  per entrada de operacions fins que no sigui
            do {
                System.out.println("\n Operació? (Indica el signe)");
                System.out.println("Signe ***** Operació seleccionada\n"
                        + "*********************************\n"
                        + " \"+\" ***** sumar \n"
                        + " \"-\" ***** restar \n"
                        + " \"x\" ***** multiplicar \n"
                        + " \"/\" ***** dividir \n"
                        + " \"*\" ***** elevar primer num al segon num.\n"
                        + " \"%\" ***** residu");
                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-")
                        || operacion.equalsIgnoreCase("X")
                        || operacion.equals("/")
                        || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                } else {
                    comprobar = false;
                }
            } while (comprobar != true);

            String numero2;
            do {
                System.out.println("\n Introdueix el segon numero.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            //double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);

            do {
                comprobar = true;
                switch (operacion) {
                    case "+":
                        res = n2 + n2;
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
                            do {
                                System.err.println(" Al denominador hi ha un zero \n"
                                        + "per a  evitar errors coloca un altre valor.");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            //nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 / n2;
                        break;
                    //seleccionar * pot crear confussio de la operació
                    case "*":
                        res = Math.pow(n1, n1);
                        break;
                    case "%":
                        while (n2 == 0) {
                            do {
                                System.err.println(" Al denominador hi ha un zero \n"
                                        + "per a  evitar errors coloca un altre valor.");
                                numero2 = sc.nextLine();
                            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                            //nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 % n2;
                        break;
                }
            } while (comprobar != true);
// verificació ha de ser més senzilla solament sortida quan seleccioni i/o metode que certifiqui que es cert 
            System.out.println("Operació " + numero1 + "  " + operacion
                    + "  " + numero2 + " " + " = " + res);
            System.out.println("\n Vols continuar operant? \n");
            System.out.println(" [s/n]");
            //crear un metode per comprovar
            do {
                comprobar = true;
                operacion = sc.nextLine();

                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\n Error, posa un valor vàlid. \n");
                        comprobar = false;
                }
            } while (comprobar != true);
            // amb un .equalsIgnoreCase seria suficient tinria de estar inici ja que l'operació 
        } while (operacion.equalsIgnoreCase("S"));
    }
}
