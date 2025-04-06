package com.rpg.combat.infraestructure.output;

import com.rpg.combat.application.handler.MenuHandler;

public class GameScreenManager {

    private final MenuHandler menuHandler;

    // Buena practica para una constante
    private final String NOMBRE_DEL_JUEGO = "RPG para el curso de java";

    public GameScreenManager(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    public void startGame() {
        menuHandler.execute();
    }



}
