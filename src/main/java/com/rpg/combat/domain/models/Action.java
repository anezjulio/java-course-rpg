package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.SkillType;

public class Action {

    private SkillType skillType;
    private int amount;

    public Action(int amount, SkillType skillType) {
        this.amount = amount;
        this.skillType = skillType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }
}
