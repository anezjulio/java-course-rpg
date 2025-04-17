package com.rpg.combat.infraestructure.persistence;

import com.rpg.combat.domain.constants.Role;
import com.rpg.combat.domain.constants.SkillType;
import com.rpg.combat.domain.models.Enemy;
import com.rpg.combat.domain.models.Item;
import com.rpg.combat.domain.models.PlayerCharacter;
import com.rpg.combat.domain.models.Skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnemyRepository {


    public static List<Enemy> getEnemies() {
        return getEnemyList();
    }

    public static List<Enemy> getEnemyList() {

        Item sword = new Item("sword", "normal sword", 11, 20, SkillType.DAMAGE);
        Item dagger = new Item("dagger", "normal dagger", 15, 20, SkillType.DAMAGE);
        List<Item> items = new ArrayList<Item>();
        items.add(sword);
        items.add(dagger);
        List<Skill> skills = new ArrayList<Skill>();
        Skill fireball = new Skill(15, SkillType.DAMAGE, "fireball", "shot a fireball", 30);
        Skill thunderbolt = new Skill(20, SkillType.DAMAGE, "thunderbolt", "shot a thunderbolt", 50);
        Skill heal = new Skill(50, SkillType.HEAL, "Heal", "Heal", 50);
        skills.add(fireball);
        skills.add(thunderbolt);
        skills.add(heal);

        Enemy pudge =
                new Enemy(
                        "PudgeSinBlink",
                        Role.WARRIOR,
                        0,
                        100,
                        50,
                        290,
                        300,
                        100,
                        100,
                        skills,
                        items
                );

        Enemy visage =
                new Enemy(
                        "VisageMiguel",
                        Role.MAGE,
                        0,
                        200,
                        60,
                        290,
                        400,
                        100,
                        100,
                        skills,
                        items
                );

        return new ArrayList<>(Arrays.asList(pudge, visage));

    }

}
