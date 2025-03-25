package com.rpg.combat.application.handler;

import com.rpg.combat.Main;
import com.rpg.combat.domain.models.Game;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.screen.ContinueScreen;
import com.rpg.combat.infraestructure.persistence.GameRepository;

import java.util.List;

public class ContinueHandler implements Handler {

    private final GameRepository gameRepository;
    private final ContinueScreen continueScreen;
    private final ConsoleInput consoleInput;
    private final ConsoleUI consoleUI;

    public ContinueHandler(GameRepository gameRepository, ContinueScreen continueScreen, ConsoleInput consoleInput, ConsoleUI consoleUI) {
        this.gameRepository = gameRepository;
        this.continueScreen = continueScreen;
        this.consoleInput = consoleInput;
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.cls();

        // cargar savesGame a la patalla de continueScreen
        List<Game> savesGame = gameRepository.getGames();
        continueScreen.loadSaveGames(savesGame);

        // Muestra la pantalla de menu
        continueScreen.show();

        consoleUI.showOptions(
                continueScreen.getOptions()
        );

        int selectedOpcion = consoleInput.read();

        // last option will be return to menu selection
        if(selectedOpcion == savesGame.size() + 1){
            System.out.println("returning to menu selection... ... ...");
            MenuHandler menuHandler = Main.getMenuHandler();
            menuHandler.execute();
        }

        if(selectedOpcion >= 1 && selectedOpcion < savesGame.size() + 1){
            System.out.println("Selecciono: " + selectedOpcion);
        }

    }

}
