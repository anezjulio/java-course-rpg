package com.rpg.combat.domain.models;

public class Action {

    // messaje = target.name, move.skillType, target HP
    //         = soldado recibio 40 damage
    //         = soldado se curo 40 hp

    private String message;
    private Character target;
    private Move move;

    public Action(String message,Character target,Move move) {
        this.message = message;
        this.target = target;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }


    // ejecutar accion
    /*
    *
    *
    *
    *
    *
    * */

}
