package com.rpg.combat;


import com.rpg.combat.application.screen.MenuScreen;
import com.rpg.combat.domain.constants.Role;
import com.rpg.combat.domain.constants.SkillType;
import com.rpg.combat.domain.models.Item;
import com.rpg.combat.domain.models.Character;
import com.rpg.combat.domain.models.Skill;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        startGame();

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
        Character mage =
                new Character(
                        "Miguel",
                        Role.MAGE,
                        0,
                        0,
                        11,
                        100,
                        100,
                        100,
                        100,
                        skills,
                        items
                );

        //Action Damage = new Action("daño hecho 20",

//        System.out.println(
//                "name: " + sword.getName() +
//                        " description: " + sword.getDescription() +
//                        " SkillType: " + sword.getSkillType() +
//                        " OutputValue: " + sword.getAmount() +
//                        " remainUses: " + sword.getUseAmount());
//        sword.useItem();
//        System.out.println(
//                "name: " + sword.getName() +
//                        " description: " + sword.getDescription() +
//                        " SkillType: " + sword.getSkillType() +
//                        " OutputValue: " + sword.getAmount() +
//                        " remainUses: " + sword.getUseAmount());
//
//
//        System.out.println(
//                "name: " + dagger.getName() +
//                        " description: " + dagger.getDescription() +
//                        " SkillType: " + dagger.getSkillType() +
//                        " OutputValue: " + dagger.getAmount() +
//                        " remainUses: " + dagger.getUseAmount());
//        dagger.useItem();
//        System.out.println(
//                "name: " + dagger.getName() +
//                        " description: " + dagger.getDescription() +
//                        " SkillType: " + dagger.getSkillType() +
//                        " OutputValue: " + dagger.getAmount() +
//                        " remainUses: " + dagger.getUseAmount());


//        int numero = ConsoleAdapter.read();
//        System.out.println("Número ingresado: " + numero);

    }

    public static void startGame() {
        // LLamar a la pantalla principal (MenuScreem)
        MenuScreen menu = new MenuScreen();
        menu.loadScreen();
    }

}

