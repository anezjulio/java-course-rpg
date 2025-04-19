package com.rpg.combat.application.handler;


import com.rpg.combat.Main;
import com.rpg.combat.domain.constants.Chapter;
import com.rpg.combat.domain.models.Enemy;
import com.rpg.combat.domain.models.Game;
import com.rpg.combat.domain.models.PlayerCharacter;
import com.rpg.combat.domain.services.BattleService;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.screen.NewProfileScreen;
import com.rpg.combat.infraestructure.persistence.EnemyRepository;
import com.rpg.combat.infraestructure.persistence.PlayerCharacterRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewProfileHandler implements Handler {

    private final BattleService battleService;
    private final NewProfileScreen newProfileScreen;
    private final ConsoleInput consoleInput;
    private final ConsoleUI consoleUI;
    private final PlayerCharacterRepository playerCharacterRepository;
    private final EnemyRepository enemyRepository;
    public NewProfileHandler(
            BattleService battleService,
            NewProfileScreen newProfileScreen,
            ConsoleInput consoleInput,
            ConsoleUI consoleUI,
            PlayerCharacterRepository playerCharacterRepository,
            EnemyRepository enemyRepository
    ) {
        this.battleService = battleService;
        this.newProfileScreen = newProfileScreen;
        this.consoleInput = consoleInput;
        this.consoleUI = consoleUI;
        this.playerCharacterRepository = playerCharacterRepository;
        this.enemyRepository = enemyRepository;
    }

    @Override
    public void execute() {
        PlayerCharacter selectedHero = null;

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
        int seletecPlayerCharacter = consoleInput.read();
        if (seletecPlayerCharacter == playerCharacterList.size() + 1) {
            System.out.println("returning to menu selection... ... ...");
            MenuHandler menuHandler = Main.getMenuHandler();
            menuHandler.execute();
        }
        if (seletecPlayerCharacter >= 1 && seletecPlayerCharacter < playerCharacterList.size() + 1) {
            System.out.println("escogiste : " + seletecPlayerCharacter);
        }
        if (seletecPlayerCharacter >= 1 && seletecPlayerCharacter <= playerCharacterList.size()) {
            consoleUI.cls();
            System.out.println("nombre del jugador: " + username);
            selectedHero = playerCharacterList.get(seletecPlayerCharacter - 1);
            System.out.println("heroe selecionado: " + selectedHero.getName());
            consoleUI.showOptions(newProfileScreen.getBeginBattleOption());
        }
        int opciondesalida = consoleInput.read();
        if (opciondesalida == 1) {
            consoleUI.showMessage("batalla capitulo 1 ");
            battleService.setCurrentGame(newGame(username,selectedHero));
            BattleHandler battleHandler = Main.getBattleHandler();
            battleHandler.execute();
        } else if (opciondesalida == 2) {
            consoleUI.showMessage("returning to menu selection... ... ...");
            MenuHandler menuHandler = Main.getMenuHandler();
            menuHandler.execute();
            consoleUI.showMessage("selecione si desea continuar a la batalla o salir al menu");

        }
    }
    private Game newGame(String username, PlayerCharacter selectedHero){
        return new Game(
                username,
                0,
                0,
                selectedHero,
                enemyRepository.getEnemies(),
                Chapter.PROLOGUE,
                new ArrayList<>(),
                null);

    }

}
