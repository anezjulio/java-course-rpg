package com.rpg.combat.application.handler;


import com.rpg.combat.Main;
import com.rpg.combat.domain.models.PlayerCharacter;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.screen.NewProfileScreen;
import com.rpg.combat.infraestructure.persistence.PlayerCharacterRepository;

import java.util.List;

public class NewProfileHandler implements Handler {

    private final NewProfileScreen newProfileScreen;
    private final ConsoleInput consoleInput;
    private final ConsoleUI consoleUI;
    private final PlayerCharacterRepository playerCharacterRepository;

    public NewProfileHandler(NewProfileScreen newProfileScreen, ConsoleInput consoleInput, ConsoleUI consoleUI, PlayerCharacterRepository playerCharacterRepository) {
        this.newProfileScreen = newProfileScreen;
        this.consoleInput = consoleInput;
        this.consoleUI = consoleUI;
        this.playerCharacterRepository = playerCharacterRepository;
    }

    @Override
    public void execute() {

        consoleUI.cls();
        List<PlayerCharacter> playerCharacterList = playerCharacterRepository.getplayerCharacterslist();
        newProfileScreen.LoadPlayerCharacters(playerCharacterList);
        newProfileScreen.show();
        consoleUI.showMessage("ingrese nombre del jugador: ");
        String username = consoleInput.readUser();
        newProfileScreen.showPlayerList();
        consoleUI.showOptions(
                newProfileScreen.getOptions()
        );

        int selectedOpcion = consoleInput.read();

        if (selectedOpcion == playerCharacterList.size() + 1) {
            System.out.println("returning to menu selection... ... ...");
            MenuHandler menuHandler = Main.getMenuHandler();
            menuHandler.execute();
        }

        if (selectedOpcion >= 1 && selectedOpcion < playerCharacterList.size() + 1) {
            System.out.println("escogiste : " + selectedOpcion);
        }

        if (selectedOpcion >= 1 && selectedOpcion <= playerCharacterList.size()) {
            consoleUI.cls();
            System.out.println("nombre del jugador: " + username);
            PlayerCharacter selectedHero = playerCharacterList.get(selectedOpcion - 1);
            System.out.println("heroe selecionado: " + selectedHero.getName());
            consoleUI.showOptions(newProfileScreen.getBeginBattleOption());
        }

        int opciondesalida = consoleInput.read();

        if (opciondesalida == 1) {

            consoleUI.showMessage("batalla capitulo 1 ");
        } else if (opciondesalida == 2) {
            consoleUI.showMessage("returning to menu selection... ... ...");
            MenuHandler menuHandler = Main.getMenuHandler();
            menuHandler.execute();
            consoleUI.showMessage("selecione si desea continuar a la batalla o salir al menu");

        }
    }
}
