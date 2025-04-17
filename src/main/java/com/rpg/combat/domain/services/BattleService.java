package com.rpg.combat.domain.services;

import com.rpg.combat.domain.models.Game;

public class BattleService {

    private static Game currentGame;

    public void setCurrentGame(Game game){
        this.currentGame = game;
    }

    public Game getCurrentGame(){
       return currentGame;
    }


    public boolean battleIsOver(){
        // evaluar vida de todos los enemigos, esten 0, return true
        // evaluar vida del jugar sea 0, return true

        return true;
    }

}
