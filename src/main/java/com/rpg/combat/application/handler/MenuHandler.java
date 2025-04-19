package com.rpg.combat.application.handler;

import com.rpg.combat.Main;
import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.screen.MenuScreen;

public class MenuHandler implements Handler {

    // declaracion de dependencias
    private final MenuScreen menuScreen;
    private final ConsoleInput consoleInput;
    private final ConsoleUI consoleUI;

    // inyeccion de dependencias
    public MenuHandler(MenuScreen menuScreen, ConsoleInput consoleInput, ConsoleUI consoleUI) {
        this.menuScreen = menuScreen;
        this.consoleInput = consoleInput;
        this.consoleUI = consoleUI;
    }

    public void execute() {
        // Muestra la pantalla de menu, llama al template
        menuScreen.show();

        // recupera la lista de opciones a mostrar
        OptionScreen optionScreen = menuScreen.getOptions();

        // muestra las opciones de la pantalla de menu
        consoleUI.showOptions(optionScreen);

        // recupera el numero de opciones
        int optionAmount = optionScreen.getOptions().size();

        // lee la opcion del usuario y segun el caso
        int optionSelected = consoleInput.read(optionAmount);

        // redirecciona a la siguiente pantalla
        switch (optionSelected) {
            // opcion 1 New Game
            case 1: {
                // inicializar handler de new profile
                NewProfileHandler newProfileHandler = Main.getNewProfileHandler();
                // ejecuta el Handler
                newProfileHandler.execute();
                break;
            }
            // opcion 2 Continue
            case 2: {
                // inicializar handler de new profile
                ContinueHandler continueHandler = Main.getContinueHandler();
                // ejecuta el Handler
                continueHandler.execute();
                break;
            }
            // opcion 3 Credits
            case 3: {
                CreditsHandler creditshandler = Main.getCreditsHandler();
                creditshandler.execute();
                break;
            }
            // opcion 4 exit
            case 4: {
                // no se hace nada y el programa se finaliza solo
                break;
            }
        }

    }

}
