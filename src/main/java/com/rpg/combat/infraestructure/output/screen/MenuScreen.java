package com.rpg.combat.infraestructure.output.screen;

public class MenuScreen implements Screen{

    @Override
    public String[] getTemplate() {
        String[] template = {
            "██████╗░██╗░░░██╗███╗░░██╗░██████╗░███████╗░█████╗░███╗░░██╗  ███╗░░░███╗░█████╗░████████╗░█████╗░██╗░░██╗",
            "██╔══██╗██║░░░██║████╗░██║██╔════╝░██╔════╝██╔══██╗████╗░██║  ████╗░████║██╔══██╗╚══██╔══╝██╔══██╗██║░░██║",
            "██║░░██║██║░░░██║██╔██╗██║██║░░██╗░█████╗░░██║░░██║██╔██╗██║  ██╔████╔██║███████║░░░██║░░░██║░░╚═╝███████║",
            "██║░░██║██║░░░██║██║╚████║██║░░╚██╗██╔══╝░░██║░░██║██║╚████║  ██║╚██╔╝██║██╔══██║░░░██║░░░██║░░██╗██╔══██║",
            "██████╔╝╚██████╔╝██║░╚███║╚██████╔╝███████╗╚█████╔╝██║░╚███║  ██║░╚═╝░██║██║░░██║░░░██║░░░╚█████╔╝██║░░██║",
            "╚═════╝░░╚═════╝░╚═╝░░╚══╝░╚═════╝░╚══════╝░╚════╝░╚═╝░░╚══╝  ╚═╝░░░░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝",
            "",
            "▄█ ░ █▄░█ █▀▀ █░█░█   █▀█ █▀█ █▀█ █▀▀ █ █░░ █▀▀",
            "░█ ▄ █░▀█ ██▄ ▀▄▀▄▀   █▀▀ █▀▄ █▄█ █▀░ █ █▄▄ ██▄",
            "▀█ ░ █░░ █▀█ ▄▀█ █▀▄   █▀█ █▀█ █▀█ █▀▀ █ █░░ █▀▀",
            "█▄ ▄ █▄▄ █▄█ █▀█ █▄▀   █▀▀ █▀▄ █▄█ █▀░ █ █▄▄ ██▄",
            "█▀█ ░ █▀▀ █▀█ █▀▀ █▀▄ █ █▀ ▀█▀",
            "█▄█ ▄ █▄▄ █▀▄ ██▄ █▄▀ █ ▄█ ░█░",
            "",
            "Clase: <nombreDelPersonaje> ",
            "Narrator : choice your option"
        };
        return template;
    }

    @Override
    public void show() {
        
    }

    /*
    *
        String prototipoParaMostrarLaClase = " Clase: (nombreDelPersonaje)";
        prototipoParaMostrarLaClase.replace("(nombreDelPersonaje)",personajePrincipal.getRole().name());
        System.out.println(" Clase: (nombreDelPersonaje) ");
        System.out.println("<nombreDelPersonaje>");
        System.out.println(" HP:    (hpPersonaje) ");
        System.out.println("");
        System.out.println("");
        System.out.println(" Enemigo1: (nombreDelEnemigo1)");
        System.out.println(" HP: (hpEnemigo1)");
        System.out.println("");
        System.out.println(" Enemigo2: (nombreDelEnemigo2)");
        System.out.println(" HP: (hpEnemigo2)");
        System.out.println("");
        System.out.println("--------------------------------------------------------------");
        System.out.println(" Inicio de la batalla       ");
        System.out.println(" Es tu turno    ");
        System.out.println(" Accion:");
        System.out.println("    1. Skill");
        System.out.println(" Skill:");
        System.out.println("    1. ()");
        System.out.println("    2. Double damage");
        System.out.println(" Selecciona enemigo:");
        System.out.println("    1. Soldado A ");
        System.out.println("    2. Elemental A");
        System.out.println(" Soldado A Utiliza skill Slash, hace 50 daño al jugado        ");
        System.out.println(" Elemental A Utiliza skill fireball, hace de daño al jugado   ");
        System.out.println(" jugador Utiliza skill fireball, hace 70 daño al jugado       ");
        System.out.println("--------------------------------------------------------------");
    * */


}
