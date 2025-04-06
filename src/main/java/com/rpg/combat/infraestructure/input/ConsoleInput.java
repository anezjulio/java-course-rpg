package com.rpg.combat.infraestructure.input;

import java.util.Scanner;

//TODO: convertir esta clase en un singleton (patron de diseño)
public class ConsoleInput {

    // por defecto es 10
    private final int DEFAULT_MAX_OPTIONS_AMOUNT= 10;
    private final int DEFAULT_MIN_OPTIONS_AMOUNT= 1;
    private final String DEFAULT_RETRY_MESSAGE= "intente de nuevo.";

    public int read(int cantidadMaximaDeOpciones) {
        // inicializo el scanner
        Scanner scanner = new Scanner(System.in);
        int numberSelected = 0;
        boolean valido = false;
        while (!valido) {
            if (scanner.hasNextInt()) {
                numberSelected = scanner.nextInt();
                if (numberSelected >= DEFAULT_MIN_OPTIONS_AMOUNT && numberSelected <= cantidadMaximaDeOpciones) {
                    valido = true;
                } else {
                    System.out.println(DEFAULT_RETRY_MESSAGE);
                }
            } else {
                scanner.next();
            }
        }
        return numberSelected;
    }

    public int read() {
        return read(DEFAULT_MAX_OPTIONS_AMOUNT);
    }

    public String readUser() {
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextLine();
    }
}




