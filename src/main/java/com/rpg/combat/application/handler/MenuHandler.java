package com.rpg.combat.application.handler;

import com.rpg.combat.Main;
import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.screen.MenuScreen;

public class MenuHandler implements Handler{

    private final MenuScreen menuScreen;
    private final ConsoleInput consoleInput;
    private final ConsoleUI consoleUI;

    public MenuHandler(MenuScreen menuScreen, ConsoleInput consoleInput, ConsoleUI consoleUI) {
        this.menuScreen = menuScreen;
        this.consoleInput = consoleInput;
        this.consoleUI = consoleUI;
    }

    public void execute() {
        // Muestra la pantalla de menu
        menuScreen.show();

        OptionScreen optionScreen = menuScreen.getOptions();

        consoleUI.showOptions(optionScreen);

        int optionAmount = optionScreen.getOptions().size();

        switch (consoleInput.read(optionAmount)){
            case 1: {
                NewProfileHandler newProfileHandler = Main.getNewProfileHandler();
                newProfileHandler.execute();
                break;
            }
            case 2: {
                ContinueHandler continueHandler = Main.getContinueHandler();
                continueHandler.execute();
                break;
            }
            case 3: {
                // CreditsHandler
                System.out.println("CreditsHandler, Proximamente.......");
                break;
            }
        }

    }

}
