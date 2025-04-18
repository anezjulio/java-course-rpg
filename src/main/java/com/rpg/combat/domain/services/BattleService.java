package com.rpg.combat.domain.services;

import com.rpg.combat.domain.models.Character;
import com.rpg.combat.domain.models.Enemy;
import com.rpg.combat.domain.models.Game;
import com.rpg.combat.domain.models.PlayerCharacter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleService {

    private static Game currentGame;
    private List<Character> turnList;

    private boolean isAllEnemyDefeated;
    private boolean isPlayerDefeated;


    public void setCurrentGame(Game game){
        this.currentGame = game;
    }

    public Game getCurrentGame(){
       return currentGame;
    }

    public boolean IsTheBattleOver(){
        List<Enemy> enemyList = currentGame.getEnemyList();
        List<PlayerCharacter> playerCharacters = Arrays.asList(currentGame.getPlayerCharacter());

        int enemiesDefeated = 0;
        int playerDefeated = 0;

        for (int i = 0; i < enemyList.size(); i++) {
            if (enemyList.get(i).getHpCurrent() == 0){
                enemiesDefeated++;
            }
        }

        for (int i = 0; i < playerCharacters.size(); i++) {
            if (playerCharacters.get(i).getHpCurrent() == 0){
                playerDefeated++;
            }
        }

        boolean isAllEnemyDefeated = enemyList.size() == enemiesDefeated;
        boolean isPlayerDefeated = playerCharacters.size() == playerDefeated;

        if( isAllEnemyDefeated || isPlayerDefeated){
            return true;
        }

        return false;
    }

    public void resetGame(){
        isAllEnemyDefeated = false;
        isPlayerDefeated = false;
        turnList = new ArrayList<>();
        // validar que se hace con Game
    }

    public List<Character> getTurnList(){
        List<Enemy> enemyList = currentGame.getEnemyList();
        List<PlayerCharacter> playerCharacters = Arrays.asList(currentGame.getPlayerCharacter());
        List<Character> turnList = new ArrayList<>();
        for (int i = 0; i < playerCharacters.size(); i++) {
            turnList.add(playerCharacters.get(i));
        }
        for (int i = 0; i < enemyList.size(); i++) {
            turnList.add(enemyList.get(i));
        }
        return turnList;
    }





}
