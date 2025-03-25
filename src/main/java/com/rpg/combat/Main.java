package com.rpg.combat;


import com.rpg.combat.application.handler.ContinueHandler;
import com.rpg.combat.application.handler.MenuHandler;
import com.rpg.combat.application.handler.NewProfileHandler;
import com.rpg.combat.domain.constants.Role;
import com.rpg.combat.domain.constants.SkillType;
import com.rpg.combat.domain.models.Character;
import com.rpg.combat.domain.models.Item;
import com.rpg.combat.domain.models.Skill;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.GameScreenManager;
import com.rpg.combat.infraestructure.output.screen.ContinueScreen;
import com.rpg.combat.infraestructure.output.screen.MenuScreen;
import com.rpg.combat.infraestructure.persistence.GameRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Declare dependencies
    private static MenuHandler menuHandler;
    private static ContinueHandler continueHandler;
    private static NewProfileHandler newProfileHandler;

    private static MenuScreen menuScreen;
    private static ContinueScreen continueScreen;

    private static GameRepository gameRepository;

    private static ConsoleInput consoleInput;
    private static ConsoleUI consoleUI;


    public static void main(String[] args) {

        GameScreenManager gameScreenManager = new GameScreenManager(Main.getMenuHandler());
        gameScreenManager.startGame();

    }

    // Lazy initialization - Inicialización perezosa
    // Decision Tecnica/Mala practica
    // Hacer los método público: Solución rápida,
    // pero expone el acceso a las dependencias desde
    // cualquier parte del código, lo que puede no ser ideal.

    public static ConsoleInput getConsoleInput() {
        if (consoleInput == null) {
            consoleInput = new ConsoleInput();
        }
        return consoleInput;
    }

    public static ConsoleUI getConsoleUI() {
        if (consoleUI == null) {
            consoleUI = new ConsoleUI();
        }
        return consoleUI;
    }
    public static MenuHandler getMenuHandler() {
        if (menuHandler == null) {
            menuHandler = new MenuHandler(getMenuScreen(), getConsoleInput(), getConsoleUI());
        }
        return menuHandler;
    }

    public static GameRepository getGameRepository() {
        if (gameRepository == null) {
            gameRepository = new GameRepository();
        }
        return gameRepository;
    }

    public static ContinueScreen getContinueScreen() {
        if (continueScreen == null) {
            continueScreen = new ContinueScreen(getConsoleUI());
        }
        return continueScreen;
    }


    public static ContinueHandler getContinueHandler() {
        if (continueHandler == null) {
            continueHandler = new ContinueHandler(getGameRepository(), getContinueScreen(), getConsoleInput(), getConsoleUI());
        }
        return continueHandler;
    }

    public static NewProfileHandler getNewProfileHandler() {
        if (newProfileHandler == null) {
            newProfileHandler = new NewProfileHandler();
        }
        return newProfileHandler;
    }

    public static MenuScreen getMenuScreen() {
        if (menuScreen == null) {
            menuScreen = new MenuScreen(getConsoleUI());
        }
        return menuScreen;
    }


    // TODO: Borrar esta clase luego, la tenemos solo por vaguesa
    public static void testCode() {
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

}

