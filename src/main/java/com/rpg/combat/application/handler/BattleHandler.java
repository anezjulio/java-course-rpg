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
                    int confirmAction = 2;
                    int actionSelected = 0;
                    int targetSelected = 0;
                    while( confirmAction == 2){
                        // Seleccion de accion
                        consoleUI.showOptions(battleScreen.getPlayerActionsOptions());
                        int maxActionsOptions = battleService.getCurrentGame().getPlayerCharacter().getItems().size()
                                + battleService.getCurrentGame().getPlayerCharacter().getSkills().size();
                        actionSelected = consoleInput.read(maxActionsOptions);

                        // Seleccion de enemigo
                        consoleUI.showOptions(battleScreen.getPlayerTargetOptions());
                        int maxTargetOptions = battleService.getCurrentGame().getEnemies().size();
                        targetSelected = consoleInput.read(maxTargetOptions);

                        // Confirmar accion
                        battleScreen.displaySelectedOption(actionSelected,targetSelected);
                        consoleUI.showOptions(
                                battleScreen.getPlayerContinueOptions()
                        );
                        confirmAction = consoleInput.read(3);
                    } //  while( confirmAction != 1){
                    // si se confirma la accion, se ejecuta la accion seleccionada
                    if(confirmAction == 1){
                        battleService.executeAction(actionSelected, character, targetSelected);
                    }
                } // if (character instanceof PlayerCharacter) {

                // turno enemigo
                if (character instanceof Enemy) {
                    Enemy enemy = (Enemy) character;
                    System.out.println("Turno del enemigo: " + enemy.getName());
                    // escojer con un random la accion del enemigo
                    // mostrar accion escogida por enemigo
                    // ejecutar accion
                }

            }// for (Character character : battleService.getTurnList()) {

        } // while(!battleService.IsTheBattleOver()){

        // jugador Gana
        if(battleService.isAllEnemyDefeated()){
            battleService.resetGame();
            battleService.nextChapter();
            // RewardHandler rewardHandler = Main.getRewardHandler();
            // rewardHandler.execute();
            consoleUI.showMessage("jugador gana, redireccion a reward handler........");
        }

        // Jugador Pierde
        if(battleService.isPlayerDefeated()){
            battleService.resetGame();
            // GameOverHandler gameOverHandler = Main.getGameOverHandler();
            // gameOverHandler.execute();
            consoleUI.showMessage("jugador pierde, redireccion a gameover handler........");
        }

    }

}


