package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.constants.Chapter;
import com.rpg.combat.domain.constants.Role;
import com.rpg.combat.domain.models.Game;
import com.rpg.combat.domain.models.PlayerCharacter;
import com.rpg.combat.domain.models.TemplateTag;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadGameScreen implements Screen {

    @Override
    public String[] getTemplate() {
        String[] template = {
            "--------------------------------------------------",
            "                   Load Game",
            "--------------------------------------------------",
            "",
            "<listaDePartidas>",
            "",
            "",
            "",
            "           Seleccione:",
        };
       return template;
    }

    @Override
    public void show() {
        // cargo el / los tags
        TemplateTag tag = getGamesListTag();

        String[] textToShow = replaceTemplateTags(new ArrayList<>(Arrays.asList(tag)));

        for (String line : textToShow) {
            System.out.println(line);
        }
    }


    private TemplateTag getGamesListTag() {
        String nombreDelTag = "<listaDePartidas>";
        List<String> templateAReemplazar = new ArrayList<>();

        // TODO: pasar este formmater a una clase utils dentro de un package common a nivel de infraestructure
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");

        for (int i = 0; i < listaDepartidasDePrueba.size(); i++) {
            templateAReemplazar.add((i + 1) + ". Game"+ "\n");
            templateAReemplazar.add("--- --- --- --- --- --- --- --- --- --- --- --- ---"+ "\n");
            templateAReemplazar.add("Fecha: " + listaDepartidasDePrueba.get(i).getStartDateTime().format(formatter)+ "\n");
            templateAReemplazar.add("UserName: " + listaDepartidasDePrueba.get(i).getName()+ "\n");
            templateAReemplazar.add("Chapter: " + listaDepartidasDePrueba.get(i).getChapter().name()+ "\n");
            templateAReemplazar.add("PlayerCharacter: " + listaDepartidasDePrueba.get(i).getPlayerCharacter().getName()+ "\n");
            templateAReemplazar.add("Role: " + listaDepartidasDePrueba.get(i).getPlayerCharacter().getRole()+ "\n");
            templateAReemplazar.add("UserName: " + listaDepartidasDePrueba.get(i).getName()+ "\n");
            templateAReemplazar.add("--- --- --- --- --- --- --- --- --- --- --- --- ---"+ "\n");
            templateAReemplazar.add(""+ "\n");
        }
        return new TemplateTag(nombreDelTag, templateAReemplazar.toArray(new String[0]));
    }



    public Game partidaDePrueba = new Game(
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
    public Game partidaDePrueba2 = new Game(
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

    public List<Game> listaDepartidasDePrueba = new ArrayList<>(Arrays.asList(partidaDePrueba, partidaDePrueba2));


}
