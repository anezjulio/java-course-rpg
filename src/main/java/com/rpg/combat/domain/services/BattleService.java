package com.rpg.combat.domain.services;

import com.rpg.combat.domain.constants.Chapter;
import com.rpg.combat.domain.constants.MoveType;
import com.rpg.combat.domain.models.*;
import com.rpg.combat.domain.models.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleService {

    private static Game currentGame;
    private List<Character> turnList;

    private boolean isAllEnemyDefeated;
    private boolean isPlayerDefeated;

    public boolean isAllEnemyDefeated() {
        return isAllEnemyDefeated;
    }

    public boolean isPlayerDefeated() {
        return isPlayerDefeated;
    }

    public void setCurrentGame(Game game){
        this.currentGame = game;
    }

    public Game getCurrentGame(){
       return currentGame;
    }

    public void nextChapter(){
        switch (currentGame.getChapter()){
            case PROLOGUE: { currentGame.setChapter(Chapter.FIRST); break; }
            case FIRST: { currentGame.setChapter(Chapter.SECOND); break; }
            case SECOND: { currentGame.setChapter(Chapter.THIRD); break; }
            case THIRD: { currentGame.setChapter(Chapter.FOURTH); break; }
            case FOURTH: { currentGame.setChapter(Chapter.FINAL); break; }
            case FINAL: { currentGame.setChapter(Chapter.PROLOGUE); break; }
        }
    }

    public boolean IsTheBattleOver(){
        List<Enemy> enemyList = currentGame.getEnemies();
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

        isAllEnemyDefeated = enemyList.size() == enemiesDefeated;
        isPlayerDefeated = playerCharacters.size() == playerDefeated;

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
        List<Enemy> enemyList = currentGame.getEnemies();
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

    public void executeAction(int actionSelected, Character characterTurn,  int targetSelected) {
        Action action = getActionBySelectedOption(actionSelected);
        if (characterTurn instanceof PlayerCharacter) {
            Enemy target = getSelectedTargetEnemy(targetSelected - 1);
            applyActionToTarget(action, target);

        }
        if (characterTurn instanceof Enemy) {
            PlayerCharacter target = getSelectedTargetPlayerCharacter(targetSelected - 1);
            applyActionToTarget(action, target);

        }
        System.out.println("Ejecucion de la accion..........");
    }
    
    private void applyActionToTarget(Action action, Character characterTarget){
        if(MoveType.DAMAGE == action.getMoveType()){
            characterTarget.doDamage(action.getAmount());
        }
        if(MoveType.HEAL == action.getMoveType()){
            characterTarget.doHeal(action.getAmount());
        }
    }
    

    private Enemy getSelectedTargetEnemy(int targetSelected) {
        return currentGame.getEnemies().get(targetSelected);
    }

    private PlayerCharacter getSelectedTargetPlayerCharacter(int targetSelected) {
        return currentGame.getPlayerCharacter();
    }

    private Action getActionBySelectedOption(int actionSelected){
        PlayerCharacter playerCharacter = currentGame.getPlayerCharacter();
        int maxItems = playerCharacter.getItems().size();
        if (actionSelected < maxItems){
            return playerCharacter.getItems().get(actionSelected - 1);
        } else {
            return playerCharacter.getSkills().get(actionSelected - maxItems - 1);
        }
    }

}
