package com.rpg.combat.application.screen;

import com.rpg.combat.infraestructure.input.ConsoleAdapter;

public class MenuScreen implements Screen{
    @Override
    public void show() {
        System.out.println("██████╗░██╗░░░██╗███╗░░██╗░██████╗░███████╗░█████╗░███╗░░██╗  ███╗░░░███╗░█████╗░████████╗░█████╗░██╗░░██╗");
        System.out.println("██╔══██╗██║░░░██║████╗░██║██╔════╝░██╔════╝██╔══██╗████╗░██║  ████╗░████║██╔══██╗╚══██╔══╝██╔══██╗██║░░██║");
        System.out.println("██║░░██║██║░░░██║██╔██╗██║██║░░██╗░█████╗░░██║░░██║██╔██╗██║  ██╔████╔██║███████║░░░██║░░░██║░░╚═╝███████║");
        System.out.println("██║░░██║██║░░░██║██║╚████║██║░░╚██╗██╔══╝░░██║░░██║██║╚████║  ██║╚██╔╝██║██╔══██║░░░██║░░░██║░░██╗██╔══██║");
        System.out.println("██████╔╝╚██████╔╝██║░╚███║╚██████╔╝███████╗╚█████╔╝██║░╚███║  ██║░╚═╝░██║██║░░██║░░░██║░░░╚█████╔╝██║░░██║");
        System.out.println("╚═════╝░░╚═════╝░╚═╝░░╚══╝░╚═════╝░╚══════╝░╚════╝░╚═╝░░╚══╝  ╚═╝░░░░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝");
        System.out.println("");
        System.out.println("▄█ ░ █▄░█ █▀▀ █░█░█   █▀█ █▀█ █▀█ █▀▀ █ █░░ █▀▀");
        System.out.println("░█ ▄ █░▀█ ██▄ ▀▄▀▄▀   █▀▀ █▀▄ █▄█ █▀░ █ █▄▄ ██▄");
        System.out.println("▀█ ░ █░░ █▀█ ▄▀█ █▀▄   █▀█ █▀█ █▀█ █▀▀ █ █░░ █▀▀");
        System.out.println("█▄ ▄ █▄▄ █▄█ █▀█ █▄▀   █▀▀ █▀▄ █▄█ █▀░ █ █▄▄ ██▄");
        System.out.println("█▀█ ░ █▀▀ █▀█ █▀▀ █▀▄ █ █▀ ▀█▀");
        System.out.println("█▄█ ▄ █▄▄ █▀▄ ██▄ █▄▀ █ ▄█ ░█░");
        System.out.println("");
        System.out.println("Narrator : choice your option");



        ConsoleAdapter.read();
    }
}
