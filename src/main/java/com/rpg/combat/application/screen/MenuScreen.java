package com.rpg.combat.application.screen;

import com.rpg.combat.infraestructure.input.ConsoleAdapter;

public class MenuScreen implements Screen{
    @Override
    public void show() {
        System.out.println("-------------------------------------------------");
        System.out.println("                        Menu                     ");
        System.out.println("-------------------------------------------------");
        System.out.println("");
        System.out.println("1. New game");
        System.out.println("2. Load game");
        System.out.println("3. Credits");
        System.out.println("");
        System.out.println("    Select option: ");



        ConsoleAdapter.read();
    }
}
