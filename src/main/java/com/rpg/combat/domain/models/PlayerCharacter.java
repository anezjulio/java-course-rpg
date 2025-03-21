package com.rpg.combat.domain.models;


import java.util.List;

public class PlayerCharacter extends Character {

    private int nextLevelExperienceRequired;

    public PlayerCharacter
            (
            String name,
            String role,
            int level,
            int experience,
            int nextLevelExperienceRequired,
            int damage,
            int hpCurrent,
            int hpMax,
            int mpCurrent,
            int mpMax,
            List<Skill> skills,
            List<Item> items
    ) {
        super(name, role, level, experience, damage, hpCurrent, hpMax, mpCurrent, mpMax, skills, items);
        this.nextLevelExperienceRequired = nextLevelExperienceRequired;
    }

    public int getNextLevelExperienceRequired() {
        return nextLevelExperienceRequired;
    }

    public void setNextLevelExperienceRequired(int nextLevelExperienceRequired) {
        this.nextLevelExperienceRequired = nextLevelExperienceRequired;
    }
}
