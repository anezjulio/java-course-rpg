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

        // validar si el jugador o todos los enemigos llegaron a vida 0
        while(!battleService.IsTheBattleOver()){

            // mostrar template
            battleScreen.show();

            // mostrar lista de eventos (ultimos 3)

            for (Character character : battleService.getTurnList()) {

                // turno jugador
                if (character instanceof PlayerCharacter) {

                    PlayerCharacter player = (PlayerCharacter) character;
                    System.out.println("Turno del jugador: " + player.getName());

                    // mostrar opciones
                    consoleUI.showOptions(
                            battleScreen.getPlayerActionsOptions()
                    );
                    int actionSelected = consoleInput.read();

                    consoleUI.showOptions(
                            battleScreen.getPlayerTargetOptions()
                    );
                    int targetSelected = consoleInput.read();

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
            }


            // al terminar turno de todos en la lista, terminar ronda
            // al finalizar ronda, se vacia y vuelve a cargar la lista de aturnos



        }



        // evaluar si se gano o se perdio

            // si gano
            battleService.resetGame();
                // ir al handler de recompensa

            // si perdio
            battleService.resetGame();
                // ir al handler de game over

    }

}


