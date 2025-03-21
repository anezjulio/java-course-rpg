package com.rpg.combat.infraestructure.input;


import java.util.Scanner;

public class ConsoleAdapter {
//crear un metodo para leer un numero de la consola y devolver un entero con dicho numero y tiene que ser public int leeropcion
// validar que las opciones sean entre 1 y 10, cualquier otro numero mayor o menor a estos ignorarlos
// opcional validar que no se ingresen string o cualquier otro dato que no sea numero
// al ocurrir un erro mostrar un mensaje que diga ingrese un valor una opcion entre 1 y 10

    public static int read() {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print("ingrese un valor entre 1 y 10: ");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero >= 1 && numero <= 10) {
                    valido = true;
                } else {
                    System.out.println("intente de nuevo.");
                }
            } else {
                System.out.println("datos no validos ingrese un número entre 1 y 10.");
                scanner.next();
            }
        }

        return numero;
    }

}




