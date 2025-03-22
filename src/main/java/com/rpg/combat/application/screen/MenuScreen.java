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

    @Override
    public String textForScreen() {
        return null;
    }

    @Override
    public String dataForScreen() {
        return null;
    }

    @Override
    public void loadScreen() {

    }

    @Override
    public void nextScreen() {

    }
}
