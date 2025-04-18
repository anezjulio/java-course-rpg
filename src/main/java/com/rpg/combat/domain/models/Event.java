package com.rpg.combat.domain.models;

// Un evento ejecuta una accion, teniendo en cuenta que el "playerTurn" ejecutara una "accion" sobre "target"
public class Event {

    private Action action;
    private Character playerTurn;
    private Character target;

    public Event(Action action, Character playerTurn, Character target) {
        this.action = action;
        this.playerTurn = playerTurn;
        this.target = target;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Character getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Character playerTurn) {
        this.playerTurn = playerTurn;
    }

    public Character getTarget() {
        return target;
    }

    public void setTarget(Character target) {
        this.target = target;
    }

    public String toString(){
        return playerTurn.getName() + " : " + action.getSkillType() + " " + action.getAmount() + " -> " + target.getName() ;
    }
}
