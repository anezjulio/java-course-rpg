package com.rpg.combat.domain.models;

import java.util.List;

public class Enemy extends Character {

    public Enemy(
            String name,
            String role,
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

}
