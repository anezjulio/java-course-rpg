package com.rpg.combat.application.handler;

import com.rpg.combat.Main;
import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.screen.CreditsScreen;

public class CreditsHandler implements Handler {

    private final ConsoleInput consoleInput;
    private final ConsoleUI consoleUI;
    private final CreditsScreen creditsScreen;

    public CreditsHandler(CreditsScreen creditsScreen, ConsoleInput consoleInput, ConsoleUI consoleUI) {
        this.creditsScreen = creditsScreen;
        this.consoleInput = consoleInput;
        this.consoleUI = consoleUI;
    }

    public void execute() {
        // Muestra la pantalla de menú, llama al template
        creditsScreen.show();

        // Recupera la lista de opciones a mostrar
        OptionScreen optionScreen = creditsScreen.getOptions();

        consoleUI.showOptions(optionScreen);

        int optionAmount = optionScreen.getOptions().size();

        int optionSelected = consoleInput.read(optionAmount);

        switch (optionSelected) {
            case 1: {
                MenuHandler menuHandler = Main.getMenuHandler();
                menuHandler.execute();
                break;
            }

            case 2: {

                break;
            }

        }
    }
}
