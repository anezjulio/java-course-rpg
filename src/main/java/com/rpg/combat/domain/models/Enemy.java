package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.Role;

import java.util.List;

public class Enemy extends Character {

    public Enemy(
            String name,
            Role role,
            int level,
            int experience,
            int damage,
            int hpCurrent,
            int hpMax,
            int mpCurrent,
            int mpMax,
            List<Skill> skills,
            List<Item> items
    ) {
        super(name, role, level, experience, damage, hpCurrent, hpMax, mpCurrent, mpMax, skills, items);
    }

    public Enemy(Enemy enemy) {
        super(
                enemy.getName(),
                enemy.getRole(),
                enemy.getLevel(),
                enemy.getExperience(),
                enemy.getDamage(),
                enemy.getHpCurrent(),
                enemy.getHpMax(),
                enemy.getMpCurrent(),
                enemy.getMpMax(),
                enemy.getSkills(),
                enemy.getItems());
    }
}
