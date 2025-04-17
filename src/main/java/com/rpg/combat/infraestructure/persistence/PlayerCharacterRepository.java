package com.rpg.combat.infraestructure.persistence;

import com.rpg.combat.domain.constants.Role;
import com.rpg.combat.domain.constants.SkillType;
import com.rpg.combat.domain.models.Item;
import com.rpg.combat.domain.models.PlayerCharacter;
import com.rpg.combat.domain.models.Skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerCharacterRepository {

    public static List<PlayerCharacter> getPlayerCharacter() {
        return getplayerCharacterslist();
    }

    public static List<PlayerCharacter> getplayerCharacterslist() {

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
        PlayerCharacter mage =
                new PlayerCharacter(
                        "Miguel",
                        Role.MAGE,
                        0,
                        0,
                        200,
                        11,
                        100,
                        100,
                        100,
                        100,
                        skills,
                        items
                );

        PlayerCharacter warrior =
                new PlayerCharacter(
                        "ñemo",
                        Role.WARRIOR,
                        0,
                        0,
                        200,
                        11,
                        100,
                        100,
                        100,
                        100,
                        skills,
                        items
                );

        return new ArrayList<>(Arrays.asList(mage, warrior));

    }

}
