package com.rpg.combat.application.handler;

import com.rpg.combat.domain.models.Character;
import com.rpg.combat.domain.models.Enemy;
import com.rpg.combat.domain.models.PlayerCharacter;
import com.rpg.combat.domain.services.BattleService;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.screen.BattleScreen;

public class BattleHandler implements Handler {

    private final BattleService battleService;
    private final BattleScreen battleScreen;
    private final ConsoleUI consoleUI;
    private final ConsoleInput consoleInput;

    private boolean isBattleOver = false;

    public BattleHandler(
            ConsoleUI consoleUI,
            ConsoleInput consoleInput,
            BattleService battleService,
            BattleScreen battleScreen

    ) {
        this.consoleUI = consoleUI;
        this.battleService = battleService;
        this.battleScreen = battleScreen;
        this.consoleInput = consoleInput;
    }

    @Override
    public void execute() {
        // mientras los enemigos no sean derrotados, o , la vida del jugador no sea 0, se continua con el turno siguiente.
        while(!battleService.IsTheBattleOver()){
            // mostrar template
            battleScreen.show();

            for (Character character : battleService.getTurnList()) {

                // turno jugador
                if (character instanceof PlayerCharacter) {
                    PlayerCharacter player = (PlayerCharacter) character;
                    System.out.println("Turno del jugador: " + player.getName());
                    // mostrar opciones
                    consoleUI.showOptions(
                            battleScreen.getPlayerActionsOptions()
                    );
                    int actionSelected = consoleInput.read(
                            battleService.getCurrentGame().getPlayerCharacter().getItems().size()
                                    + battleService.getCurrentGame().getPlayerCharacter().getSkills().size()
                            );

                    consoleUI.showOptions(
                            battleScreen.getPlayerTargetOptions()
                    );
                    int targetSelected = consoleInput.read( battleService.getCurrentGame().getEnemies().size() );

                    battleScreen.displaySelectedOption(actionSelected,targetSelected);

                    consoleUI.showOptions(
                            battleScreen.getPlayerContinueOptions()
                    );
                    int confirm = consoleInput.read();

                    // ejecutar accion

                // turno enemigo
                } else if (character instanceof Enemy) {
                    Enemy enemy = (Enemy) character;
                    System.out.println("Turno del enemigo: " + enemy.getName());
                    // escojer con un random la accion del enemigo
                    // mostrar accion escogida por enemigo
                    // ejecutar accion
                }

            }// for (Character character : battleService.getTurnList()) {

        } // while(!battleService.IsTheBattleOver()){

        if(battleService.isPlayerDefeated()){
            // Jugador Pierde
            battleService.resetGame();
            consoleUI.showMessage("jugador pierde, redireccion a gameover handler........");
        } else {
            // jugador Gana
            battleService.resetGame();
            consoleUI.showMessage("jugador gana, redireccion a reward handler........");
        }

    }

}


