package com.rpg.combat.infraestructure.persistence;

import com.rpg.combat.domain.constants.Chapter;
import com.rpg.combat.domain.constants.Role;
import com.rpg.combat.domain.models.Game;
import com.rpg.combat.domain.models.PlayerCharacter;

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

        Game partidaDePrueba = new Game(
                //Crea una fecha con la hora, dia, minuto,segundo actual
                LocalDateTime.now(),
                "wolfcross",
                new PlayerCharacter(
                        "BUBA",
                        Role.MAGE,
                        0,
                        10,
                        20,
                        11,
                        100,
                        100,
                        100,
                        100,
                        new ArrayList<>(),
                        new ArrayList<>()),
                Chapter.FIRST,
                null,
                null);

        Game partidaDePrueba2 = new Game(
                //Crea una fecha con la hora, dia, minuto,segundo actual
                LocalDateTime.now(),
                "dulceDeGuayaba",
                new PlayerCharacter(
                        "GUMP",
                        Role.WARRIOR,
                        0,
                        10,
                        20,
                        11,
                        100,
                        100,
                        100,
                        100,
                        new ArrayList<>(),
                        new ArrayList<>()),
                Chapter.FIRST,
                null,
                null);

        return new ArrayList<>(Arrays.asList(partidaDePrueba, partidaDePrueba2));
    }

}
