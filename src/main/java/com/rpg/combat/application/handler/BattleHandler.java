package com.rpg.combat.application.handler;

import com.rpg.combat.domain.services.BattleService;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.screen.BattleScreen;

public class BattleHandler implements Handler {

    private final BattleService battleService;
    private final BattleScreen battleScreen;
    private final ConsoleUI consoleUI;

    private boolean isBattleOver = false;

    public BattleHandler(
            ConsoleUI consoleUI,
            BattleService battleService,
            BattleScreen battleScreen
    ) {
        this.consoleUI = consoleUI;
        this.battleService = battleService;
        this.battleScreen = battleScreen;
    }

    @Override
    public void execute() {
        
        while(!isBattleOver){
            // definir el turno actual
                // el primer turno siempre es del jugador

            // mostrar template
            battleScreen.show();

            // si es turno jugador
                // mostrar opciones
                    // mostrar y leer skills y items
                    // ejecutar accion

            // si es turno enemigo
                // mostrar accion escogida por enemigo
                // ejecutar accion

            // mostrar lista de eventos (ultimos 3)

            // validar si el jugador o todos los enemigos llegaron a vida 0
            isBattleOver = battleService.battleIsOver();
        }

        // evaluar si se gano o se perdio
            // si gano
                // ir al handler de recompensa
            // si perdio
                // ir al handler de game over

    }

}


