package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.SkillType;

public class Move {

    private int amount;
    private SkillType skillType;

    public Move(int amount, SkillType skillType) {
        this.amount = amount;
        this.skillType = skillType;
    }

    public int getAmount() {
        return amount;
    }

    public SkillType getSkillType() {
        return skillType;
    }

}
