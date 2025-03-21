package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.Role;

import java.util.List;

public class Character {

    private String name;
    private Role role;
    private int level;
    private int experience;
    private int damage;
    private int hpCurrent;
    private int hpMax;
    private int mpCurrent;
    private int mpMax;
    private List<Skill> skills;
    private List<Item> items;

    public Character(String name, Role role, int level, int experience, int damage, int hpCurrent, int hpMax, int mpCurrent, int mpMax, List<Skill> skills, List<Item> items) {
        this.name = name;
        this.role = role;
        this.level = level;
        this.experience = experience;
        this.damage = damage;
        this.hpCurrent = hpCurrent;
        this.hpMax = hpMax;
        this.mpCurrent = mpCurrent;
        this.mpMax = mpMax;
        this.skills = skills;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getDamage() {
        return damage;
    }

    public int getHpCurrent() {
        return hpCurrent;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getMpCurrent() {
        return mpCurrent;
    }

    public int getMpMax() {
        return mpMax;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public List<Item> getItems() {
        return items;
    }
}
