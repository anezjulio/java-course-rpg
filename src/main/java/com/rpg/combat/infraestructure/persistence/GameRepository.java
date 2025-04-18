package com.rpg.combat.infraestructure.persistence;

import com.rpg.combat.domain.constants.Chapter;
import com.rpg.combat.domain.constants.Role;
import com.rpg.combat.domain.constants.SkillType;
import com.rpg.combat.domain.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameRepository {

    public static List<Game> getGames(){
        List<Game> saveGames = getGamesFromDatabase();
        return saveGames;
    }

    private static List<Game> getGamesFromDatabase(){

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
                        1,
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
                        2,
                        200,
                        60,
                        290,
                        400,
                        100,
                        100,
                        skills,
                        items
                );

        PlayerCharacter buba = new PlayerCharacter(
                "BUBA",
                Role.MAGE,
                1,
                10,
                20,
                11,
                100,
                100,
                100,
                100,
                skills,
                items);

        PlayerCharacter gump = new PlayerCharacter(
                "GUMP",
                Role.WARRIOR,
                1,
                10,
                20,
                11,
                100,
                100,
                100,
                100,
                skills,
                items);

        Action dano = new Action(30, SkillType.DAMAGE);
        Action curar = new Action(30, SkillType.HEAL);
        Event event1 = new Event(dano, buba, pudge);
        Event event2 = new Event(curar, buba, gump);
        List<Event> events = new ArrayList<>();
        events.add(event1);
        events.add(event2);

        Game partidaDePrueba = new Game(
                //Crea una fecha con la hora, dia, minuto,segundo actual
                LocalDateTime.now(),
                "wolfcross",
                0,
                0,
                buba,
                Arrays.asList(pudge, visage),
                Chapter.FIRST,
                events,
                null);

        Game partidaDePrueba2 = new Game(
                //Crea una fecha con la hora, dia, minuto,segundo actual
                LocalDateTime.now(),
                "dulceDeGuayaba",
                0,
                0,
                gump,
                Arrays.asList(visage,pudge, pudge),
                Chapter.SECOND,
                events,
                null);

        return new ArrayList<>(Arrays.asList(partidaDePrueba, partidaDePrueba2));
    }

}
