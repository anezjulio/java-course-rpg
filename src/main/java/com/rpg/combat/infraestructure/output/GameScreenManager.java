package com.rpg.combat.infraestructure.output;

import com.rpg.combat.application.handler.MenuHandler;

public class GameScreenManager {

    private MenuHandler menuHandler;

    public GameScreenManager(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    public void startGame() {
        menuHandler.execute();
    }

}
