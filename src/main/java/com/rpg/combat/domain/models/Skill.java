package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.SkillType;

public class Skill extends Action {

    private String name;
    private String description;
    private int manaRequired;

    public Skill(int amount, SkillType skillType, String name, String description, int manaRequired) {
        super(amount, skillType);
        this.name = name;
        this.description = description;
        this.manaRequired = manaRequired;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getManaRequired() {
        return manaRequired;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setManaRequired(int manaRequired) {
        this.manaRequired = manaRequired;
    }

    // slash: hace x daño al enemigo
    // stab: hace x daño al enemigo
    // double attack hace x daño al enemigo
    // iceball: hace x daño al enemigo
    // windcut: hace x daño al enemigo
    // thunder: hace x daño al enemigo
    // fireball: hace x daño al enemigo
    // heal: cura x cantidad de hp a un personaje (el mismo)


}
