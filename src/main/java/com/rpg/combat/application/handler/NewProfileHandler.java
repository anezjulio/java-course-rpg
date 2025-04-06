package com.rpg.combat.application.handler;


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
        consoleUI.showTemplate(newProfileScreen.getTemplate());
        consoleUI.showMessage("ingrese nombre del jugador: ");
        String username = consoleInput.readUser();
        List<PlayerCharacter> playerCharacterList = playerCharacterRepository.getplayerCharacterslist();
        newProfileScreen.LoadPlayerCharacters(playerCharacterList);

        newProfileScreen.show();

    }

}
