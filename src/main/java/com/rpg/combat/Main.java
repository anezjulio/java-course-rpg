package com.rpg.combat;


import com.rpg.combat.application.handler.ContinueHandler;
import com.rpg.combat.application.handler.MenuHandler;
import com.rpg.combat.application.handler.NewProfileHandler;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.GameScreenManager;
import com.rpg.combat.infraestructure.output.screen.ContinueScreen;
import com.rpg.combat.infraestructure.output.screen.MenuScreen;
import com.rpg.combat.infraestructure.persistence.GameRepository;

public class Main {

    // Declare dependencies
    private static MenuHandler menuHandler;
    private static ContinueHandler continueHandler;
    private static NewProfileHandler newProfileHandler;

    private static MenuScreen menuScreen;
    private static ContinueScreen continueScreen;

    private static GameRepository gameRepository;

    private static ConsoleInput consoleInput;
    private static ConsoleUI consoleUI;


    public static void main(String[] args) {

        GameScreenManager gameScreenManager = new GameScreenManager(getMenuHandler());
        gameScreenManager.startGame();

    }

    // Lazy initialization - Inicialización perezosa
    // Decision Tecnica/Mala practica
    // Hacer los método público: Solución rápida,
    // pero expone el acceso a las dependencias desde
    // cualquier parte del código, lo que puede no ser ideal.

    public static ConsoleInput getConsoleInput() {
        if (consoleInput == null) {
            consoleInput = new ConsoleInput();
        }
        return consoleInput;
    }

    public static ConsoleUI getConsoleUI() {
        if (consoleUI == null) {
            consoleUI = new ConsoleUI();
        }
        return consoleUI;
    }

    public static MenuHandler getMenuHandler() {
        if (menuHandler == null) {
            menuHandler = new MenuHandler(getMenuScreen(), getConsoleInput(), getConsoleUI());
        }
        return menuHandler;
    }

    public static GameRepository getGameRepository() {
        if (gameRepository == null) {
            gameRepository = new GameRepository();
        }
        return gameRepository;
    }

    public static ContinueScreen getContinueScreen() {
        if (continueScreen == null) {
            continueScreen = new ContinueScreen(getConsoleUI());
        }
        return continueScreen;
    }


    public static ContinueHandler getContinueHandler() {
        if (continueHandler == null) {
            continueHandler = new ContinueHandler(getGameRepository(), getContinueScreen(), getConsoleInput(), getConsoleUI());
        }
        return continueHandler;
    }

    public static NewProfileHandler getNewProfileHandler() {
        if (newProfileHandler == null) {
            newProfileHandler = new NewProfileHandler();
        }
        return newProfileHandler;
    }

    public static MenuScreen getMenuScreen() {
        if (menuScreen == null) {
            menuScreen = new MenuScreen(getConsoleUI());
        }
        return menuScreen;
    }
}

