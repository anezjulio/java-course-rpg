package com.rpg.combat.infraestructure.input;

import java.util.Scanner;

//TODO: convertir esta clase en un singleton (patron de diseño)
public class ConsoleInput {

    // por defecto es 10
    private final int DEFAULT_MAX_OPTIONS_AMOUNT= 10;
    private final int DEFAULT_MIN_OPTIONS_AMOUNT= 1;
    private final String DEFAULT_RETRY_MESSAGE= "intente de nuevo.";


    public int read(int cantidadMaximaDeOpciones) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean valido = false;
        while (!valido) {
//            System.out.print("ingrese un valor entre 1 y 10: ");
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero >= DEFAULT_MIN_OPTIONS_AMOUNT && numero <= cantidadMaximaDeOpciones) {
                    valido = true;
                } else {
                    System.out.println(DEFAULT_RETRY_MESSAGE);
                }
            } else {
//          System.out.println("datos no validos ingrese un número entre 1 y 10.");
                scanner.next();
            }
        }
        return numero;
    }

    public int read() {
        return read(DEFAULT_MAX_OPTIONS_AMOUNT);
    }

}




