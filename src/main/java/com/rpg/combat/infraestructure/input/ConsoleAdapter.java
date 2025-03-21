package com.rpg.combat.infraestructure.input;

import java.util.Scanner;


//TODO: convertir esta clase en un singleton (patron de diseño)
public class ConsoleAdapter {
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




