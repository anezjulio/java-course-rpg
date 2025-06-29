package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.MoveType;

public class Action {

    private MoveType moveType;
    private int amount;

    public Action(int amount, MoveType moveType) {
        this.amount = amount;
        this.moveType = moveType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }
}
